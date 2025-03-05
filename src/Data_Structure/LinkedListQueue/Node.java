package Data_Structure.LinkedListQueue;

class Node<E> {

    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}