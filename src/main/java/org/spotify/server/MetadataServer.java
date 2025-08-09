package org.spotify.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MetadataServer {
        public static void main(String[] args) throws IOException, InterruptedException {
            Server server = ServerBuilder
                    .forPort(9010)
                    .addService(new MetadataServiceImpl()).build();

            server.start();

            System.out.println("Started Track Metadata Service");

            server.awaitTermination();
        }
}
