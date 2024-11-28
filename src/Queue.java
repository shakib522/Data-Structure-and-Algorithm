import java.util.NoSuchElementException;

class Node<T>{
    T val;
    Node<T> next;
    public Node(T val){
        this.val=val;
    }
}
class Stack<T>{
    private Node<T> head;
    void push(T val){
        if (head==null){
            head=new Node<>(val);
            return;
        }
        Node<T> node=new Node<>(val);
        node.next=head;
        head=node;
    }
    T pop(){
        if (head==null){
            throw new NoSuchElementException("Stack is Empty");
        }
        T val=head.val;
        head=head.next;
        return val;
    }
    void printStack(){
        if (head==null){
            System.out.println("Empty Stack");
            return;
        }
        Node<T> cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
public class Queue<T> {
    Node<T> head;
    Node<T> tail;
    void enqueue(T val){
        Node<T> node=new Node<>(val);
        if (head==null){
            head=node;
            tail=node;
            return;
        }
        tail.next=new Node<>(val);
        tail=tail.next;
    }
    T dequeue(){
        if (head==null){
            System.out.println("Queue is empty");
            throw new NoSuchElementException();
        }
       T val=head.val;
       head=head.next;
       return val;
    }
    void printQueue(){
        if (head==null){
            System.out.println("Empty queue");
            return;
        }
        Node<T> cur=head;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
class Main{
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.enqueue("8.9");
        queue.enqueue("7.2");
        queue.enqueue("18.5");
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();

        Stack<String> st=new Stack<>();
        st.push("shakib");
        st.push("rakib");
        st.push("sayham");
        st.printStack();
        st.pop();
        st.pop();
        st.printStack();
    }
}