package task1_stack;

public class MyStack {
    int maximumElements, counter;
    String[] stack;

    public MyStack(int maximumElements) {
        this.maximumElements = maximumElements;
        stack = new String[this.maximumElements];
        counter = 0;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push("Hello");
        myStack.push("World");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push("Bye");
        myStack.push("Bye");
        myStack.push("World");
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

    public boolean push(String element) {
        if (counter == maximumElements - 1) {
            return false;
        } else {
            stack[counter++] = element;
            return true;
        }
    }

    public String pop() {
        if (counter == 0) {
            return stack[0];
        } else {
            return stack[--counter];
        }
    }

    public int getMaximumElements() {
        return maximumElements;
    }

    public int getCounter() {
        return counter + 1;
    }
}
