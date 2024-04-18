package core;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {
    public void send(HttpRequest request) throws IOException {
        Socket socket = new Socket(request.getAddress(), 80);
    }
}
