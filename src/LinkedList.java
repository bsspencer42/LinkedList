import java.util.NoSuchElementException;

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
        // Error handling - Invalid input
        if (index > size - 1 || index < 0){
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        // Loop to find data @ index
        int currentIndex = 0;              //
        Node<T> currentNode = head; // Pointer
        while (currentIndex < index){
            currentNode = currentNode.getNext();
            currentIndex += 1;
        }
        return currentNode.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        // Error handling - Invalid input
        if (index > size - 1 || index < 0){
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        // Removed node data
        T removedData = this.getAtIndex(index);

        // Pointer to previous node
        Node<T> previousNode = head;  // Pointer
        int currentIndex = 0;
        for (int i = 0; i < index - 1;i++){
            previousNode = previousNode.getNext();
            currentIndex += 1;
        }

        // Single node edge case
        if (size == 1){
            head = null;
            tail = null;
        }

        // Head edge case
        else if (index == 0){
            head = head.getNext();
        }

        // Tail edge case
        else if (index == size-1){
            previousNode.setNext(null);
        }

        // Normal case
        else {
            previousNode.setNext(previousNode.getNext().getNext());
        }
        size -= 1;
        return removedData;
    }

    @Override
    public T remove(T data) {
        // Error handling - Null data
        if (data == null){
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        // For loop to find data
        Node<T> searchNode = head;
        T currentData;
        for (int i = 0; i < size;i++){
            currentData = searchNode.getData();
            if (currentData.equals(data)){
                this.removeAtIndex(i);
                return currentData;
            }
            searchNode = searchNode.getNext();
        }

        // Else throw NoSuchElementException
        throw new NoSuchElementException("The data is not present in the list.");
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
        x.addAtIndex("T0",0);
        x.addAtIndex("T1",1);
        x.addAtIndex("T2",2);
        x.addAtIndex("T3",3);
        x.addAtIndex("T4",4);
        x.addAtIndex("T5",5);

        Node<String> currentNode = x.head;
        int index = 0;
        while (currentNode != null){
            System.out.println("Index " + index + " : " + currentNode.getData());
            currentNode = currentNode.getNext();
            index += 1;
        }
        System.out.println("Tail: " + x.tail.getData());
        System.out.println("Head: " + x.head.getData());
        System.out.println("Remove index 0: " + x.remove("T3"));

        currentNode = x.head;
        index = 0;
        while (currentNode != null){
            System.out.println("Index " + index + " : " + currentNode.getData());
            currentNode = currentNode.getNext();
            index += 1;
        }
    }
}
