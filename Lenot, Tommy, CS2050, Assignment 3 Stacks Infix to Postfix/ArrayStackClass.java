// Lenot,Tommy CS2050, Assignment: Program #3 - Stacks: Infix to Postfix
// Please note that when I did this, I had the Program3.txt in the same file directory inside the Project's name, not inside the src folder so it should be in the same area as in the same with Projecjname.iml and that I had to close and reopened IntelliJ to see that Program3.txt was in it as well.
//Please note that in Program3.txt as you said to put our name, assignment, etc. on each file i did so, but in Program3.txt it will  - Stacks: Infix to Postfix   ->   invalid character. This is beacuse of having my name and assignment will produce that so erasing my name will remove that, and again you did say you wanted our names, assignment of file, etc. on each one we created and sent.
class ArrayStackClass<T> {
    private Object[] array;
    private int top;

    public ArrayStackClass(int N) {
        array = new Object[N];
        top = -1;
    }

    public void push(T element) {
        if(top == array.length - 1) throw new IllegalStateException("Stack is full!");
        array[++top] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if(empty()) throw new java.util.EmptyStackException();
        return (T) array[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if(empty()) throw new java.util.EmptyStackException();
        return (T) array[top];
    }

    public boolean empty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}