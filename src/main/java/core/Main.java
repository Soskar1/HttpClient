package core;

import core.requests.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest get = new GetHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest head = new HeadHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");
        HttpRequest post = new PostHttpRequest("ptsv3.com", HttpVersion.HTTP_11, "/t/10001/post/", "Hello, World!");
        HttpRequest put = new PutHttpRequest("ptsv3.com", HttpVersion.HTTP_11, "/t/10001/post/", "Hello, World!");

        HttpResponse response = client.send(post);
        System.out.print(response.toString());
    }
}