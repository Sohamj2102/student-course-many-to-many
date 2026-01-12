package com.nit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseError>handleStudentNotFound(StudentNotFoundException ex,HttpServletRequest request){
		ResponseError error=new ResponseError(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now(),
				request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ResponseError>handleCourseNotFound(CourseNotFoundException ex,HttpServletRequest request){
		ResponseError error=new ResponseError(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				LocalDateTime.now(),
				request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError>handleAllExceptions(Exception ex,HttpServletRequest request){
		ResponseError error=new ResponseError(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(),
				LocalDateTime.now(),
				request.getRequestURI());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
