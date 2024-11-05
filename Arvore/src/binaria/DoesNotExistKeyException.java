package Arvore.src.binaria;
public class DoesNotExistKeyException extends RuntimeException{
  public DoesNotExistKeyException (String error) {
    super(error);
  }
}