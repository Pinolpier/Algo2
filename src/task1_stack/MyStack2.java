package task1_stack;

public class MyStack2 {
    String[] stack;
    int counter;

    public MyStack2() {
        stack = new String[10];
        counter = 0;
    }

    public static void main(String[] args) {
        //Zu Testzwecken mehr pushen als durch die ursprünglich implementierte Array Länge erlaubt und so die automatische Vergrößerung des Stacks testen
        MyStack2 stack = new MyStack2();
        for (int i = 1; i <= 25; i++) {
            stack.push(Integer.toString(i));
        }
        //Ein bisschen was poppen und dann...
        for (int i = 0; i < 20; i++) {
            System.out.println(stack.pop());
        }
        //...wieder etwas pushen, nur um es wieder zu Testzwecken zu...
        for (int i = 10; i <= 40; i++) {
            stack.push(Integer.toString(i));
        }
        //...poppen. Aber mehr Poppen, als überhaupt gepusht wurde
        for (int i = 0; i < 50; i++) {
            System.out.println(stack.pop());
        }
    }

    public void push(String element) {
        if (counter + 1 == stack.length) { //Wenn der Stack seine Kapazität erreicht hat muss er vergrößert werden, wenn weiter gepusht wird
            String[] buffer = new String[stack.length + 10]; //Hierfür einen neuen zugrundeliegenden Array initialisieren und
            for (int i = 0; i < stack.length; i++) { //die Daten des alten manuell kopieren
                buffer[i] = stack[i];
            }
            stack = buffer;
        }
        stack[counter++] = element;
    }

    public String pop() {
        if (counter + 20 < stack.length) { //Falls der Puffer zu groß wird sollte wieder Speicher freigegeben werden.
            String[] buffer = new String[stack.length - 10];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = stack[i];
            }
            stack = buffer;
        }
        if (counter == 0) {
            return stack[0];
        } else {
            return stack[--counter];
        }
    }
}