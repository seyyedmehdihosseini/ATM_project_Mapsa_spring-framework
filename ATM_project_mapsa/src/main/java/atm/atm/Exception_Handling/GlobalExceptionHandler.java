package atm.atm.Exception_Handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException exception){
        Map<String,Object> ex = new HashMap<>();
        ex.put("message",exception.getMessage());
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflictException(ConflictException exception){
        Map<String,Object> ex = new HashMap<>();
        ex.put("message",exception.getMessage());
        return new ResponseEntity<>(ex,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessException(BusinessException exception){
        Map<String,Object> ex = new HashMap<>();
        ex.put("message",exception.getMessage());
        return new ResponseEntity<>(ex,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }




}
