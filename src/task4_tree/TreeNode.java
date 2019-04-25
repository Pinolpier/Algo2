package task4_tree;

import java.util.ArrayList;

public class TreeNode<Item> {
    Item item;
    TreeNode<Item> parent;
    ArrayList<TreeNode<Item>> children;

    public TreeNode(Item item, TreeNode<Item> parent) {
        this.item = item;
        this.parent = parent;
        children = new ArrayList<TreeNode<Item>>();
    }

    /**
     * @param toFind String to search in the tree structure
     * @return A string representing the way to the found element. Empty if element isn't found or length 1 if element is represented by the root.
     * <p>
     * Berechnung äquivalent zu path() beim Binärbaum
     */
    public String path(Item toFind) {
        if (parent != null) {
            return parent.path(toFind);
        } else { //If parent == null meaning recursion is in root
            String path = pathBelow(toFind);
            if (path.equals("#")) {
                return "()";
            } else {
                path = path.substring(0, path.length() - 2);
                return "(" + path + ")";
            }
        }
    }

    /**
     * @param toFind DO NOT CALL THIS METHOD - JUST FOR INTERNAL RECURSION PURPOSES (auf Grund schlechten Stils kannn diese Methode nicht private sein...)
     * @return DO NOT CALL THIS METHOD - JUST FOR INTERNAL RECURSION PURPOSES (auf Grund schlechten Stils kannn diese Methode nicht private sein...)
     */
    public String pathBelow(Item toFind) {
        if (item.equals(toFind)) {
            return "\"" + item + "\", ";
        } else {
            for (TreeNode<Item> child : children) {
                String i = child.pathBelow(toFind);
                if (!(i.equals("#"))) {
                    return "\"" + item.toString() + "\", " + i;
                }
            }
            return "#";
        }
    }

    /**
     * @param i gibt die Einrückung an
     */
    public void printTree(int i) {
        String toPrint = "";
        for (int j = 0; j < i; j++) { //Eine Einrückung erzeugen
            toPrint += "\t";
        }
        System.out.println(toPrint + item.toString()); //Ausgabe inklusive Einrückung
        i++;
        for (TreeNode<Item> child : children) {
            child.printTree(i); //Alle Kinder eine Stufe weiter eingerückt ausgeben
        }
    }

    public void printTreeLevels() {
        int i = 1;
        while (true) { //So lange alle Elemente einer Ebene printen...
            String text = getChildsOfLevel(i - 1); //nutzen der Hilfsmethode, um alle Knoten eines bestimmten Levels zu erhalten
            int l = text.length();
            if (l == 0) //...bis diese leer ist
                return;
            text = text.substring(0, l - 2); //Formatierungsarbeit
            System.out.println(i + "\t" + text);
            i++;
        }
    }

    //Hilfsmethode zur Berechnung in printTreeLevels()
    public String getChildsOfLevel(int i) { //sehr ineffizient, weil Bäume nicht für Iterationen über ein bestimmtes Level gemacht sind
        String text = "";
        if (i == 0) { //Wenn vom aktuellen Level gesucht, dann den eigenen Wert zurückgeben, damit dieser angehängt wird
            return item.toString() + ", ";
        }
        for (TreeNode<Item> child : children) {
            text += child.getChildsOfLevel(i - 1); //Sonst die Kinder auffordern und als gesuchtes Level (ab den Kindern) um 1 reduzieren
        }
        return text;
    }
}
