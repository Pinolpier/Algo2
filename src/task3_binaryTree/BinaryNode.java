package task3_binaryTree;


/**
 * represents a node in a binary tree.
 * Mir ist bewusst, dass die Implementierung nicht sehr schön ist, Methoden sind public, die es nicht sein sollten,
 * Code ist teilweise logisch dupliziert (find und path Methode), etc.
 * Ich verstoße gegen diverse Paradigmen der Objektorientierten Programmierung.
 * Jedoch funktioniert der Algorithmus und ein großen Code Cleanup ist langweilig und nicht notwendig...
 */
public class BinaryNode {
    String item;
    BinaryNode parent, left, right;

    /**
     * @param item   The item represented in this root
     * @param parent New nodes must have a parent or null, if this is the trees root
     */
    public BinaryNode(String item, BinaryNode parent) {
        this.item = item;
        this.parent = parent;
    }

    /**
     * @param toFind String to search in the tree structure
     * @return true only if the given parameter is represented by a node in the tree otherwise false
     */
    public boolean find(String toFind) {
        if (parent != null) {
            return parent.find(toFind);
        } else { //If parent == null meaning recursion is in root
            return findBelow(toFind);
        }
    }

    /**
     * @param toFind DO NOT CALL THIS METHOD - JUST FOR INTERNAL RECURSION PURPOSES (auf Grund schlechten Stils kannn diese Methode nicht private sein...)
     * @return DO NOT CALL THIS METHOD - JUST FOR INTERNAL RECURSION PURPOSES (auf Grund schlechten Stils kannn diese Methode nicht private sein...)
     */
    public boolean findBelow(String toFind) {
        if (item.equals(toFind)) {
            return true;
        } else {
            boolean l = false, r = false;
            if (left != null) {
                l = left.findBelow(toFind);
            }
            if (right != null) {
                r = right.findBelow(toFind);
            }
            return (l || r);
        }
    }

    /**
     * @param toFind String to search in the tree structure
     * @return A string representing the way to the found element. Empty if element isn't found or length 1 if element is represented by the root.
     */
    public String path(String toFind) {
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
    public String pathBelow(String toFind) {
        if (item.equals(toFind)) {
            return "\"" + item + "\", ";
        } else {
            if (left != null) {
                String i = left.pathBelow(toFind);
                if (!(i.equals("#"))) {
                    return "\"" + item + "\", " + i;
                }
            }
            if (right != null) {
                String i = right.pathBelow(toFind);
                if (!(i.equals("#"))) {
                    return "\"" + item + "\", " + i; //Wenn es einen Knoten unten gibt, der das Element beinhaltet gib den Pfad von  hier bis zum gesuc hten Objekt zurück!
                }
            }
            //# als Zeichen, dass unterhalb dieses Knotens das gesuchte Objekt nicht existiert.
            return "#";
        }
    }
}