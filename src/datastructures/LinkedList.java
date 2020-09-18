package datastructures;

/**
 * Simple LinkedList class.
 */
public class LinkedList<type> {
    private ListNode<type> head;
    private ListNode<type> tail;
    private int length = 0;

    /**
     * Initialises the LinkedList with type val.
     * @param val the first element of the LinkedList.
     */

    public LinkedList(type val) {
        this.head = new ListNode<type>(val);
        this.tail = this.head;
        this.length++;
    }

    /**
     * Initialises an empty LinkedList
     */

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Inserts type val into the list if the list is empty
     * @param val the value to be inserted.
     */
    private void insertNull(type val) {
        if (this.head == null) {
            ListNode<type> insert = new ListNode<type>(val);
            this.head = insert;
            this.tail = insert;
            return;
        }
    }

    /**
     * Inserts an element val at the end of the list.
     * @param val the element to be inserted at the end.
     */
    public void insertAtTail(type val) {
        if (this.head == null) {
            insertNull(val);
            return;
        }

        ListNode<type> insert = new ListNode<type>(val);
        insert.setPrev(this.tail);
        this.tail.setNext(insert);
        tail = tail.getNext();
        this.length++;
    }

    /**
     * Prints the list.
     */

    public void printList() {
        ListNode<type> curr = this.head;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }

    /**
     * Reverses the current LinkedList.
     * All previos and next pointers are swapped.
     */

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

    /**
     * Prints the list in reverse.
     */

    public void printReverse() {
        for (ListNode<type> curr = this.tail; curr != null; curr = curr.getPrev()) {
            System.out.println(curr);
        }
    }

    /**
     * Gets the number of elements in the list
     * @return length, the length of the list
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Inserts an element of type <type> at the start of the list.
     * @param value the element to be inserted.
     */

    public void insertAtHead(type value) {
        ListNode<type> insert = new ListNode<type>(value);
        if (this.head == null) {
            insertNull(value);
            return;
        }
        this.head.setPrev(insert);
        insert.setNext(this.head);
        this.head = insert;
        this.length++;
    }

    /**
     * Removes the element at the specified index (indexes start at 0).
     * @param index the specified index to remove from the list.
     * @throws NodeOutOfBoundException when index is < 0 or >= than the current length.
     */
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

    /**
     * Gets the current head of the list.
     * @return head, the head of the current list.
     */
    public ListNode<type> getHead() {
        return this.head;
    }

    /**
     * Gets the current tail of the list.
     * @return tail, the tail of the current list.
     */
    public ListNode<type> getTail() {
        return this.tail;
    }

    /**
     * Removes the head of the list and returns the value.
     * @return head, the head of the current list.
     */
    public ListNode<type> getAndRemoveHead() {
        ListNode<type> temp = this.head;
        this.removeHead();
        return temp;
    }

    /**
     * Removes the tail of the list and returns the value.
     * @return tail, the tail of the current list.
     */
    public ListNode<type> getAndRemoveTail() {
        ListNode<type> temp = this.tail;
        this.removeTail();
        return temp;
    }

    /**
     * Removes the head of the list.
     */
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

    /**
     * Removes the tail of the list.
     */
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

/**
 * Specialised Node for LinkedLists, extends the basic Node.
 */
class ListNode<Type> extends Node<Type> {
    private ListNode<Type> next;
    private ListNode<Type> prev;

    /**
     * Initialises a Node with value val, and sets the next and prev to null.
     * @param val the value you want the node to store.
     */
    public ListNode(Type val) {
        super(val);
        this.next = null;
        this.prev = null;
    }

    /**
     * Sets the Node's next pointer.
     * @param next the next Node you want the current Node to point to.
     */
    public void setNext(ListNode<Type> next) {
        this.next = next;
    }

    /**
     * Gets the current Node's next Node.
     * @return next the Node that comes after the current Node.
     */
    public ListNode<Type> getNext() {
        return this.next;
    }

    /**
     * Gets the current Node's previous Node.
     * @return prev the Node that comes before the current Node.
     */
    public ListNode<Type> getPrev() {
        return this.prev;
    }

    /**
     * Sets the current Node's previous pointer
     * @param prev the previous Node that you want the current Node to point to.
     */
    public void setPrev(ListNode<Type> prev) {
        this.prev = prev;
    }
}

/**
 * Simple Exception that is raised for the list when user requests an index that isn't possible.
 */
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
