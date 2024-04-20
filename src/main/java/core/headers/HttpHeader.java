package core.headers;

public class HttpHeader {
    private final String raw;

    public HttpHeader(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return raw;
    }
}
