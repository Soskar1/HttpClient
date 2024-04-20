package core.headers;

public class HeaderFactory {
    public static HttpHeader ConvertToHeader(String rawHeader) {
        if (rawHeader.startsWith("Content-Length:")) {
            return new ContentLengthHeader(rawHeader);
        } else {
            return new HttpHeader(rawHeader);
        }
    }
}
