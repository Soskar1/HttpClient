package core;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient {
    //TODO: Make this async
    public void send(HttpRequest request) throws IOException {
        InetAddress address = request.getAddress();
        Socket socket = new Socket(address, 80);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(
                "GET /index.html " + request.getVersion().toString() + "\n" +
                "Host: " + address.getHostName());
        writer.println();
        writer.flush();

        getResponse(socket);

        socket.close();
    }

    private void getResponse(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String headers = getHeaders(in);

        System.out.print(headers);
    }

    private String getHeaders(DataInputStream in) throws IOException {
        StringBuilder headers = new StringBuilder();

        byte[] buffer = new byte[1024];
        int bytesRead;

        boolean endOfHeaders = false;
        while (!endOfHeaders) {
            bytesRead = in.read(buffer);
            String output = new String(buffer, 0, bytesRead);

            Scanner scanner = new Scanner(output);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                headers.append(line).append("\n");

                if (line.isEmpty()) {
                    endOfHeaders = true;
                    break;
                }
            }
            scanner.close();
        }

        return headers.toString();
    }

    private String getContent(DataInputStream in, int headerLength, int contentLength) {
        return "";
    }
}
