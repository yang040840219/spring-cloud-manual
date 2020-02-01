package com.provider.advice;

import com.provider.web.ServiceController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.concurrent.TimeoutException;

/**
 * 2020/1/31
 */

@RestControllerAdvice(assignableTypes = ServiceController.class)
public class CustomRestControllerAdvice {

    @ExceptionHandler(TimeoutException.class)
    public Object faultToleranceTimeout(Throwable throwable){
        return throwable.getMessage();
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Object handle404(Throwable throwable){
        return "page not found" ;
    }
}
