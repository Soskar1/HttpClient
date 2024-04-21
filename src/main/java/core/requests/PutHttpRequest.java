package core.requests;

import core.HttpVersion;
import core.headers.ContentLengthHeader;
import core.headers.HttpHeader;

import java.net.UnknownHostException;

public class PutHttpRequest extends HttpRequest {
    private final String path;
    private final String content;

    public PutHttpRequest(String url, HttpVersion version, String path, String content) throws UnknownHostException {
        super(url, version);

        this.path = path;
        this.content = content;

        HttpHeader contentType = new HttpHeader("Content-Type: text/plain");
        HttpHeader contentLength = new ContentLengthHeader("Content-Length: " + content.length());

        getHeaders().add(contentType);
        getHeaders().add(contentLength);
    }

    @Override
    public String ConstructHttpRequest() {
        StringBuilder sb = new StringBuilder();
        sb.append("PUT ").append(path).append(" ").append(getVersion()).append("\n");

        String headers = convertHeadersToString();
        sb.append(headers).append("\n");

        sb.append(content);

        return sb.toString();
    }
}
