package core;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest exampleRequest = new HttpRequest("www.example.com", HttpVersion.HTTP_11);
        HttpRequest googleRequest = new HttpRequest("www.google.com", HttpVersion.HTTP_11);

        client.send(exampleRequest);
    }
}