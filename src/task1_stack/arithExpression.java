package task1_stack;

public class arithExpression {

    //Berechnet arithmetische Ausdrücke und nutzt hierfür einen Dijkstra Algorithmus mit MyStack3 Objekten
    public static double arithExpression(String in) {
        String exp = in.trim();
        exp = exp.replaceAll("\\s+", ""); //Mit Regex Leerzeichen entfernen
        exp = exp.replaceAll("–", "-"); //Minus auf dem AB ist nicht dasselbe, wie auf meiner Tastatur
        MyStack3<Character> op = new MyStack3<>();
        MyStack3<Double> num = new MyStack3<>();
        for (int i = 0; i < exp.length(); i++) { //Niemand braucht ein Semikolon zur String Ende Erkennung, die Länge reicht auch :P
            char next = exp.charAt(i);
            switch (next) { //switch case implementierung der Anleitung auf dem AB
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
                    double num2 = num.pop().doubleValue(); //Num2 zuerst einlesen, da Stacks die Reihenfolge vertauschen und Reihenfolge bei Subtraktion und Division relevant ist
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
