import java.util.List;
import java.util.ArrayList;

public class LexicalAnalyser {

	public static List<Token> analyse(String input) throws NumberException, ExpressionException {

		List<Token> tokens = new ArrayList<>();
		int currentState = 0;
		String buffer = "";

		for (char c : input.toCharArray()) {
			// Token.TokenType tokenType = Token.typeOf(c);
			
			switch(currentState){
				case 0: // Starting state
					switch(c) {
						case ' ':
							break;
						case '0':
							buffer += c;
							currentState = 3;
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							buffer += c;
							currentState = 2;
							break;
                        default:
							currentState = 1;
							throw new ExpressionException("Invalid Expresion!");
					}
					break;
				
				case 1: // Error State
					break;

				case 2: // Number state
					switch(c) {
						case ' ':
							break;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            buffer += c;
                            break;
                        default:
                            tokens.add(new Token(Integer.parseInt(buffer)));
                            buffer = "";
                            currentState = 0;
                            break;
                    }
					break;
				
				case 3:
					switch(c){
						case ' ':
							break;
						case '0':
						case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
							currentState = 1;
							break;
						case '.':
							buffer += c;
							currentState = 0;
							break;
						case '+':
						case '-':
						case '/':
						case '*':
							tokens.add(new Token(Token.typeOf(c)));
							currentState = 0;
							break;
					}
				
                default:
			}








			// // Start State
			// if (currentState == 0){
				
			// 	// If first digit isnt a number then immediately go to state 1 (error)
			// 	if (tokenType != Token.TokenType.NUMBER) {
			// 		currentState = 1;
			// 	}else {
			// 		buffer += c;
			// 		System.out.println("First buffer: "+ buffer);
			// 		currentState = 2;
			// 	}

			// }else if (currentState == 2) { 
			// 	if (tokenType != Token.TokenType.NUMBER) {
			// 		tokens.add(new Token(Integer.parseInt(buffer)));
			// 		// tokens.add(new Token(tokenType));
			// 		buffer = "";
			// 		currentState = 0;
			// 	}else if (tokenType == Token.TokenType.NUMBER) {
			// 		System.out.println("Second buffer: " + buffer);
			// 	}	
			// }


		}

		return tokens;
	}


}


// if (tokenType == Token.TokenType.NONE) {
// 	System.out.println("none");
// } else {
// 	if (tokenType == Token.TokenType.NUMBER) {
// 		currentState += 1;
// 	}
// }