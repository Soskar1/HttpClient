package core;

public enum StatusCode {
    CONTINUE,
    SWITCHING_PROTOCOLS,
    PROCESSING,
    EARLY_HINTS,
    OK,
    CREATED,
    ACCEPTED,
    NON_AUTHORITATIVE_INFORMATION,
    NO_CONTENT,
    RESET_CONTENT,
    PARTIAL_CONTENT,
    MULTI_STATUS,
    ALREADY_REPORTED,
    IM_USED,
    MULTIPLE_CHOICES,
    MOVED_PERMANENTLY,
    FOUND,
    SEE_OTHER,
    NOT_MODIFIED,
    TEMPORARY_REDIRECT,
    PERMANENT_REDIRECT,
    BAD_REQUEST,
    UNAUTHORIZED,
    PAYMENT_REQUIRED,
    FORBIDDEN,
    NOT_FOUND,
    METHOD_NOT_ALLOWED,
    NOT_ACCEPTABLE,
    PROXY_AUTHENTICATION_REQUIRED,
    REQUEST_TIMEOUT,
    CONFLICT,
    GONE,
    LENGTH_REQUIRED,
    PRECONDITION_FAILED,
    CONTENT_TOO_LARGE,
    URI_TOO_LONG,
    UNSUPPORTED_MEDIA_TYPE,
    RANGE_NOT_SATISFIABLE,
    EXPECTATION_FAILED,
    IM_A_TEAPOT,
    MISDIRECTED_REQUEST,
    UNPROCESSABLE_CONTENT,
    LOCKED,
    FAILED_DEPENDENCY,
    TOO_EARLY,
    UPGRADE_REQUIRED,
    PRECONDITION_REQUIRED,
    TOO_MANY_REQUESTS,
    REQUEST_HEADER_FIELDS_TOO_LARGE,
    UNAVAILABLE_FOR_LEGAL_REASONS,
    INTERNAL_SERVER_ERROR,
    NOT_IMPLEMENTED,
    BAD_GATEWAY,
    SERVICE_UNAVAILABLE,
    GATEWAY_TIMEOUT,
    HTTP_VERSION_NOT_SUPPORTED,
    VARIANT_ALSO_NEGOTIATES,
    INSUFFICIENT_STORAGE,
    LOOP_DETECTED,
    NOT_EXTENDED,
    NETWORK_AUTHENTICATION_REQUIRED;

    @Override
    public String toString() {
        return switch (this) {
            case CONTINUE -> "100 Continue";
            case SWITCHING_PROTOCOLS -> "101 Switching Protocols";
            case PROCESSING -> "102 Processing";
            case EARLY_HINTS -> "103 Early Hints";
            case OK -> "200 OK";
            case CREATED -> "201 Created";
            case ACCEPTED -> "202 Accepted";
            case NON_AUTHORITATIVE_INFORMATION -> "203 Non-Authoritative Information";
            case NO_CONTENT -> "204 No Content";
            case RESET_CONTENT -> "205 Reset Content";
            case PARTIAL_CONTENT -> "206 Partial Content";
            case MULTI_STATUS -> "207 Multi-Status";
            case ALREADY_REPORTED -> "208 Already Reported";
            case IM_USED -> "226 IM Used";
            case MULTIPLE_CHOICES -> "300 Multiple Choices";
            case MOVED_PERMANENTLY -> "301 Moved Permanently";
            case FOUND -> "302 Found";
            case SEE_OTHER -> "303 See Other";
            case NOT_MODIFIED -> "304 Not Modified";
            case TEMPORARY_REDIRECT -> "307 Temporary Redirect";
            case PERMANENT_REDIRECT -> "308 Permanent Redirect";
            case BAD_REQUEST -> "400 Bad Request";
            case UNAUTHORIZED -> "401 Unauthorized";
            case PAYMENT_REQUIRED -> "402 Payment Required";
            case FORBIDDEN -> "403 Forbidden";
            case NOT_FOUND -> "404 Not Found";
            case METHOD_NOT_ALLOWED -> "405 Method Not Allowed";
            case NOT_ACCEPTABLE -> "406 Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED -> "407 Proxy Authentication Required";
            case REQUEST_TIMEOUT -> "408 Request Timeout";
            case CONFLICT -> "409 Conflict";
            case GONE -> "410 Gone";
            case LENGTH_REQUIRED -> "411 Length Required";
            case PRECONDITION_FAILED -> "412 Precondition Failed";
            case CONTENT_TOO_LARGE -> "413 Content Too Large";
            case URI_TOO_LONG -> "414 URI Too Long";
            case UNSUPPORTED_MEDIA_TYPE -> "415 Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE -> "416 Range Not Satisfiable";
            case EXPECTATION_FAILED -> "417 Expectation Failed";
            case IM_A_TEAPOT -> "418 I'm a teapot";
            case MISDIRECTED_REQUEST -> "421 Misdirected Request";
            case UNPROCESSABLE_CONTENT -> "422 Unprocessable Content";
            case LOCKED -> "423 Locked";
            case FAILED_DEPENDENCY -> "424 Failed Dependency";
            case TOO_EARLY -> "425 Too Early";
            case UPGRADE_REQUIRED -> "426 Upgrade Required";
            case PRECONDITION_REQUIRED -> "428 Precondition Required";
            case TOO_MANY_REQUESTS -> "429 Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE -> "431 Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS -> "451 Unavailable For Legal Reasons";
            case INTERNAL_SERVER_ERROR -> "500 Internal Server Error";
            case NOT_IMPLEMENTED -> "501 Not Implemented";
            case BAD_GATEWAY -> "502 Bad Gateway";
            case SERVICE_UNAVAILABLE -> "503 Service Unavailable";
            case GATEWAY_TIMEOUT -> "504 Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED -> "505 HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES -> "506 Variant Also Negotiates";
            case INSUFFICIENT_STORAGE -> "507 Insufficient Storage";
            case LOOP_DETECTED -> "508 Loop Detected";
            case NOT_EXTENDED -> "510 Not Extended";
            case NETWORK_AUTHENTICATION_REQUIRED -> "511 Network Authentication Required";
        };
    }
}