package core;

public enum HttpVersion {
    HTTP_09,
    HTTP_10,
    HTTP_11,
    HTTP_2,
    HTTP_3;

    @Override
    public String toString() {
        return switch (this) {
            case HTTP_09 -> "HTTP/0.9";
            case HTTP_10 -> "HTTP/1.0";
            case HTTP_11 -> "HTTP/1.1";
            case HTTP_2 -> "HTTP/2";
            case HTTP_3 -> "HTTP/3";
        };
    }
}
