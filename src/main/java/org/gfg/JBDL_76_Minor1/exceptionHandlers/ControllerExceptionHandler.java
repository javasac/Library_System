package org.gfg.JBDL_76_Minor1.exceptionHandlers;

import org.gfg.JBDL_76_Minor1.exception.BookException;
import org.gfg.JBDL_76_Minor1.exception.TxnException;
import org.gfg.JBDL_76_Minor1.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    // any exception will be coming at that time how to handle, without interrupting the business logic

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handle(MethodArgumentNotValidException e){
        return  new ResponseEntity<>(e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = TxnException.class)
    public ResponseEntity<Object> handleTxnException(TxnException txnException){
        return new ResponseEntity<>(txnException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = BookException.class)
    public ResponseEntity<Object> handleBookException(BookException txnException){
        return new ResponseEntity<>(txnException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<Object> handleUserException(UserException txnException){
        return new ResponseEntity<>(txnException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
