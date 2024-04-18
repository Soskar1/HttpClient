package core;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HttpRequest {
    private final InetAddress address;

    public InetAddress getAddress() {
        return address;
    }

    public HttpRequest(String url) throws UnknownHostException {
        address = InetAddress.getByName(url);
    }
}
