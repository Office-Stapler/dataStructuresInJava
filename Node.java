package dataStuctures;

public class Node<Type> {
    private Type val;
    
    public Node(Type val) {
        this.val = val;
    }

    public Type getVal() {
        return val;
    }

    public String toString() {
        return val.toString();
    }
}