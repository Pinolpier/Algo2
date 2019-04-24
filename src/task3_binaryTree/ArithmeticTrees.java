package task3_binaryTree;

public class ArithmeticTrees {

    /**
     * Erzeugt diverse Baumstrukturen und gibt testweise Berechnungen auf diesen aus.
     */
    public static void main(String[] args) {
        BinaryNode treeA = exprA(), treeB = exprB(), treeC = exprC(), treeD = exprD();
        System.out.println(treeA.find("2"));
        System.out.println(treeA.find("4"));
        System.out.println(treeB.find("2"));
        System.out.println(treeC.find("-"));
        System.out.println(treeC.find("5"));
        System.out.println(treeD.find("*"));

        System.out.println(treeA.path("3"));
        System.out.println(treeA.path("+"));
        System.out.println(treeA.path("5"));
        System.out.println(treeB.path("3"));

    }


    //Im folgenden nur noch Methoden die Baumstrukturen mit Hilfe von BinaryNode erzeugen und zurückgeben
    private static BinaryNode exprA() {
        BinaryNode root = new BinaryNode("+", null);
        root.left = new BinaryNode("2", root);
        root.right = new BinaryNode("3", root);
        return root;
    }

    private static BinaryNode exprB() {
        BinaryNode root = new BinaryNode("*", null);
        root.left = new BinaryNode("5", root);
        root.right = new BinaryNode("+", root);
        root.right.left = new BinaryNode("2", root.right);
        root.right.right = new BinaryNode("3", root.right);
        return root;
    }

    private static BinaryNode exprC() {
        BinaryNode root = new BinaryNode("+", null);
        root.left = new BinaryNode("*", root);
        root.right = new BinaryNode("*", root);
        root.left.left = new BinaryNode("2", root.left);
        root.left.right = new BinaryNode("3", root.left);
        root.right.left = new BinaryNode("4", root.right);
        root.right.right = new BinaryNode("5", root.right);
        return root;
    }

    private static BinaryNode exprD() {
        BinaryNode root = new BinaryNode("*", null);
        root.left = new BinaryNode("2", root);
        root.right = new BinaryNode("*", root); // (3+4) * 5
        root.right.left = new BinaryNode("+", root.right);
        root.right.left.left = new BinaryNode("3", root.right.left);
        root.right.left.right = new BinaryNode("4", root.right.left);
        root.right.right = new BinaryNode("5", root.right);
        return root;
    }
}
