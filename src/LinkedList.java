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
        // Error handling - Invalid input
        if (index > size || index < 0){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        else if (data == null){
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        // Create new node
        Node<T> newNode = new Node<>(data); // Create new node w/ no pointer
        // If first element
        if (index == 0){
            if (head == null){
                head = newNode;
                tail = newNode;
            } // Edge case for empty list
            else {
                newNode.setNext(head);
                head = newNode;
            }
        }
        // If inner element
        else if (index < size){
            Node<T> prevNode = head;
            for (int i = 0; i < index-1; i++){
                prevNode = prevNode.getNext();
            } // Get node before target
            newNode.setNext(prevNode.getNext()); // Set new node's next to previous node next next
            prevNode.setNext(newNode); // Set prev node to point to current node
        }
        // If last element
        else{
            tail.setNext(newNode);
            tail = newNode;
        }
        // Increment size
        size += 1;
        return;


    }

    @Override
    public T getAtIndex(int index) {
        return null;
    }

    @Override
    public T removeAtIndex(int index) {
        return null;
    }

    @Override
    public T remove(T data) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {
        LinkedList<String> x = new LinkedList<>();
        x.addAtIndex("Test",0);
        x.addAtIndex("Test2",1);
        x.addAtIndex("Middle",2);
        x.addAtIndex("Middle2",3);
        x.addAtIndex("End",4);
        x.addAtIndex("Index1",1);
        x.addAtIndex("Index0",0);

        Node<String> currentNode = x.head;
        while (currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println("Tail: " + x.tail.getData());
        System.out.println("Head: " + x.head.getData());
    }
}
