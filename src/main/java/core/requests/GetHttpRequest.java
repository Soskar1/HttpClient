package core.requests;

import core.HttpVersion;

import java.net.UnknownHostException;

public class GetHttpRequest extends HttpRequest {
    private final String path;

    public GetHttpRequest(String url, HttpVersion version, String path) throws UnknownHostException {
        super(url, version);
        this.path = path;
    }

    @Override
    protected String addHttpMethod() {
        return "GET " + path + " " + getVersion();
    }
}
