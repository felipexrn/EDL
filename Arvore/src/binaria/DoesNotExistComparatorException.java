package Arvore.src.binaria;
public class DoesNotExistComparatorException extends RuntimeException{
  public DoesNotExistComparatorException (String error) {
    super(error);
  }
}