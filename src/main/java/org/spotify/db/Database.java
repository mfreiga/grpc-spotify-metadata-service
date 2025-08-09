package org.spotify.db;

 import com.google.protobuf.InvalidProtocolBufferException;
 import com.google.protobuf.util.JsonFormat;
 import org.spotify.grpc.Album;
 import org.spotify.grpc.Track;
import java.util.Map;

public class Database {
    private final Map<Integer, Track> tracks;

    private final Map<Integer, String> albums;
    @SuppressWarnings("unused")
    public Database(Map<Integer, Track> tracks, Map<Integer, String> albums) {
        this.tracks = tracks;
        this.albums = albums;
    }

    public Database() {
        tracks = Map.ofEntries(
                Map.entry(10358, Track.newBuilder().setId(10358).setName("Jagen die Mio").setAlbum("Locosquad präsentiert: 12812").setArtist("Luciano").setDuration(183).build()),
                Map.entry(55481, Track.newBuilder().setId(55481).setName("nature song").setAlbum("naked sunshine").setArtist("Shanin Blake").setDuration(180).build()),
                Map.entry(20319, Track.newBuilder().setId(20319).setName("Sky").setAlbum("Whole Lotta Red").setArtist("Playboi Carti").setDuration(193).build()),
                Map.entry(17503, Track.newBuilder().setId(17503).setName("Ich bin ein Berliner").setAlbum("Ich bin ein Berliner").setArtist("Ufo361").setDuration(273).build()),
                Map.entry(62418, Track.newBuilder().setId(62418).setName("Head Over Heels").setAlbum("The Visitors").setArtist("ABBA").setDuration(288).build()),
                Map.entry(11897, Track.newBuilder().setId(11897).setName("Schalke").setAlbum("Schalke").setArtist("Moneyboy").setDuration(120).build()),
                Map.entry(82763, Track.newBuilder().setId(82763).setName("6 for 6").setAlbum("Wild West").setArtist("Central Cee").setDuration(148).build()),
                Map.entry(83834, Track.newBuilder().setId(83834).setName("Emotions").setAlbum("Emotions").setArtist("Brenda Lee").setDuration(171).build()),
                Map.entry(2791, Track.newBuilder().setId(2791).setName("Ginseng Strip 2002").setAlbum("Lavender").setArtist("Yung Lean").setDuration(153).build()),
                Map.entry(52085, Track.newBuilder().setId(52085).setName("2 Handys").setAlbum("2 Handys").setArtist("Gola Gianni").setDuration(139).build()),
                Map.entry(61703, Track.newBuilder().setId(61703).setName("Sure of Love").setAlbum("We Are the Chantels").setArtist("The Chantels").setDuration(147).build()),
                Map.entry(62523, Track.newBuilder().setId(62523).setName("Nun id change").setAlbum("Aftërlife").setArtist("Yeat").setDuration(211).build()),
                Map.entry(4571, Track.newBuilder().setId(4571).setName("Chicago").setAlbum("XSCAPE").setArtist("Michael Jackson").setDuration(245).build()),
                Map.entry(2746, Track.newBuilder().setId(2746).setName("Just Wanna Rock").setAlbum("Just Wanna Rock").setArtist("Lil Uzi Vert").setDuration(123).build()),
                Map.entry(36550, Track.newBuilder().setId(36550).setName("Stole the Show").setAlbum("CloudNine").setArtist("Kygo").setDuration(223).build()),
                Map.entry(29254, Track.newBuilder().setId(29254).setName("Nonstop").setAlbum("Scorpion").setArtist("Drake").setDuration(238).build()),
                Map.entry(80673, Track.newBuilder().setId(80673).setName("Dans På Bordet").setAlbum("Dans På Bordet").setArtist("Ballinciaga").setDuration(143).build()),
                Map.entry(12962, Track.newBuilder().setId(12962).setName("Dawn FM").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(93).build()),
                Map.entry(37588, Track.newBuilder().setId(37588).setName("Gasoline").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(212).build()),
                Map.entry(28030, Track.newBuilder().setId(28030).setName("How Do I Make You Love Me?").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(214).build()),
                Map.entry(95523, Track.newBuilder().setId(95523).setName("Take My Breath").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(339).build()),
                Map.entry(47333, Track.newBuilder().setId(47333).setName("Sacrifice").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(188).build()),
                Map.entry(92840, Track.newBuilder().setId(92840).setName("A Tale By Quincy").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(96).build()),
                Map.entry(79133, Track.newBuilder().setId(79133).setName("Out of Time").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(214).build()),
                Map.entry(14426, Track.newBuilder().setId(14426).setName("Here We Go... Again (feat. Tyler, The Creator)").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(209).build()),
                Map.entry(83392, Track.newBuilder().setId(83392).setName("Best Friends").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(163).build()),
                Map.entry(45747, Track.newBuilder().setId(45747).setName("Is There Someone Else?").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(199).build()),
                Map.entry(14204, Track.newBuilder().setId(14204).setName("Starry Eyes").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(148).build()),
                Map.entry(13276, Track.newBuilder().setId(13276).setName("Every Angel is Terrifying").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(167).build()),
                Map.entry(53884, Track.newBuilder().setId(53884).setName("Don't Break My Heart").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(205).build()),
                Map.entry(31036, Track.newBuilder().setId(31036).setName("I Heard You're Married (feat. Lil Wayne)").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(263).build()),
                Map.entry(97264, Track.newBuilder().setId(97264).setName("Less Than Zero").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(211).build()),
                Map.entry(65262, Track.newBuilder().setId(65262).setName("Phantom Regret by Jim").setAlbum("Dawn FM").setArtist("The Weeknd").setDuration(179).build()),
                Map.entry(65989, Track.newBuilder().setId(65989).setName("Berlin lebt").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(183).build()),
                Map.entry(46583, Track.newBuilder().setId(46583).setName("Kennzeichen B-TK").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(160).build()),
                Map.entry(26584, Track.newBuilder().setId(26584).setName("Giselle Bünchen").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(204).build()),
                Map.entry(5516, Track.newBuilder().setId(5516).setName("Neymar").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(263).build()),
                Map.entry(71408, Track.newBuilder().setId(71408).setName("5 Songs in einer Nacht").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(147).build()),
                Map.entry(30112, Track.newBuilder().setId(30112).setName("Gutes Herz").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(192).build()),
                Map.entry(41385, Track.newBuilder().setId(41385).setName("Panzer, Tiger").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(166).build()),
                Map.entry(32319, Track.newBuilder().setId(32319).setName("Ballert").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(172).build()),
                Map.entry(27084, Track.newBuilder().setId(27084).setName("Baba Flow").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(185).build()),
                Map.entry(49775, Track.newBuilder().setId(49775).setName("Darby").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(201).build()),
                Map.entry(31750, Track.newBuilder().setId(31750).setName("One Night Stand").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(162).build()),
                Map.entry(57216, Track.newBuilder().setId(57216).setName("Packen").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(232).build()),
                Map.entry(98923, Track.newBuilder().setId(98923).setName("Glaub mir").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(183).build()),
                Map.entry(62173, Track.newBuilder().setId(62173).setName("Meine Welt").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(162).build()),
                Map.entry(4738, Track.newBuilder().setId(4738).setName("Wann dann").setAlbum("Berlin lebt").setArtist("Capital Bra").setDuration(189).build())
        );
        albums = Map.ofEntries(
                Map.entry(24534,
                    "{"
                      + "\"id\": \"97369\","
                      + "\"name\": \"Berlin lebt\","
                      + "\"artist\": \"Capital Bra\","
                      + "\"tracks\": [65989, 46583, 26584, 5516, 71408, 30112, 41385, 32319, 27084, 49775, 31750, 57216, 98923, 62173, 4738]"
                      + "}"
                    ),
                Map.entry(97369,  "{"
                        + "\"id\": \"97369\","
                        + "\"name\": \"Berlin lebt\","
                        + "\"artist\": \"Capital Bra\","
                        + "\"tracks\": [65989, 46583, 26584, 5516, 71408, 30112, 41385, 32319, 27084, 49775, 31750, 57216, 98923, 62173, 4738]"
                        + "}"
                    )
        );
    }

    public Track findTrackById(int id) {
        return tracks.get(id);
    }

    //   TODO: Uncomment the function below after you've created the Protobuf definitions for Album in spotify.proto
    //   NOTE: Also uncomment the two imports at the top of this file for this function to work

    public Album findAlbumById(int id) {
        try {
            Album.Builder albumBuilder = Album.newBuilder();
            String albumJson = albums.get(id);

            JsonFormat.parser().ignoringUnknownFields().merge(albumJson, albumBuilder);
            return albumBuilder.build();
        } catch (InvalidProtocolBufferException e) {
            return null;
        }
    }
}