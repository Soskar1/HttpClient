package core;

import core.requests.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest exampleRequest = new HeadHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");

        HttpRequest httpBinGet = new GetHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/get");
        HttpRequest httpBinPost = new PostHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/post", "Hello, World!");
        HttpRequest httpBinPut = new PutHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/put", "Hello, World!");

        HttpResponse response = client.send(httpBinPut);
        System.out.print(response.toString());
    }
}