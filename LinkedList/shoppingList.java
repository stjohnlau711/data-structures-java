public class shoppingList { //Doubly Linked List implementation, using a shopping list as a frame of reference

    public static class Node<E> {
        public E element;
        public Node prev;
        public Node next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public void print() {
            System.out.println("Element stored is " + element );
        }
    }

    public Node header;
    public Node tail;
    public int size;

    // constructors follow per JAVA convention

    public shoppingList() {
        header = null;
        tail = null;
        size = 0;
    }

    public void add(String newItem) {

        Node newNode = new Node(newItem, null, null);

        if(header == null){
            header = newNode; //the new node is the header and the tail
            tail = newNode;
            header.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode; //current tail's next node has to be the new node
            newNode.prev = tail; //new nodes previous node will be the current tail
            tail = newNode; //the new node is now the new tail
            tail.next = null; //the new node's next node is null
        }

        size ++;

    }

    public void remove(String oldItem) {

        if(size > 0){
            Node current = header;
            while(current != null){

                if(current.element == oldItem){
                    Node previous = current.prev; //not necessary but provides clarity on logic
                    Node next = current.next;
                    previous.next = current.next;
                    next.prev = current.prev;
                    current.element = null; //garbage collection
                    current.prev = null;
                    current.next = null;
                }
                current = current.next; //keeps going to next node until the end
            }
            size --;
        }
    }

    public void print() {
        Node current = header;
        while(current != null){
            current.print();
            current = current.next;
        }
    }

    public int numItem() {
        return this.size;
    }

    public static void main(String[] args){

        shoppingList sL = new shoppingList();
        sL.add("Patty");
        sL.add("Ham");
        sL.add("Sauce");
        sL.add("Cheese");
        sL.add("Bun");
        sL.add("Lettuce");
        sL.print();
        System.out.println(sL.numItem());
        System.out.println();

        sL.remove("Sauce");
        sL.remove("Cheese");
        sL.remove("Ham");
        sL.print();
        System.out.println(sL.numItem());

    }
}
