public class Node<E> {
    // Instance variables
    private E data;
    private Node<E> next;

    // Constructors
    public Node(E data){
        this(data, null);
    }
    public Node(E data, Node<E> next){
        this.data = data;
        this.next = next;
    }

    // Getters
    public E getData(){
        return this.data;
    }
    public Node<E> getNext(){
        return next;
    }

    // Setters
    public void setData(E data){
        this.data = data;
    }
    public void setNext(Node<E> next){
        this.next = next;
    }
}
