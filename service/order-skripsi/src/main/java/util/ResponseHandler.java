package util;

import com.example.orderskripsi.constant.ResponseMessage;
import com.example.orderskripsi.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<BaseResponse> generateResponse(ResponseMessage message, Object responseObj) {
        BaseResponse response = new BaseResponse();
        response.setMessage(message.getMessage());
        response.setStatus(message.getStatus().value());
        response.setData(responseObj);
        return new ResponseEntity<>(response, message.getStatus());
    }
}
