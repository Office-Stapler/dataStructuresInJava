package datastructures;
public class Queue<type> {
    private LinkedList<type> list;
    private int length;
    /**
     * Initialises an empty queue with elements of type <type>
     */
    public Queue() {
        this.list = new LinkedList<type>();
        this.length = 0;
    }

    /**
     * Initialises a queue with an element of type <type>
     * @parem an object of type <type> t to be the start of the queue.
     */

    public Queue(type t) {
        this.list = new LinkedList<type>(t);
        this.length = 1;
    }

    /**
     * Gets the length of the queue
     * @return the length of the queue.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Enqueues an element into the queue.
     * @parem a type t (type is the specified object for the generic class).
     */
    public void enqueue(type t) {
        this.list.insertAtTail(t);
        this.length++;
    }


    /**
     * Dequeues the queue and returns it.
     * @return the first element added into the queue, this element is removed from
     * the queue.
     */

    public type dequeue() {
        ListNode<type> node = this.list.getAndRemoveHead();
        if (node == null)
            return null;
        this.length--;
        return node.getVal();
    }


}

