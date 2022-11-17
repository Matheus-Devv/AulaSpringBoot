package academoy.devdojo.springboot2essencials.handler;

import academoy.devdojo.springboot2essencials.exception.BadRequestException;
import academoy.devdojo.springboot2essencials.exception.BadRequestExceptionDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, check the documentation")
                        .details(bre.getMessage())
                        .developerMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerMethodArgumentNotValidException(BadRequestException exception) {
        log.info("");
        return null;
//        return new ResponseEntity<>(
//                BadRequestExceptionDetails.builder()
//                        .timestamp(LocalDateTime.now())
//                        .status(HttpStatus.BAD_REQUEST.value())
//                        .title("Bad Request Exception, check the documentation")
//                        .details(bre.getMessage())
//                        .developerMessage(bre.getClass().getName())
//                        .build(), HttpStatus.BAD_REQUEST);
    }
}
