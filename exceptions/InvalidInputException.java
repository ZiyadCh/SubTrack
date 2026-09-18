package exceptions;

public class InvalidInputException extends RuntimeException {
  public InvalidInputException(String e) {
    super(e);
  }
}
