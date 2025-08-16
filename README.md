# Spotify Metadata gRPC Service

This project provides a gRPC-based metadata service for Spotify albums, implemented in Java. It includes a server, client, and database layer, with protobuf definitions for the service API.Protobuf defines the schema; a simple in-memory DB backs the server.

## Project Structure

- `src/main/proto/spotify.proto`  
  Protobuf definitions for the gRPC service.

- `src/main/java/org/spotify/server/MetadataServer.java`  
  Main entry point for running the gRPC server.

- `src/main/java/org/spotify/server/MetadataServiceImpl.java`  
  Implementation of the gRPC service methods.

- `src/main/java/org/spotify/client/SpotifyClient.java`  
  Example client for interacting with the metadata service.

- `src/main/java/org/spotify/client/SpotifyConnection.java`  
  Handles client-side connection logic.

- `src/main/java/org/spotify/client/SpotifyClientException.java`  
  Custom exception for client errors.

- `src/main/java/org/spotify/db/Database.java`  
  Database abstraction for storing and retrieving album metadata.



### Prerequisites

- Java 11+
- Gradle

### Build

```sh
./gradlew build
```

### Run the Server
run the main class directly:
```sh
java -cp build/libs/<your-jar>.jar org.spotify.server.MetadataServer
```

### Generate Protobuf Classes

Protobuf classes are generated automatically during build. To regenerate manually (you may need to generate Proto file at first and after each change):
```sh
./gradlew generateProto
```

### Run the Client

See [`SpotifyClient.java`](src/main/java/org/spotify/client/SpotifyClient.java) for usage examples.

## Protobuf API

See [`spotify.proto`](src/main/proto/spotify.proto) for service and message definitions.

