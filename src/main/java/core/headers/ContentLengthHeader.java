package core.headers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentLengthHeader extends HttpHeader {
    private final int contentLength;

    public ContentLengthHeader(String raw) {
        super(raw);

        Matcher matcher = Pattern.compile("\\d+$").matcher(raw);
        matcher.find();
        contentLength = Integer.parseInt(matcher.group());
    }

    public int getContentLength() {
        return contentLength;
    }
}
