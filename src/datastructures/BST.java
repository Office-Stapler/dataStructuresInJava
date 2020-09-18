package datastructures;

import java.util.ArrayList;
import java.util.Collections;

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

    public int maxDepth() {
        return _maxDepth(root);
    }

    private int _maxDepth(treeNode root) {
        if (root == null) 
            return 0;
        int left = _maxDepth(root.getLeft());
        int right = _maxDepth(root.getRight());
        return Math.max(left, right) + 1;
    }

    public void printTree() {
        int depth = maxDepth();
        ArrayList<treeNode> list = new ArrayList<treeNode>();
        list.add(root);
        BSTPrint bstprint = new BSTPrint(depth);
        bstprint.print(list, 1);
    }
    
}


// Code provided by "https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram"
class BSTPrint {
    private int height;
    public BSTPrint(int height) {
        this.height = height;
    }

    private boolean isAllNull(ArrayList<treeNode> nodes) {
        for (treeNode node : nodes) 
            if (node != null)
                return false;
        return true;
    } 

    public void print(ArrayList<treeNode> nodes, int level) {
        if (nodes.isEmpty() || isAllNull(nodes))
            return;
        int floor = height - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhiteSpaces(firstSpaces);

        ArrayList<treeNode> newNodes = new ArrayList<treeNode>();
        for (treeNode node : nodes) {
            if (node != null) {
                System.out.print(node.getVal());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhiteSpaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhiteSpaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhiteSpaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                printWhiteSpaces(1);

                printWhiteSpaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                printWhiteSpaces(1);

                printWhiteSpaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }
        print(newNodes, level + 1);
    }

    private void printWhiteSpaces(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
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