import java.math.BigInteger; 
// imported for you, so you can use BigInteger objects to detect integer over/underflows
// delete if you want to do this differently

public class RPNCalculator {
	private Stack<String> stack;
	private int size;
	
	public RPNCalculator (int initSize) {
		stack = new StackArray<String>(initSize);
		size = initSize;
	}
	 
	public int calculate(String[] expression) throws CalculatorException {	
		String operand1 = "";
		String operand2 = "";
		String operator = "";
		String result = "";
		//token validation 
		try{
			for(int i = 0; i < expression.length;i++){
				if(isOperand(expression[i])){
					stack.push(expression[i]);
				}else if(isOperator(expression[i])){
					stack.push(expression[i]);
				}else{
					throw new CalculatorException("Invalid token");
				}
				
			}
		}catch (StackException e){
			size *= 2;
			stack = new StackArray(size);
		}
	
		stack.popAll();
		
		try{
			for(int i = 0; i < expression.length; i++){
				operator = expression[i];
				if(isOperator(operator)){
					if(!stack.isEmpty()){
						operand2 = stack.pop();
					}else{
						throw new CalculatorException("Invalid expression");
					}
					if(!stack.isEmpty()){
						operand1 = stack.pop();
					}else{
						throw new CalculatorException("Invalid expression");
					}
					result = compute(operator, operand1, operand2);
					stack.push(result);
				} else if(isOperand(operator)){
					stack.push(operator);
				}
			}
		}
		catch(StackException e){}

		try{
			return Integer.parseInt(stack.pop());
		}catch(StackException e){}
		return 0; 
	} 
	
	private boolean isOperator(String token){
		return (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*"));
	}
	
	private boolean isOperand(String token){
		try{
			Integer.parseInt(token);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
	}
	
	private String compute(String operator, String operand1, String operand2) throws CalculatorException { 
		String result = "";
		BigInteger operation;
		BigInteger firstOperand = new BigInteger(operand1);
		BigInteger secondOperand = new BigInteger(operand2);
		BigInteger minimum = new BigInteger("-2147483648");
		BigInteger maximum = new BigInteger("2147483647");
        switch (operator){
            case "+":
				operation = firstOperand.add(secondOperand);
				if(operation.compareTo(maximum) == 1){
					throw new CalculatorException("integer overflow");
				}
				
                result = operation.toString();
                break;
            case "-":
                operation = firstOperand.subtract(secondOperand);
				if(operation.compareTo(minimum) == -1){
					throw new CalculatorException("integer underflow");
				}	
				
				result = operation.toString();
                break;
            case "*":
                operation = firstOperand.multiply(secondOperand);
				if(operation.compareTo(maximum) == 1){
					throw new CalculatorException("integer overflow");
				}else if(operation.compareTo(minimum) == -1){
					throw new CalculatorException("integer underflow");
				}
				
				result = operation.toString();
                break;
            case "/":
				if(operand2.equals("0")){
					throw new CalculatorException("division by zero");
				}
				
                operation = firstOperand.divide(secondOperand);
				result = operation.toString();
                break;
        }
        return result;
	}

}
