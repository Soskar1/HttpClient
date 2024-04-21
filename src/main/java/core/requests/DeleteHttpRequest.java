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
    public String ConstructHttpRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ").append(path).append(" ").append(getVersion()).append("\n");

        String headers = convertHeadersToString();
        sb.append(headers);

        return sb.toString();
    }
}
