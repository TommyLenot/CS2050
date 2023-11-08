// Lenot,Tommy CS2050, Assignment: Program #4 Linked List
// Please note that when I did this, I had the Program4.txt in the same file directory inside the Project's name, not inside the src folder so it should be in the same area as in the same with Projecjname.iml and that I had to close and reopened IntelliJ to see that Program4.txt was in it as well.
//Please note that in Program4.txt as you said to put our name, assignment, etc. on each file i did so, but in Program3.txt it will  - Stacks: Infix to Postfix   ->   invalid character. This is beacuse of having my name and assignment will produce that so erasing my name will remove that, and again you did say you wanted our names, assignment of file, etc. on each one we created and sent.
import java.util.EmptyStackException;

public class MyLinkedStack<T> {

    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedStack() {
        this.top = null;
    }

    public boolean empty() {
        return top == null;
    }

    public T peek() {
        if (empty()) throw new EmptyStackException();
        return top.data;
    }

    public T pop() {
        if (empty()) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }
}
