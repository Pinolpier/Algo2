package task2_list;

public class MyArrayList<Item> {
    private Item item;
    private Object[] array;
    private int length;

    public MyArrayList() {
        array = new Object[10];
        length = 0;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.append(1);
        list.append(6);
        list.insertAt(1, 5);
        list.insertAt(1, 4);
        list.insertAt(1, 3);
        list.insertAt(1, 2);
        list.append(7);
        System.out.println("Version 1: " + list.toString());
        System.out.println("Länge: " + list.length());
        System.out.println("Element an Index 3: " + list.elementAt(3));
        System.out.println();

        list.remove(0);
        list.remove(list.length() - 1);
        System.out.println("Version 2: " + list.toString());
        System.out.println("Länge: " + list.length());
        System.out.println("Element an Index 3: " + list.elementAt(3));
        System.out.println();

        list.prepend(1);
        list.append(7);
        System.out.println("Version 3: " + list.toString());
        System.out.println("Länge: " + list.length());
        System.out.println("Ist leer: " + list.isEmpty());
        System.out.println();

        int n = list.length();
        for (int i = 0; i < n; i++) {
            list.remove(0);
        }
        list.remove(1);
        System.out.println("Version 4: " + list.toString());
        System.out.println("Ist leer: " + list.isEmpty());
    }

    /**
     * @return true only if all elements of the list are empty (meaning null)
     */
    public boolean isEmpty() {
        boolean empty = true;
        for (Object obj : array) {
            empty = empty && obj == null;
        }
        return empty;
    }

    /**
     * @return the amount of elements in the list. Empty elements will not be counted!
     */
    public int length() {
        return length;
    }

    /**
     * @param index index of the element to return – must be greater than 0 and smaller than MyNodeList.length() – no exception handling implemented
     * @return the element at the given index
     */
    public Item elementAt(int index) {
        @SuppressWarnings("unchecked") final Item item = (Item) array[index];
        return item;
    }

    /**
     * @param element inserts the element at the first position of the index
     */
    public void prepend(Item element) {
        Object[] buffer;
        if (length + 1 > array.length) {
            buffer = new Object[length + 10];
        } else {
            buffer = new Object[array.length];
        }
        buffer[0] = element;
        for (int i = 0; i < length; i++) {
            buffer[i + 1] = array[i];
        }
        array = buffer;
        length++;
    }

    /**
     * @param element inserts the element at the end of the list
     */
    public void append(Item element) {
        Object[] buffer;
        if (length + 1 > array.length) {
            buffer = new Object[length + 10];
        } else {
            buffer = new Object[array.length];
        }
        for (int i = 0; i < length; i++) {
            buffer[i] = array[i];
        }
        buffer[length] = element;
        array = buffer;
        length++;
    }

    /**
     * @param index   index where to insert the element
     * @param element element to be inserted at the given index
     */
    public void insertAt(int index, Item element) {
        Object[] buffer;
        if (length + 1 > array.length) {
            buffer = new Object[length + 10];
        } else {
            buffer = new Object[array.length];
        }
        buffer[index] = element;
        for (int i = 0; i < length; i++) {
            if (i < index) { //Maybe index - 1 just trial and error
                buffer[i] = array[i];
            } else {
                buffer[i + 1] = array[i];
            }
        }
        array = buffer;
        length++;
    }

    /**
     * @param index removes the element at the given index from the list.
     *              List doesn't keep any references to this element so
     *              Garbage Collector is probably destroying it soon after calling this method.
     */
    public void remove(int index) {
        Object[] buffer;
        if (array.length - 20 > length) {
            buffer = new Object[array.length + 10];
        } else {
            buffer = new Object[array.length];
        }
        for (int i = 0; i < length; i++) {
            if (i < index) {
                buffer[i] = array[i];
            } else {
                buffer[i] = array[i + 1];
            }
        }
        array = buffer;
        length--;
        length = length < 0 ? 0 : length;
    }

    public String toString() {
        if (length == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"");
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            if (obj == null) {
                sb.append("");
            } else {
                sb.append(obj.toString());
            }
            sb.append("\"; \"");
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append("}");
        return sb.toString();
    }
}