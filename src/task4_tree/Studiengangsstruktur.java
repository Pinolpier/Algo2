package task4_tree;

public class Studiengangsstruktur {
    public static void main(String[] args) {
        //Im folgenden Initialisieren des Baumes
        TreeNode<String> root = new TreeNode<>("Hochschule", null);
        root.children.add(new TreeNode<String>("Informatik", root));
        root.children.get(0).children.add(new TreeNode<String>("Bachelor", root.children.get(0)));

        root.children.get(0).children.get(0).children.add(new TreeNode<String>("Angewandte Informatik", root.children.get(0).children.get(0)));
        root.children.get(0).children.get(0).children.get(0).children.add(new TreeNode<String>("Mobile Computing", root.children.get(0).children.get(0).children.get(0)));
        root.children.get(0).children.get(0).children.get(0).children.add(new TreeNode<String>("Psychologie", root.children.get(0).children.get(0).children.get(0)));

        root.children.get(0).children.get(0).children.add(new TreeNode<String>("Software Engineering", root.children.get(0).children.get(0)));
        root.children.get(0).children.get(0).children.get(1).children.add(new TreeNode<String>("Business", root.children.get(0).children.get(0).children.get(1)));
        root.children.get(0).children.get(0).children.get(1).children.add(new TreeNode<String>("Embedded", root.children.get(0).children.get(0).children.get(1)));
        root.children.get(0).children.get(0).children.get(1).children.add(new TreeNode<String>("Games", root.children.get(0).children.get(0).children.get(1)));

        root.children.get(0).children.add(new TreeNode<String>("Master", root.children.get(0)));
        root.children.get(0).children.get(1).children.add(new TreeNode<String>("Medizin Informatik Master", root.children.get(0).children.get(1)));

        root.children.add(new TreeNode<String>("Technik", root));
        root.children.get(1).children.add(new TreeNode<String>("Bachelor", root.children.get(1)));
        root.children.get(1).children.get(0).children.add(new TreeNode<String>("Maschinenbau", root.children.get(1).children.get(0)));

        //Jetzt folgen Methodenaufrufe um diese zu testen
        System.out.println(root.children.get(1).path("Mobile Computing"));
        System.out.println(root.path("bkabfasdbbjabdkfab"));
        System.out.println(root.path("Psychologie"));
        System.out.println(root.path("Technik"));
        System.out.println();
        System.out.println();

        root.printTree(0);
        root.children.get(1).printTree(0);
        System.out.println();
        System.out.println();


        root.printTreeLevels();
        root.children.get(0).printTreeLevels();
    }
}