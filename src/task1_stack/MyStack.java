package task1_stack;

public class MyStack {
    int maximumElements, counter;
    String[] stack;

    public MyStack(int maximumElements) {
        this.maximumElements = maximumElements;
        stack = new String[this.maximumElements]; //Eigentlich ziemlich sinnfrei, die mächtigere Struktur Array durch einen simplen Stack zu ersetzen?
        counter = 0; //Zählen, an welchem Index im Array wir uns gerade bewegen
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        //In den Stack pushen muss umgekehrt sein, damit die Pops richtig sortiert sind
        myStack.push("World");
        myStack.push("Hello");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push("World");
        myStack.push("Bye");
        myStack.push("Bye");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public boolean push(String element) { //Boolean als return Wert, um erfolgreiche Operationen zu kennzeichnen
        if (counter == maximumElements - 1) { //Wenn kein Platz mehr als schlechte Fehlerbehandlung false returnen
            return false;
        } else {
            stack[counter++] = element; //Arbeiten mit dem Alten Wert und erst dann inkrementieren
            return true;
        }
    }

    public String pop() {
        if (counter == 0) { //Nicht weiter dekrementieren, wenn nur noch 1 Element im Stack ist, da Arrays der Länge null unmöglich sind und Index -1 Exception werfen würde
            return stack[0];
        } else {
            return stack[--counter]; //Arbeiten mit dem dekrementierten Wert
        }
    }

    public int getMaximumElements() {
        return maximumElements;
    }

    public int getCounter() {
        return counter + 1;
    }
}
