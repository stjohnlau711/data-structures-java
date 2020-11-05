public class Stack { //Stack implementation as a linked list 

    private class Node {
        int data;
        Node next;
    }

    Node top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int x){
        Node temp = new Node();

        if(temp == null){
            System.out.println("Heap Overflow");
            return;
        }

        temp.data = x;
        temp.next = top;
        top = temp;
        size ++;
    }

    public void pop(){
        if(top == null){
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = top;
        top = temp.next;
        size --;
    }

    public void peek(){
        System.out.println(top.data);
    }

    public void display(){
        if(top == null ){
            System.out.print("Stack underflow");
        } else {
            Node current = top;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }

    }

    public boolean isEmpty(){

        return size == 0;
    }

    public static void main(String[] args){

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        stack.display();
        stack.pop();
        System.out.println();
        stack.display();

    }
}
