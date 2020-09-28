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

public class DetectCycle {

    static boolean detectLoop(Node node){ //tortoise and hare algorithm
        //after n steps in the loop, hare == tortoise, and n is the length of the cycle
        Node hare = node;
        Node tortoise = node;
        while(true) {
            tortoise = tortoise.next;
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                return false;
            }
            if (tortoise == null || hare == null) {
                return false;
            }
            if (tortoise == hare) {
                System.out.println(countNodes(tortoise));
                System.out.println(findStartLoop(node, hare));
                return true;
            }
        }
    }

    static int countNodes( Node node){ //helper method for detectLoop method
        int count = 1;
        Node temp = node;
        while (temp.next != node) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static int findStartLoop(Node head, Node hare){ //helper method for detectLoop method
        while(head != hare){ //start new node from node1, leave hare at meeting point
            head = head.next;  //increment each pointer by 1, at their next meeting point
            hare = hare.next;
        }
        return head.x; //they will intersect at the start of the loop
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
        node6.putnext(node3);

        boolean loop = detectLoop(node1);
        System.out.println(loop);
    }
}
