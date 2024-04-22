package core.requests;

import core.HttpVersion;

import java.net.UnknownHostException;

public class HeadHttpRequest extends HttpRequest {
    private final String path;

    public HeadHttpRequest(String url, HttpVersion version, String path) throws UnknownHostException {
        super(url, version);
        this.path = path;
    }

    @Override
    protected String addHttpMethod() {
        return "HEAD " + path + " " + getVersion();
    }
}
