package core;

import core.requests.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest exampleRequest = new HeadHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest googleRequest = new GetHttpRequest("www.google.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest w3docs = new GetHttpRequest("www.w3docs.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest youtube = new GetHttpRequest("www.youtube.com", HttpVersion.HTTP_11, "/index.html");

        HttpResponse response = client.send(exampleRequest);
        System.out.print(response.toString());
    }
}