package LAB;

import java.util.ArrayList;
import java.util.List;

public class SemanticAnalysis {
  private List<String> errors;

  public SemanticAnalysis() {
    this.errors = new ArrayList<>();
  }

  public List<String> getErrors() {
    return errors;
  }

  public void checkVariableDeclaration(String variableName) {
    // Check if variable has already been declared
    if (SymbolTable.variableExists(variableName)) {
      errors.add("Error: variable '" + variableName + "' has already been declared");
    } else {
      // Add variable to symbol table
      SymbolTable.addVariable(variableName);
    }
  }

  public void checkFunctionDeclaration(String functionName) {
    // Check if function has already been declared
    if (SymbolTable.functionExists(functionName)) {
      errors.add("Error: function '" + functionName + "' has already been declared");
    } else {
      // Add function to symbol table
      SymbolTable.addFunction(functionName);
    }
  }

  public void checkVariableUsage(String variableName) {
    // Check if variable has been declared
    if (!SymbolTable.variableExists(variableName)) {
      errors.add("Error: variable '" + variableName + "' has not been declared");
    }
  }

  public void checkFunctionUsage(String functionName) {
    // Check if function has been declared
    if (!SymbolTable.functionExists(functionName)) {
      errors.add("Error: function '" + functionName + "' has not been declared");
    }
  }
}
