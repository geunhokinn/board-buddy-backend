package sumcoda.boardbuddy.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sumcoda.boardbuddy.dto.common.ApiResponse;
import sumcoda.boardbuddy.enumerate.Status;

public class ResponseHandlerUtil {

    private static final Status STATUS_SUCCESS = Status.SUCCESS;

    private static final Status STATUS_FAILURE = Status.FAILURE;

    private static final Status STATUS_ERROR = Status.ERROR;

    public static ResponseEntity<ApiResponse<Object>> buildResponse(Status status, Object data, String message, HttpStatus httpStatus) {
        ApiResponse<Object> response = ApiResponse.builder()
                .status(status.getValue())
                .data(data)
                .message(message)
                .build();

        return new ResponseEntity<>(response, httpStatus);
    }

    public static ResponseEntity<ApiResponse<Object>> buildSuccessResponse(Object data, String message, HttpStatus httpStatus) {
        return buildResponse(STATUS_SUCCESS, data, message, httpStatus);
    }

    public static ResponseEntity<ApiResponse<Object>> buildFailureResponse(String message, HttpStatus httpStatus) {
        return buildResponse(STATUS_FAILURE, null, message, httpStatus);
    }

    public static ResponseEntity<ApiResponse<Object>> buildErrorResponse(String message, HttpStatus httpStatus) {
        return buildResponse(STATUS_ERROR, null, message, httpStatus);

    }
}
