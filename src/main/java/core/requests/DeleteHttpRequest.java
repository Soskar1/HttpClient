package core.requests;

import core.HttpVersion;

import java.net.UnknownHostException;

public class DeleteHttpRequest extends HttpRequest {
    private final String path;

    public DeleteHttpRequest(String url, HttpVersion version, String path) throws UnknownHostException {
        super(url, version);
        this.path = path;
    }

    @Override
    protected String addHttpMethod() {
        return "DELETE " + path + " " + getVersion();
    }
}
