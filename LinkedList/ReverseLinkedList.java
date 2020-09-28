class Node{
    public Node next;
    public int x;
    Node (int x){
        next = null;
        this.x = x;
    }
    public boolean hasnext(){
        return next != null;
    }
    public void putnext(Node node){
        next = node;
    }
}

public class ReverseLinkedList {
    static Node reverse(Node node){
        if(node.hasnext()){
            Node nextreverse = reverse(node.next); //recursively makes the next node point to current node
            node.putnext(null); //which will reverse the linked list
            nextreverse.putnext(node);
        }
        return node;
    }



    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.putnext(node2);
        node2.putnext(node3);
        node3.putnext(node4);
        node4.putnext(node5);
        node5.putnext(node6);

        reverse(node1);
        System.out.println(node1.hasnext()); //should be false
        System.out.println(node6.hasnext()); //should be true
    }
}
