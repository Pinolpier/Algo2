package task1_stack;

public class MyStack2 {
    String[] stack;
    int counter;

    public MyStack2() {
        stack = new String[10];
        counter = 0;
    }

    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();
        for (int i = 0; i < 25; i++) {
            stack.push(Integer.toString(i));
        }
        for (int i = 0; i < 30; i++) {
            System.out.println(stack.pop());
        }
    }

    public void push(String element) {
        if (counter + 1 == stack.length) {
            String[] buffer = new String[stack.length + 10];
            for (int i = 0; i < stack.length; i++) {
                buffer[i] = stack[i];
            }
            stack = buffer;
        }
        stack[counter++] = element;
    }

    public String pop() {
        if (counter + 20 < stack.length) {
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