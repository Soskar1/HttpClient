package core.requests;

import core.HttpVersion;
import core.HttpHeader;

import java.net.UnknownHostException;

public class PutHttpRequest extends HttpRequest {
    private final String path;
    private final String content;

    public PutHttpRequest(String url, HttpVersion version, String path, String content) throws UnknownHostException {
        super(url, version);

        this.path = path;
        this.content = content;

        HttpHeader contentType = new HttpHeader("Content-Type: text/plain");
        HttpHeader contentLength = new HttpHeader("Content-Length: " + content.length());

        getHeaders().add(contentType);
        getHeaders().add(contentLength);
    }

    @Override
    protected String addHttpMethod() {
        return "PUT " + path + " " + getVersion();
    }

    @Override
    protected String addContent() {
        return content;
    }
}
