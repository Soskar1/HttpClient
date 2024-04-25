package core.requests;

import core.HttpVersion;
import core.HttpHeader;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public abstract class HttpRequest {
    private final InetAddress address;
    private final HttpVersion version;
    private final List<HttpHeader> headers;

    public HttpRequest(String url, HttpVersion version) throws UnknownHostException {
        address = InetAddress.getByName(url);
        this.version = version;

        headers = new ArrayList<>();
        HttpHeader hostHeader = new HttpHeader("Host: " + address.getHostName());
        headers.add(hostHeader);
    }

    public InetAddress getAddress() {
        return address;
    }

    public HttpVersion getVersion() {
        return version;
    }

    public List<HttpHeader> getHeaders() {
        return headers;
    }

    public String construct() {
        StringBuilder sb = new StringBuilder();

        String httpMethod = addHttpMethod();
        String headers = addHeaders();
        String content = addContent();

        sb.append(httpMethod).append("\n");
        sb.append(headers).append("\n");
        sb.append(content);

        return sb.toString();
    }

    protected abstract String addHttpMethod();

    private String addHeaders() {
        StringBuilder sb = new StringBuilder();
        for (HttpHeader header : headers) {
            sb.append(header.toString()).append("\n");
        }

        return sb.toString();
    }

    protected String addContent() {
        return "";
    }
}
