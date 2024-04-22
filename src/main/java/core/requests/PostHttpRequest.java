package core.requests;

import core.HttpVersion;
import core.HttpHeader;

import java.net.UnknownHostException;

public class PostHttpRequest extends HttpRequest {
    private final String path;
    private final String content;

    public PostHttpRequest(String url, HttpVersion version, String path, String content) throws UnknownHostException {
        super(url, version);

        this.path = path;
        this.content = content;

        HttpHeader contentType = new HttpHeader("Content-Type: text/plain");
        HttpHeader contentLength = new HttpHeader("Content-Length: " + content.length());

        getHeaders().add(contentType);
        getHeaders().add(contentLength);
    }

    @Override
    public String ConstructHttpRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append("POST ").append(path).append(" ").append(getVersion()).append("\n");

        String headers = convertHeadersToString();
        sb.append(headers).append("\n");

        sb.append(content);

        return sb.toString();
    }
}
