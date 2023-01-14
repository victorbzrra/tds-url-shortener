package com.tds.shortener.handler;

import com.tds.shortener.exceptions.BadRequest;
import com.tds.shortener.exceptions.ExceptionResponse;
import com.tds.shortener.exceptions.NotFound;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Method;

@RestControllerAdvice
public class HandlerException implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        ex.printStackTrace();
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ExceptionResponse> handlerBadRequest(BadRequest badRequest, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(badRequest.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ExceptionResponse> handlerNotFound(NotFound notFound, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(notFound.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
