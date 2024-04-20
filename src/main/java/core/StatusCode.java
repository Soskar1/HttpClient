package core;

public enum StatusCode {
    CONTINUE(100),
    SWITCHING_PROTOCOLS(101),
    PROCESSING(102),
    EARLY_HINTS(103),
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NON_AUTHORITATIVE_INFORMATION(203),
    NO_CONTENT(204),
    RESET_CONTENT(205),
    PARTIAL_CONTENT(206),
    MULTI_STATUS(207),
    ALREADY_REPORTED(208),
    IM_USED(226),
    MULTIPLE_CHOICES(300),
    MOVED_PERMANENTLY(301),
    FOUND(302),
    SEE_OTHER(303),
    NOT_MODIFIED(304),
    TEMPORARY_REDIRECT(307),
    PERMANENT_REDIRECT(308),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    PAYMENT_REQUIRED(402),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    NOT_ACCEPTABLE(406),
    PROXY_AUTHENTICATION_REQUIRED(407),
    REQUEST_TIMEOUT(408),
    CONFLICT(409),
    GONE(410),
    LENGTH_REQUIRED(411),
    PRECONDITION_FAILED(412),
    CONTENT_TOO_LARGE(413),
    URI_TOO_LONG(414),
    UNSUPPORTED_MEDIA_TYPE(415),
    RANGE_NOT_SATISFIABLE(416),
    EXPECTATION_FAILED(417),
    IM_A_TEAPOT(418),
    MISDIRECTED_REQUEST(421),
    UNPROCESSABLE_CONTENT(422),
    LOCKED(423),
    FAILED_DEPENDENCY(424),
    TOO_EARLY(425),
    UPGRADE_REQUIRED(426),
    PRECONDITION_REQUIRED(428),
    TOO_MANY_REQUESTS(429),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431),
    UNAVAILABLE_FOR_LEGAL_REASONS(451),
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLEMENTED(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504),
    HTTP_VERSION_NOT_SUPPORTED(505),
    VARIANT_ALSO_NEGOTIATES(506),
    INSUFFICIENT_STORAGE(507),
    LOOP_DETECTED(508),
    NOT_EXTENDED(510),
    NETWORK_AUTHENTICATION_REQUIRED(511);

    private final int codeValue;
    private StatusCode(int codeValue) { this.codeValue = codeValue; }

    public int getCodeValue() {
        return codeValue;
    }

    @Override
    public String toString() {
        return switch (this) {
            case CONTINUE -> getCodeValue() + " Continue";
            case SWITCHING_PROTOCOLS -> getCodeValue() + " Switching Protocols";
            case PROCESSING -> getCodeValue() + " Processing";
            case EARLY_HINTS -> getCodeValue() + " Early Hints";
            case OK -> getCodeValue() + " OK";
            case CREATED -> getCodeValue() + " Created";
            case ACCEPTED -> getCodeValue() + " Accepted";
            case NON_AUTHORITATIVE_INFORMATION -> getCodeValue() + " Non-Authoritative Information";
            case NO_CONTENT -> getCodeValue() + " No Content";
            case RESET_CONTENT -> getCodeValue() + " Reset Content";
            case PARTIAL_CONTENT -> getCodeValue() + " Partial Content";
            case MULTI_STATUS -> getCodeValue() + " Multi-Status";
            case ALREADY_REPORTED -> getCodeValue() + " Already Reported";
            case IM_USED -> getCodeValue() + " IM Used";
            case MULTIPLE_CHOICES -> getCodeValue() + " Multiple Choices";
            case MOVED_PERMANENTLY -> getCodeValue() + " Moved Permanently";
            case FOUND -> getCodeValue() + " Found";
            case SEE_OTHER -> getCodeValue() + " See Other";
            case NOT_MODIFIED -> getCodeValue() + " Not Modified";
            case TEMPORARY_REDIRECT -> getCodeValue() + " Temporary Redirect";
            case PERMANENT_REDIRECT -> getCodeValue() + " Permanent Redirect";
            case BAD_REQUEST -> getCodeValue() + " Bad Request";
            case UNAUTHORIZED -> getCodeValue() + " Unauthorized";
            case PAYMENT_REQUIRED -> getCodeValue() + " Payment Required";
            case FORBIDDEN -> getCodeValue() + " Forbidden";
            case NOT_FOUND -> getCodeValue() + " Not Found";
            case METHOD_NOT_ALLOWED -> getCodeValue() + " Method Not Allowed";
            case NOT_ACCEPTABLE -> getCodeValue() + " Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED -> getCodeValue() + " Proxy Authentication Required";
            case REQUEST_TIMEOUT -> getCodeValue() + " Request Timeout";
            case CONFLICT -> getCodeValue() + " Conflict";
            case GONE -> getCodeValue() + " Gone";
            case LENGTH_REQUIRED -> getCodeValue() + " Length Required";
            case PRECONDITION_FAILED -> getCodeValue() + " Precondition Failed";
            case CONTENT_TOO_LARGE -> getCodeValue() + " Content Too Large";
            case URI_TOO_LONG -> getCodeValue() + " URI Too Long";
            case UNSUPPORTED_MEDIA_TYPE -> getCodeValue() + " Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE -> getCodeValue() + " Range Not Satisfiable";
            case EXPECTATION_FAILED -> getCodeValue() + " Expectation Failed";
            case IM_A_TEAPOT -> getCodeValue() + " I'm a teapot";
            case MISDIRECTED_REQUEST -> getCodeValue() + " Misdirected Request";
            case UNPROCESSABLE_CONTENT -> getCodeValue() + " Unprocessable Content";
            case LOCKED -> getCodeValue() + " Locked";
            case FAILED_DEPENDENCY -> getCodeValue() + " Failed Dependency";
            case TOO_EARLY -> getCodeValue() + " Too Early";
            case UPGRADE_REQUIRED -> getCodeValue() + " Upgrade Required";
            case PRECONDITION_REQUIRED -> getCodeValue() + " Precondition Required";
            case TOO_MANY_REQUESTS -> getCodeValue() + " Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE -> getCodeValue() + " Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS -> getCodeValue() + " Unavailable For Legal Reasons";
            case INTERNAL_SERVER_ERROR -> getCodeValue() + " Internal Server Error";
            case NOT_IMPLEMENTED -> getCodeValue() + " Not Implemented";
            case BAD_GATEWAY -> getCodeValue() + " Bad Gateway";
            case SERVICE_UNAVAILABLE -> getCodeValue() + " Service Unavailable";
            case GATEWAY_TIMEOUT -> getCodeValue() + " Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED -> getCodeValue() + " HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES -> getCodeValue() + " Variant Also Negotiates";
            case INSUFFICIENT_STORAGE -> getCodeValue() + " Insufficient Storage";
            case LOOP_DETECTED -> getCodeValue() + " Loop Detected";
            case NOT_EXTENDED -> getCodeValue() + " Not Extended";
            case NETWORK_AUTHENTICATION_REQUIRED -> getCodeValue() + " Network Authentication Required";
        };
    }
}