package Arvore.src.generica;

public class InvalidNoException extends RuntimeException{
  public InvalidNoException (String error) {
    super(error);
  }
}