package LAB;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    SemanticAnalysis semanticAnalysis = new SemanticAnalysis();

    // Declare a variable
    semanticAnalysis.checkVariableDeclaration("x");

    // Use the variable
    semanticAnalysis.checkVariableUsage("x");

    // Try to declare the same variable again, which should generate an error
    semanticAnalysis.checkVariableDeclaration("x");

    // Try to use a variable that has not been declared, which should generate an error
    semanticAnalysis.checkVariableDeclaration("y");

    // Use the variable
    semanticAnalysis.checkVariableUsage("y");

    // Try to declare the same variable again, which should generate an error
    semanticAnalysis.checkVariableDeclaration("y");
    // Declare a function
    semanticAnalysis.checkFunctionDeclaration("foo");

    // Use the function
    semanticAnalysis.checkFunctionUsage("foo");

    // Try to declare the same function again, which should generate an error
    semanticAnalysis.checkFunctionDeclaration("foo");

    // Try to use a function that has not been declared, which should generate an error
    semanticAnalysis.checkFunctionUsage("bar");

    // Get a list of any errors that were found
    List<String> errors = semanticAnalysis.getErrors();

    // Print the errors
    for (String error : errors) {
      System.out.println(error);
    }
  }
}