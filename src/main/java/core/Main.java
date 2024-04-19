package core;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest request = new HttpRequest("www.example.com");

        client.send(request);
    }
}