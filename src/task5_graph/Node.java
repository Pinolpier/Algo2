package task5_graph;

import java.util.ArrayList;


//Durch versehentliche unerlaubte Verwendung einer for each loop auf einer Array List nicht lauffähig. Fix wird versucht, trotzdem schonmal die Abgabe soweit!


public class Node {
    private String item;
    private ArrayList<Edge> children;

    public Node(String item) {
        this.item = item;
        children = new ArrayList<>();
    }

    public static int dijkstra(Node start, Node end) {
        //"Falsche" Verwendung eines Edge Objekt, um die jeweils aktuelle Distanz zu den Knoten anzugeben
        ArrayList<Edge> nodes = new ArrayList<>();
        nodes.add(new Edge(start, 0));
        boolean allFound = false;
        while (!allFound) { //Die while Schleife holt sich alle Knoten und addet diese in die ArrayList mit Distanz -1, d.h. unendlich
            allFound = true;
            for (Edge i : nodes) {
                Node j = i.getNode(); //Alle Vorhanden
                for (Edge k : j.getChildren()) {
                    Node l = k.getNode(); //Kind eines Vorhandenen
                    boolean exists = false;
                    for (Edge m : nodes) {
                        Node n = m.getNode(); //Alle Vorhandenen erneute Iteration
                        if (l == n) {
                            exists = true;
                        }
                    }
                    if (!exists) {
                        nodes.add(new Edge(l, -1));
                        allFound = false;
                    }
                }
            }
        }

        //Im Folgenden Dijkstra Algo auf nodes ausführen
        dijkstraLoop(start, nodes);
        for (Edge i : nodes) {
            if (i.getNode().equals(end)) {
                return i.getWeight();
            }
        }

        return -1;
    }

    private static void dijkstraLoop(Node start, ArrayList<Edge> nodes) {
        int minimumDistance = start.getChildren().get(0).getWeight();
        for (Edge i : start.getChildren()) {
            minimumDistance = (i.getWeight() < minimumDistance) ? i.getWeight() : minimumDistance;
        }
        for (Edge i : start.getChildren()) {
            if (i.getWeight() == minimumDistance) {
                for (Edge j : nodes) {
                    if (i.getNode().equals(j.getNode())) {
                        j.setWeight(minimumDistance);
                        dijkstraLoop(j.getNode(), nodes);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        //Initialisierung des Graphen aus der Aufgabenstellung
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        a.addChild(b, 5);
        a.addChild(c, 2);
        a.addChild(d, 1);
        b.addChild(d, 4);
        c.addChild(b, 1);
        c.addChild(d, 2);
        d.addChild(b, 2);

        System.out.println("Distanz von a nach b: " + dijkstra(a, b));
        System.out.println("Distanz von a nach c: " + dijkstra(a, c));
        System.out.println("Distanz von a nach d: " + dijkstra(a, d));
    }

    public ArrayList<Edge> getChildren() {
        return children;
    }

    public void addChild(Node child, int weight) {
        children.add(new Edge(child, weight));
    }
}
