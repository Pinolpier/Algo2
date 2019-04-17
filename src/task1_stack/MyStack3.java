package task1_stack;

public class MyStack3<T> {
    Object[] stack;
    int counter;
    private T value;

    public MyStack3() {
        stack = new Object[10];
        counter = 0;
    }

    public static void main(String[] args) {
        MyStack3<String> stack = new MyStack3();
        for (int i = 1; i <= 30; i++) {
            stack.push(Integer.toString(i));
        }
        for (int i = 0; i < 25; i++) {
            System.out.println(stack.pop());
        }
        for (int i = 10; i <= 45; i++) {
            stack.push(Integer.toString(i));
        }
        for (int i = 0; i < 55; i++) {
            System.out.println(stack.pop());
        }
    }

    public void push(T element) {
        if (counter + 1 == stack.length) {
            Object[] buffer = new Object[stack.length + 10];
            for (int i = 0; i < stack.length; i++) {
                buffer[i] = stack[i];
            }
            stack = buffer;
        }
        stack[counter++] = element;
    }

    public T pop() {
        if (counter + 20 < stack.length) {
            Object[] buffer = new Object[stack.length - 10];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = stack[i];
            }
            stack = buffer;
        }
        if (counter == 0) {
            @SuppressWarnings("unchecked") final T t = (T) stack[0];
            return t;
        } else {
            @SuppressWarnings("unchecked") final T t = (T) stack[--counter];
            return t;
        }
    }
}
