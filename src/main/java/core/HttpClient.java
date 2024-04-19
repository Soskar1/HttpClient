package core;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HttpClient {
    //TODO: Make this async
    public void send(HttpRequest request) throws IOException {
        InetAddress address = request.getAddress();
        Socket socket = new Socket(address, 80);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("GET /index.html HTTP/1.1\n" +
                "Host: " + address.getHostName());


    }
}
