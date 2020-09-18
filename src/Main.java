import datastructures.BST;
public class Main {
    public static void main (String[] args) {
        BST bst = new BST(5);
        bst.insertValue(7);
        System.out.println(bst.countNodes());
    }
}
