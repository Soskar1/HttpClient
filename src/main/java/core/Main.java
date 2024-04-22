package core;

import core.requests.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpClient client = new HttpClient();
        HttpRequest exampleRequest = new GetHttpRequest("www.example.com", HttpVersion.HTTP_11, "/index.html");

        HttpRequest httpBinGet = new GetHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/get");
        HttpRequest httpBinPost = new PostHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/post", "Hello, World!");
        HttpRequest httpBinPut = new PutHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/put", "Hello, World!");
        HttpRequest httpBinDelete = new DeleteHttpRequest("httpbin.org", HttpVersion.HTTP_11, "/delete");

        HttpRequest post = new PostHttpRequest("ptsv3.com", HttpVersion.HTTP_11, "/t/10001/post/test.txt", "Hello, World!");

        HttpResponse response = client.send(exampleRequest);
        System.out.print(response.toString());
    }
}