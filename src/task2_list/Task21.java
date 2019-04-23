package task2_list;

public class Task21 { //Code unkommentiert, da de facto wie in der VL gezeigt
    public static void main(String[] args) {
        //Erzeugen Sie äquivalent zum Beispiel eine Liste mit 3 Nodes, so dass die Liste (1, 3, 4) entsteht.
        Node<Integer> n1 = new Node<Integer>();
        Node<Integer> n3 = new Node<Integer>();
        Node<Integer> n4 = new Node<Integer>();
        n1.item = 1;
        n3.item = 3;
        n4.item = 4;
        n1.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
        System.out.println();

        //Schreiben Sie Code, der die existierende Struktur so verändert, dass durch Einfügen die Liste (1, 2, 3, 4) entseht.
        Node<Integer> n2 = new Node<Integer>();
        n2.item = 2;
        n1.next = n2;
        n2.next = n3;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
        System.out.println(n1.next.next.next.item);
        System.out.println();

        //Entfernen Sie dann den Node mit der Zahl 3, so dass (1, 2, 4) entsteht.
        n2.next = n4;
        System.out.println(n1.item);
        System.out.println(n1.next.item);
        System.out.println(n1.next.next.item);
    }
}
