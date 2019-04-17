package task1_stack;

public class arithExpression {

    public static double arithExpression(String in) {
        String exp = in.trim();
        exp = exp.replaceAll("\\s+", "");
        exp = exp.replaceAll("–", "-");
        MyStack3<Character> op = new MyStack3<>();
        MyStack3<Double> num = new MyStack3<>();
        for (int i = 0; i < exp.length(); i++) {
            char next = exp.charAt(i);
            switch (next) {
                case '(':
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
                    num.push(new Double(Integer.valueOf(next - '0')));
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    op.push(Character.valueOf(next));
                    break;
                case ')':
                    char operator = op.pop().charValue();
                    double num2 = num.pop().doubleValue();
                    double num1 = num.pop().doubleValue();
                    switch (operator) {
                        case '+':
                            num.push(num1 + num2);
                            break;
                        case '-':
                            num.push(num1 - num2);
                            break;
                        case '*':
                            num.push(num1 * num2);
                            break;
                        case '/':
                            num.push(num1 / num2);
                            break;
                    }
                    break;
            }
        }
        return num.pop();
    }

    public static void main(String[] args) {
        System.out.println(arithExpression(" ( 3 – ( 2 * 3 ) )"));
    }
}
