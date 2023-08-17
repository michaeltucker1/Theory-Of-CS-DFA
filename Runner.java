import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            List<Token> tokens = LexicalAnalyser.analyse("+249 + 849");

            for (Token tk : tokens) {
                System.out.println(tk.getValue());
                System.out.println(tk.getType() + "\n");
            }

        }
        catch (NumberException e) {

        }
        catch (ExpressionException e) {
            
        }
    }
}
