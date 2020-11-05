public class Queue {

    private class Node {
        int data;
        Node next;
    }

    Node front;
    Node rear;
    int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int x){
        Node temp = new Node();
        temp.data = x;

        if(this.rear == null){
            this.front = this.rear = temp;
        } else {
            this.rear.next = temp;
            this.rear = temp;
            size++;
        }
    }

    public void dequeue(){
        if(this.front == null){
            return;
        } else {
            this.front = this.front.next;
            size --;
            if(this.front == null){
                this.rear = null;
            }
        }
    }

    public void display(){
        Node current = this.front;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.display();
        System.out.println();
        queue.dequeue();
        queue.display();
    }
}
