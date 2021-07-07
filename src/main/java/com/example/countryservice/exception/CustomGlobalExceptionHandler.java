package com.example.countryservice.exception;

import com.example.countryservice.Model.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//REFERENCE::https://mkyong.com/spring-boot/spring-rest-validation-example/
@ResponseStatus
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

/**
validation for @Valid

 **/
    protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus httpStatus, WebRequest request){

    Map<String,Object> body=new LinkedHashMap<>();
    body.put("timestamp",new Date());
    body.put("status",httpStatus.value());
    List<String> errors=ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(x->x.getDefaultMessage())
            .collect(Collectors.toList());
    body.put("errors",errors);
        return new ResponseEntity<>(body, headers, httpStatus);
}
/**
 Validation for checking the parameter length in {id} parameter in Country Controller
  **/
@ExceptionHandler(ConstraintViolationException.class)
public void constraintViolationException(HttpServletResponse response)throws IOException {
        response.sendError(HttpStatus.OK.value());

}
@ExceptionHandler(CountryNotFoundException.class)
public ResponseEntity<ErrorMessage>CountryNotFoundWithException(CountryNotFoundException countryNotFoundException ,WebRequest request){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,countryNotFoundException.getMessage());
         return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

}

}
