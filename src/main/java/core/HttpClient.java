package core;

import core.headers.HeaderFactory;
import core.headers.HttpHeader;
import core.requests.HttpRequest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient {
    private final Pattern httpVersionPattern;
    private final Pattern statusCodePattern;

    public HttpClient() {
        httpVersionPattern = Pattern.compile("^HTTP/(0\\.9|1\\.0|1\\.1|2|3)");
        statusCodePattern = Pattern.compile("[A-z]\\D*$");
    }

    //TODO: Make this async
    public HttpResponse send(HttpRequest request) throws IOException {
        InetAddress address = request.getAddress();
        Socket socket = new Socket(address, 80);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(request.ConstructHttpRequest());
        writer.println();
        writer.flush();

        HttpResponse httpResponse = getResponse(socket);
        socket.close();

        return httpResponse;
    }

    private HttpResponse getResponse(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        byte[] buffer = new byte[1024];
        int bytesRead;
        bytesRead = in.read(buffer);
        
        String response = new String(buffer, 0, bytesRead);
        Scanner scanner = new Scanner(response);
        String responseLine = scanner.nextLine();

        HttpVersion httpVersion = extractHttpVersion(responseLine);
        StatusCode statusCode = extractStatusCode(responseLine);
        List<HttpHeader> httpHeaders = new ArrayList<>();
        String content = "";

        boolean endOfHeaders = false;
        while (!endOfHeaders) {
            while (scanner.hasNextLine()) {
                responseLine = scanner.nextLine();

                if (responseLine == "") {
                    endOfHeaders = true;
                    break;
                }

                HttpHeader header = HeaderFactory.ConvertToHeader(responseLine);
                httpHeaders.add(header);
            }

            if (!endOfHeaders) {
                bytesRead = in.read(buffer);
                response = new String(buffer, 0, bytesRead);
                scanner = new Scanner(response);
            }
        }

        //TODO: add context extraction

        return new HttpResponse(httpVersion, statusCode, httpHeaders, content);
    }

    private HttpVersion extractHttpVersion(String rawHttpResponse) {
        Matcher matcher = httpVersionPattern.matcher(rawHttpResponse);
        matcher.find();
        String rawHttpVersion = matcher.group().replace("/", "_").replace(".", "");
        return HttpVersion.valueOf(rawHttpVersion);
    }

    private StatusCode extractStatusCode(String rawHttpResponse) {
        Matcher matcher = statusCodePattern.matcher(rawHttpResponse);
        matcher.find();
        String rawStatusCode = matcher.group().replace(" ", "_").toUpperCase();
        return StatusCode.valueOf(rawStatusCode);
    }
}
