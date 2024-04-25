package core;

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
    private final int BUFFER_SIZE = 1024;

    public HttpClient() {
        httpVersionPattern = Pattern.compile("^HTTP/(0\\.9|1\\.0|1\\.1|2|3)");
        statusCodePattern = Pattern.compile("[A-z]\\D*$");
    }

    public HttpResponse send(HttpRequest request) throws IOException {
        InetAddress address = request.getAddress();
        Socket socket = new Socket(address, 80);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(request.construct());
        writer.println();
        writer.flush();

        HttpResponse httpResponse = getResponse(socket);
        socket.close();

        return httpResponse;
    }

    private HttpResponse getResponse(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        bytesRead = in.read(buffer);

        if (bytesRead == -1) {
            return null;
        }
        
        String rawResponse = new String(buffer, 0, bytesRead);
        Scanner bufferScanner = new Scanner(rawResponse);

        String rawVersionStatus = bufferScanner.nextLine();
        HttpVersion httpVersion = extractHttpVersion(rawVersionStatus);
        StatusCode statusCode = extractStatusCode(rawVersionStatus);

        String rawHeaders = extractRawHeaders(in, buffer, bufferScanner);
        List<HttpHeader> httpHeaders = convertToHeaders(rawHeaders);

        String content = extractContent(in, buffer, bufferScanner);

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

    private String extractRawHeaders(DataInputStream in, byte[] buffer, Scanner scanner) throws IOException {
        StringBuilder sb = new StringBuilder();

        boolean endOfHeaders = false;
        while (!endOfHeaders) {
            while (scanner.hasNextLine()) {
                String responseLine = scanner.nextLine();

                if (responseLine == "") {
                    endOfHeaders = true;
                    break;
                }

                sb.append(responseLine).append('\n');
            }

            if (!endOfHeaders) {
                int bytesRead = in.read(buffer);
                String rawResponse = new String(buffer, 0, bytesRead);
                scanner = new Scanner(rawResponse);
            }
        }

        return sb.toString();
    }

    private List<HttpHeader> convertToHeaders(String rawHeaders) {
        List<HttpHeader> headers = new ArrayList<>();

        Scanner headerScanner = new Scanner(rawHeaders);
        while (headerScanner.hasNextLine()) {
            String rawHeader = headerScanner.nextLine();
            HttpHeader header = new HttpHeader(rawHeader);
            headers.add(header);
        }

        return headers;
    }

    private String extractContent(DataInputStream in, byte[] buffer, Scanner bufferScanner) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (bufferScanner.hasNextLine()) {
            String line = bufferScanner.nextLine();
            sb.append(line);
        }

        int bytesRead;
        String str;
        while (in.available() > 0) {
            bytesRead = in.read(buffer);
            str = new String(buffer, 0, bytesRead);
            sb.append(str);
        }

        return sb.toString();
    }
}
