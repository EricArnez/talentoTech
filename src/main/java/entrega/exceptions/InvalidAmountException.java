package entrega.exceptions;

public class InvalidAmountException extends RuntimeException
{
  public InvalidAmountException(String message) {
    super(message);
  }
}
