public class LinkedList<T> implements List<T>{
    // Instance variables
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    // Constructors
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    // Getters
    public Node<T> getHead(){
        return this.head;
    }
    public Node<T> getTail(){
        return this.tail;
    }

    // Overrides
    @Override
    public void addAtIndex(T data, int index){

    }

}
