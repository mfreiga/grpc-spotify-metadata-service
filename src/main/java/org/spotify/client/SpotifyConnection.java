package org.spotify.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.spotify.grpc.MetadataServiceGrpc;

import java.net.Socket;

public class SpotifyConnection {
    private final int serverPort = 9010;
    private MetadataServiceGrpc.MetadataServiceBlockingStub stub;

    public SpotifyConnection() throws SpotifyClientException {
        this.healthcheck();

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", this.serverPort)
                .usePlaintext()
                .build();

        this.stub = MetadataServiceGrpc.newBlockingStub(channel);
    }

    public SpotifyConnection(Channel channel) {
        this.stub = MetadataServiceGrpc.newBlockingStub(channel);
    }
    @SuppressWarnings("unused")
    public MetadataServiceGrpc.MetadataServiceBlockingStub getStub() {
        return this.stub;
    }

    private void healthcheck() throws SpotifyClientException {
        try {
            Socket check = new Socket("localhost", this.serverPort);
            check.close();
        } catch (Exception e) {
            throw new SpotifyClientException("Failed to connect to the metadata service. Make sure to start it.");
        }
    }
}