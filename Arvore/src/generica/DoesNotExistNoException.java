package Arvore.src.generica;
public class DoesNotExistNoException extends RuntimeException{
  public DoesNotExistNoException (String error) {
    super(error);
  }
}