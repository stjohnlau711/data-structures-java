public class MaxPathSum { 
    //inefficient because of two recursive functions 
    //but helpful for recursion practice

    static class Node {
        Node left;
        Node right;
        Node parent;
        int element;

        public Node(int element){
            this.element = element;
        }
    }

    public static int maxHalfPath(Node v){
        if(v == null){ //base case
            return 0;
        }

        int l = Math.max(maxHalfPath(v.left), 0); //recursive case
        int r = Math.max(maxHalfPath(v.right), 0); //check for negatives

        return v.element + Math.max(l, r);
    }

    public static int maxPathSum(Node v){
        if(v == null){
            return Integer.MIN_VALUE;
        } else {
            int max = v.element + maxHalfPath(v.left) + maxHalfPath(v.right);
            int l = maxPathSum(v.left);
            int r = maxPathSum(v.right);
            return Math.max(max, Math.max(l, r));

        }
    }



    public static void main(String[] args){ //driver method

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        node1.left = node2; node1.right = node3;
        node2.parent = node1; node2.left = node4; node2.right = node5;
        node3.parent = node1; node3.left = node6; node3.right = node7;
        node4.parent = node2; node4.left = node8; node4.right = node9;
        node5.parent = node2; node5.left = node10; node5.right = node11;
        node6.parent = node3; node6.left = node12; node6.right = node13;
        node7.parent = node3; node7.left = node14; node7.right = node15;

        System.out.println(maxPathSum(node1)); //should return 44


    }
}
