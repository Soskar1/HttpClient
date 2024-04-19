package core;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HttpRequest {
    private final InetAddress address;
    private final HttpVersion version;

    public HttpRequest(String url, HttpVersion version) throws UnknownHostException {
        address = InetAddress.getByName(url);
        this.version = version;
    }

    public InetAddress getAddress() {
        return address;
    }

    public HttpVersion getVersion() {
        return version;
    }
}
