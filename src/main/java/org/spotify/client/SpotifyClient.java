package org.spotify.client;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import org.spotify.db.Database;
import org.spotify.grpc.*;

import java.util.*;
import java.util.stream.Collectors;

public class SpotifyClient {
    @SuppressWarnings("unused")
    private final SpotifyConnection spotifyConnection;

    @SuppressWarnings("unused")
    public SpotifyClient(Channel channel) {
        this.spotifyConnection = new SpotifyConnection(channel);
    }

    public SpotifyClient() throws SpotifyClientException {
        this.spotifyConnection = new SpotifyConnection();
    }

    public String displayPlaylist(int[] playlist) throws SpotifyClientException {
        // TODO: Implement displayPlaylist
        //takes in array of track ids and return easy to read view of playlist
        //first get info about tracks using the getTrackMetadata grpc method
        var stub = spotifyConnection.getStub();

            //add each id to builder then build request
            StringBuilder answer = new StringBuilder();
            EntitiesRequest.Builder temp = EntitiesRequest.newBuilder();

            for (int trackId : playlist){
                temp.addId(trackId);

            }

            EntitiesRequest request = temp.build();

            Tracks response;
        try {
            response = stub.getTrackMetadata(request);

            if (playlist.length > 0 && response.getTrackCount() == 0) {
                throw new SpotifyClientException("Failed to get track metadata");
            }

            // check if nonexistent id is given to list
            Set<Long> listId = new HashSet<>();
            //List<Long> listId = new ArrayList<>();
            for (int i = 0; i < response.getTrackCount(); i++) {
                listId.add(response.getTrack(i).getId());
            }
            for (int trackId : playlist) {
                long idL = (long) trackId;
                if (!listId.contains(idL)) {
                    throw new SpotifyClientException("Failed to get track metadata");
                }

            }


            for (int i = 0; i < response.getTrackCount(); i++) {
                int number = i + 1;
                String trackName = response.getTrack(i).getName();
                String artistName = response.getTrack(i).getArtist();
                int secondsD = response.getTrack(i).getDuration();

                answer.append(number + ". " + trackName + " - " + artistName + " (" + durationFormat(secondsD) + ")\n");

            }
            return answer.toString();
        }catch (Throwable t){
            throw new SpotifyClientException("Failed to get track metadata");
        }

    }

    // helper method for duration
    public String durationFormat (int seconds){
        String formatted;
        int minutes = seconds / 60;
        int restSeconds = seconds % 60;

        // 4 cases: seconds = 0 , seconds < 10, seconds >= 10 , duration = 0
        if (seconds == 0){
            formatted = "0:00";
        }
        else if (restSeconds == 0) {
            formatted = minutes + ":" + "00";
        } else if (restSeconds < 10) {
            formatted = minutes + ":0" + restSeconds;
        } else {
            formatted = minutes + ":" + restSeconds;
        }
        return formatted;
    }


    public String displayAlbum(int id) throws SpotifyClientException {
        // TODO: Implement displayAlbum
        // need to calculate total duration of album
        // also display each duration of each track
        var stub = spotifyConnection.getStub();
        StringBuilder result = new StringBuilder();

        EntitiesRequest request = EntitiesRequest.newBuilder().addId(id).build();

        try {
            Albums response = stub.getAlbumMetadata(request);

            // just one album then only 1 album in the response
            Album currA = response.getAlbum(0);


            //this is all i need from the Album all other info from the tracks
            var albumName = currA.getName();

            // i need to get the track metadata for the tracks
            EntitiesRequest.Builder tracksReq = EntitiesRequest.newBuilder();
            for (int i = 0; i < currA.getTracksCount(); i++) {
                tracksReq.addId(currA.getTracks(i));
            }
            EntitiesRequest request2 = tracksReq.build();
            Tracks response2 = stub.getTrackMetadata(request2);

            // need to calculate total duration
            var totalDur = 0;
            for (int i = 0; i < response2.getTrackCount(); i++) {
                Track trackTemp = response2.getTrack(i);
                totalDur += trackTemp.getDuration();
            }

            StringBuilder trackOutput = new StringBuilder();
            for (int i = 0; i < response2.getTrackCount(); i++) {
                int number = i + 1;
                String trackName = response2.getTrack(i).getName();
                String artistName = response2.getTrack(i).getArtist();
                int secondsD = response2.getTrack(i).getDuration();

                trackOutput.append("\t" + number + ". " + trackName + " - " + artistName + " (" + durationFormat(secondsD) + ")\n");
            }

            result.append(albumName + " (" + durationFormat(totalDur) + ")" + "\n");
            result.append(trackOutput);
            return result.toString();
        } catch (Throwable t){
            throw new SpotifyClientException("Failed to get album metadata");
        }

    }

    public static void main(String[] args) throws SpotifyClientException {
        SpotifyClient client = new SpotifyClient();

        // Examples from Artemis
         //System.out.println(client.displayPlaylist(new int[] {82763, 2791, 80673, 62523, 61703}));

        // System.out.println(client.displayAlbum(24534));
    }
}
