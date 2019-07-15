package com.sc.customer.trial.exceptions;

import java.util.AbstractMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * Global Exception handler for all exceptions.
   */
  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
    // general exception
    LOG.error("Exception: Unable to process this request. ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
  
  /*@ExceptionHandler(value = MemberMailAlreadyExistsException.class)
  public ResponseEntity<Object> exception(MemberMailAlreadyExistsException exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Member Mail Id Already Exists");
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(value = BookAlreadyIssuedException.class)
  public ResponseEntity<Object> exception(BookAlreadyIssuedException exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Book Already Issued");	
	  return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
  }

  @ExceptionHandler(value = BookNotExistException.class)
  public ResponseEntity<Object> exception(BookNotExistException exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Book Not Exists");	
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
  
  @ExceptionHandler(value = BookAlreadyReturned.class)
  public ResponseEntity<Object> exception(BookAlreadyReturned exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Book Already Returned");	
	  return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
  }

  @ExceptionHandler(value = MaxLimitException.class)
  public ResponseEntity<Object> exception(MaxLimitException exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Max Limit of Book Issuance Reached");	
	  return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
  }

  @ExceptionHandler(value = InvalidNameException.class)
  public ResponseEntity<Object> exception(InvalidNameException exception) {
	  AbstractMap.SimpleEntry<String, String> response =
		        new AbstractMap.SimpleEntry<>("message", "Provided Name is invalid");	
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }*/
}
