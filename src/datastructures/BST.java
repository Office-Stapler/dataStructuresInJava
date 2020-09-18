package datastructures;

public class BST {
    private treeNode root;

    public BST() {
        root = null;
    }

    public BST(int val) {
        root = new treeNode(val);
    }

    public void insertValue(int val) {
        _insertValue(val, root);
    }

    private void _insertValue(int val, treeNode root) {
        if (root == null)
            return;
        if (val < root.getVal()) {
            if (root.getLeft() == null) {
                root.setLeft(new treeNode(val));
            } else {
                _insertValue(val, root.getLeft());
            }
        } else if (val > root.getVal()) {
            if (root.getRight() == null) {
                root.setRight(new treeNode(val));
            } else {
                _insertValue(val, root.getRight());
            }
        }
    }

    public int countNodes() {
        return _countNodes(root);
    }

    private int _countNodes(treeNode root) {
        if (root == null)
            return 0;
        return _countNodes(root.getLeft()) + _countNodes(root.getRight()) + 1;
    }

    
}

class treeNode extends Node<Integer> {
    private treeNode left;
    private treeNode right;

    public treeNode(int val) {
        super(val);
        this.left = null;
        this.right = null;
    }

    public void setLeft(treeNode left) {
        this.left = left;
    }

    public void setRight(treeNode right) {
        this.right = right;
    }

    public treeNode getLeft() {
        return left;
    }

    public treeNode getRight() {
        return right;
    }
}