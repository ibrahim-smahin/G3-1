import java.util.List;
import java.util.ArrayList;

public class CodeGenerator {
    private List<String> instructions;
    private int tempCounter;

    public CodeGenerator() {
        instructions = new ArrayList<>();
        tempCounter = 0;
    }

    public void generateCode(AstNode root) {
        generate(root);
    }

    private void generate(AstNode node) {
        switch (node.getType()) {
            case "Program":
                for (AstNode child : node.getChildren()) {
                    generate(child);
                }
                break;
            case "Declaration":
                instructions.add("var " + node.getChildren().get(1).getValue());
                break;
            case "Assignment":
                generate(node.getChildren().get(2));
                instructions.add("pop " + node.getChildren().get(0).getValue());
                break;
            case "BinaryExpression":
                generate(node.getChildren().get(0));
                generate(node.getChildren().get(2));
                String op = node.getChildren().get(1).getValue();
                String temp = getTemp();
                instructions.add("pop " + temp);
                instructions.add("pop " + temp);
                instructions.add(op + " " + temp);
                instructions.add("push " + temp);
                break;
            case "Number":
                instructions.add("push " + node.getValue());
                break;
            case "Identifier":
                instructions.add("push " + node.getValue());
                break;
            default:
                throw new IllegalArgumentException("Invalid node type: " + node.getType());
        }
    }

    private String getTemp() {
        return "t" + tempCounter++;
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
