package core;

import java.util.List;

public class HttpResponse {
    private final HttpVersion httpVersion;
    private final StatusCode statusCode;
    private final List<HttpHeader> headers;
    private final String content;

    public HttpResponse(HttpVersion httpVersion, StatusCode statusCode, List<HttpHeader> headers, String content) {
        this.httpVersion = httpVersion;
        this.statusCode = statusCode;
        this.headers = headers;
        this.content = content;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public List<HttpHeader> getHeaders() {
        return headers;
    }

    public String getContent() {
        return content;
    }
}
