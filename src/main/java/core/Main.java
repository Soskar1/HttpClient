package core;

import core.requests.GetHttpRequest;
import core.requests.HttpRequest;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest exampleRequest = new GetHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest googleRequest = new GetHttpRequest("www.google.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest w3docs = new GetHttpRequest("www.w3docs.com", HttpVersion.HTTP_11, "/index.html");

        HttpResponse response = client.send(exampleRequest);
        System.out.print(response.toString());
    }
}