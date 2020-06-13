package dataStructuresInJava;

public class LinkedList<type> {
    private ListNode<type> head;
    private ListNode<type> tail;
    private int length = 0;
    public LinkedList(type val) {
        this.head = new ListNode<type>(val);
        this.tail = this.head;
        this.length++;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    
    private void insertNull(type val) {
        ListNode<type> insert = new ListNode(val);
        if (this.head == null) {
            this.head = insert;
            this.tail = insert;
            return;
        }
    }

    public void insertAtTail(type val) {
        if (this.head == null) {
            insertNull(val);
            return;
        }

        ListNode<type> insert = new ListNode<type>(val);
        insert.setPrev(this.tail);
        this.tail.setNext(insert);
        this.tail = this.tail.getNext();
        this.length++;
    }

    public void printList() {
        ListNode curr = this.head;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }

    public void reverseList() {
        ListNode<type> curr = this.head;
        ListNode<type> temp = null;
        while (curr != null) {
            temp = curr.getPrev();
            curr.setPrev(curr.getNext());
            curr.setNext(temp);
            curr = curr.getPrev();
        }
        if (temp == null)
            return;

        temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }

    public void printReverse() {
        for (ListNode<type> curr = this.tail; curr != null; curr = curr.getPrev()) {
            System.out.println(curr);
        }
    }

    public int getLength() {
        return this.length;
    }

    public void insertAtHead(type value) {
        ListNode<type> insert = new ListNode(value);
        if (this.head == null) {
            insertNull(value);
            return;
        }
        this.head.setPrev(insert);
        insert.setNext(this.head);
        this.head = insert;
        this.length++;
    }

    public void removeAtIndex(int index) throws NodeOutOfBoundException {
        ListNode<type> curr = null;
        if (index < 0 || index >= this.length)
            throw new NodeOutOfBoundException("Out of range or invalid!", index);

        if (index == 0) {
            this.removeHead();
        } else if (index == this.length - 1) {
            this.removeTail();
        } else {
            for (int i = 0; i != index; i++)
                curr = curr.getNext();
            ListNode<type> prev = curr.getPrev();
            ListNode<type> next = curr.getNext();
            if (prev != null)
                prev.setNext(next);

            if (next != null)
                next.setPrev(prev);

            curr.setNext(null);
            curr.setPrev(null);
        }
    }

    public ListNode<type> getHead() {
        return this.head;
    }

    public ListNode<type> getTail() {
        return this.tail;
    }

    public ListNode<type> getAndRemoveHead() {
        ListNode<type> temp = this.head;
        this.removeHead();
        return temp;
    }

    public ListNode<type> getAndRemoveTail() {
        ListNode<type> temp = this.tail;
        this.removeTail();
        return temp;
    }

    public void removeHead() {
        if (this.head == null)
            return;

        ListNode<type> next = this.head.getNext();
        ListNode<type> prev = this.head.getPrev();

        if (next != null)
            next.setPrev(prev);
    
        if (prev != null)
            prev.setNext(next);

        if (this.head == this.tail)
            this.tail = null;

        this.head = next;
    }

    public void removeTail() {
        if (this.head == null)
            return;
        
        ListNode<type> prev = this.tail.getPrev();
    
        if (prev != null)
            prev.setNext(null);

        if (this.head == this.tail)
            this.head = null;

        this.tail = prev;
    }
}

class ListNode<Type> extends Node<Type> {
    private ListNode<Type> next;
    private ListNode<Type> prev;
    public ListNode(Type val) {
        super(val);
        this.next = null;
        this.prev = null;
    }

    public void setNext(ListNode<Type> next) {
        this.next = next;
    }

    public ListNode getNext() {
        return this.next;
    }

    public ListNode getPrev() {
        return this.prev;
    }

    public void setPrev(ListNode<Type> prev) {
        this.prev = prev;
    }
}

class NodeOutOfBoundException extends Exception {
    static final long serialVersionUID = 0;
    private final int index;
    private final String err;
    public NodeOutOfBoundException(String err, int index) {
        this.index = index;
        this.err = err;
    }

    public String toString() {
        return String.format("Error for index %d. %s", index, err);
    }
}
