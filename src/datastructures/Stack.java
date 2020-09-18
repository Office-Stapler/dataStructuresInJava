package datastructures;

public class Stack<type> {
    private LinkedList<type> list;
    private int length;

    /**
     * Initialises an empty stack with elements of type <type>
     */
    public Stack() {
        this.length = 0;
        this.list = new LinkedList<type>();
    }
    /**
     * Initialises a stack with an element of type <type>
     * @parem an object of type <type> t to be the start of the queue.
     */
    public Stack(type t) {
        this.length = 1;
        this.list = new LinkedList<type>(t);
    }
    /**
     * Gets the length of the stack
     * @return the length of the stack.
     */
    public int getLength() {
        return this.length;
    }
    /**
     * Pushes an element into the stack.
     * @parem a type t (type is the specified object for the generic class).
     */
    public void push(type val) {
        this.list.insertAtTail(val);
        this.length++;
    }
    /**
     * Pops the stack and returns it.
     * @return the lastest element added into the stack, this element is removed from
     * the stack.
     */
    public ListNode<type> pop() {
        ListNode<type> node = this.list.getAndRemoveTail();
        if (node == null) return null;
        this.length--;
        return this.list.getAndRemoveTail();
    }


}
