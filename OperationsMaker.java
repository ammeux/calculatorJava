import javax.swing.*;

class OperationsMaker {

    String makeOperations(String operations){

        Integer result = 0;
        StringBuilder addends = new StringBuilder("0");
        char previousOperator = '+';
        Calculator calculator = new Calculator();

        try {
            for (int i = 0; i < operations.length(); i++) {

                // case char is digit => append to addends stringBuilder
                if (Character.isDigit(operations.charAt(i)))
                    addends.append(operations.charAt(i));

                // case char is operator or is last char of operations
                if (operations.charAt(i) == '+' || operations.charAt(i) == '-' || operations.charAt(i) == '*' ||
                        operations.charAt(i) == '/' || operations.charAt(i) == '%' || i == operations.length() - 1) {

                    // make operation according to previous operator
                    switch (previousOperator) {
                        case '+':
                            if (addends.toString().equals("") && (operations.charAt(i) == '+' || operations.charAt(i) == '-'))
                                addends.append(operations.charAt(i));
                            else {
                                result = calculator.add(result, Integer.parseInt(addends.toString()));
                                addends = new StringBuilder();
                                previousOperator = operations.charAt(i);
                            }
                            break;

                        case '-':
                            if (addends.toString().equals("") && (operations.charAt(i) == '+' || operations.charAt(i) == '-'))
                                addends.append(operations.charAt(i));
                            else {
                                result = calculator.substract(result, Integer.parseInt(addends.toString()));
                                addends = new StringBuilder();
                                previousOperator = operations.charAt(i);
                            }
                            break;

                        case '*':
                            if (addends.toString().equals("") && (operations.charAt(i) == '+' || operations.charAt(i) == '-'))
                                addends.append(operations.charAt(i));
                            else {
                                result = calculator.multiply(result, Integer.parseInt(addends.toString()));
                                addends = new StringBuilder();
                                previousOperator = operations.charAt(i);
                            }
                            break;

                        case '/':
                            if(addends.toString().equals("0"))
                                throw new CalcException("Cannot divide by 0");
                            else if (addends.toString().equals("") && (operations.charAt(i) == '+' || operations.charAt(i) == '-'))
                                addends.append(operations.charAt(i));
                            else {
                                result = calculator.divide(result, Integer.parseInt(addends.toString()));
                                addends = new StringBuilder();
                                previousOperator = operations.charAt(i);
                            }
                            break;

                        case '%':
                            System.out.println(addends);
                            System.out.println(result);
                            result = calculator.modulo(result, Integer.parseInt(addends.toString()));
                            System.out.println(result);
                            addends = new StringBuilder();
                            previousOperator = operations.charAt(i);
                            break;
                    }
                }
            }
        }
        catch (CalcException exc){
            JOptionPane.showMessageDialog(null, exc, "INFO",JOptionPane.WARNING_MESSAGE);
        }
        return Integer.toString(result);
    }
}
