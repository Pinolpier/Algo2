package task2_list;

public class MyNodeList<Item> {
    private Item item;
    private Node2<Item> first;
    private Node2<Item> last;

    public MyNodeList() {
        first = new Node2<>();
        last = new Node2<>();
        first.next = last;
        last.next = null;
        first.last = null;
        last.last = first;
    }

    public static void main(String[] args) {
        MyNodeList<Integer> list = new MyNodeList<>();
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
        Node2<Item> iter = first;
        boolean empty = true;
        while (iter.next != null) {
            empty = empty && iter.item == null;
            Node2<Item> buffer = iter.next;
            iter = buffer;
        }
        empty = empty && iter.item == null;
        return empty;
    }

    /**
     * @return the amount of elements in the list. Empty elements will not be counted!
     */
    public int length() {
        Node2<Item> iter = first;
        int count = 0;
        while (iter.next != null) {
            if (iter.item != null)
                count++;
            Node2<Item> buffer = iter.next;
            iter = buffer;
        }
        if (iter.item != null)
            count++;
        return count;
    }

    /**
     * @param index index of the element to return – must be greater than 0 and smaller than MyNodeList.length() – no exception handling implemented
     * @return the element at the given index
     */
    public Item elementAt(int index) {
        Node2<Item> iter = first;
        for (int i = 0; i < index; i++) {
            Node2<Item> buffer = iter.next;
            iter = buffer;
        }
        return iter.item;
    }

    /**
     * @param element inserts the element at the first position of the index
     */
    public void prepend(Item element) {
        if (first.item == null) {
            first.item = element;
        } else {
            Node2<Item> iter = new Node2<>();
            iter.item = element;
            iter.next = first;
            iter.last = null;
            first.last = iter;
            first = iter;
        }
    }

    /**
     * @param element inserts the element at the end of the list
     */
    public void append(Item element) {
        if (first.item == null) {
            first.item = element;
        } else {
            if (last.item == null) {
                last.item = element;
            } else {
                Node2<Item> iter = new Node2<>();
                iter.item = element;
                iter.next = null;
                iter.last = last;
                last.next = iter;
                last = iter;
            }
        }
    }

    /**
     * @param index   index where to insert the element
     * @param element element to be inserted at the given index
     */
    public void insertAt(int index, Item element) {
        Node2<Item> iter = first;
        for (int i = 0; i < index - 1; i++) {
            Node2<Item> buffer = iter.next;
            iter = buffer;
        }
        Node2<Item> newElement = new Node2<>();
        newElement.item = element;
        newElement.next = iter.next;
        newElement.next.last = newElement;
        iter.next = newElement;
        newElement.last = iter;
    }

    /**
     * @param index removes the element at the given index from the list.
     *              List doesn't keep any references to this element so
     *              Garbage Collector is probably destroying it soon after calling this method.
     */
    public void remove(int index) {
        Node2<Item> iter = first;
        try {
            for (int i = 0; i < index; i++) {
                Node2<Item> buffer = iter.next;
                iter = buffer;
            }
            if (iter == null)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Index darf maximal length-1 sein! Letztes Element wird removed.");
            iter = last;
        }
        if (iter == first) {
            if (iter.next == last) {
                iter.item = null;
            } else {
                first = iter.next;
                first.last = null;
            }
        } else {
            if (iter == last) {
                if (iter.last == first) {
                    iter.item = null;
                } else {
                    last = iter.last;
                    last.next = null;
                }
            } else {
                iter.next.last = iter.last;
                iter.last.next = iter.next;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"");
        Node2<Item> iter = first;
        while (iter != null) {
            if (iter.item != null) {
                sb.append(iter.item.toString());
            }
            sb.append("\"; \"");
            Node2<Item> buffer = iter.next;
            iter = buffer;
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append("}");
        //sb.append(iter.item.toString());
        return sb.toString();
    }
}
