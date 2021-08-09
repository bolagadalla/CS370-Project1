package Visitor;
//accept interface for Element class
public interface AccountElement {
  public void accept(AccountVisitor visitor);
}