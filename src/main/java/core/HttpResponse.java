package core;

import java.util.List;

public class HttpResponse {
    private HttpVersion httpVersion;
    private StatusCode statusCode;
    private List<HttpHeader> headers;
    private String content;
}
