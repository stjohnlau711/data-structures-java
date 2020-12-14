public class AVLTree {

    static class Node {
        Node left;
        Node right;
        int value;
        int height;
        int bf; // > 1 is left heavy, < - 1 is right heavy
        //calculate balance factor (bf) by doing node.left.height - node.right.height

        public Node(int v){
            this.value = v;
        }

    }

    Node root;
    public AVLTree(){
        root = null;
    }

    public Node insert(Node node, int value){ //insert method
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        //update method
        update(node);

        //Restructure or balance the tree now and return
        return balance(node);
    }

    private void update(Node node){
        int leftNodeHeight = (node.left == null)? - 1 : node.left.height;
        int rightNodeHeight = (node.right == null)? - 1: node.right.height;

        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        node.bf = leftNodeHeight - rightNodeHeight;
    }

    private Node balance(Node node){ //balance method is otherwise known as restructure method
        if(node.bf == 2){

            //left-left case
            if(node.left.bf >= 0){ //This means left node is either perfectly balanced
                // or slightly left heavy
                return leftLeftCase(node); //perform right rotation on node

            //left-right case
            } else { //this means left node is slightly right heavy
                return leftRightCase(node); //performs left rotation on node.left
                //then performs right rotation on node
            }
        } else if(node.bf == - 2){

            //right-right case
            if(node.right.bf <= 0){ //this means right node is either perfectly balanced
                // or slightly right heavy
                return rightRightCase(node); //performs left rotation on node

            //right-left case
            } else { //this means right node is slightly left heavy
                return rightLeftCase(node); //performs right rotation on node.right
                //then performs left rotation on node
            }
        }
    }

    private Node leftLeftCase(Node node){
        return rightRotation(node); //right rotation on node

    }
    private Node leftRightCase(Node node){
        node.left = leftRotation(node.left); //left rotation on node.left
        return rightRotation(node); //right rotation on node

    }
    private Node rightRightCase(Node node){
        return leftRotation(node); //left rotation on node
    }
    private Node rightLeftCase(Node node){
        node.right = rightRotation(node); //right rotation on node.right
        return leftRotation(node); //left rotation on node

    }

    private Node rightRotation(Node node){
        Node newParent = node.left; //swapping Node's left child with itself
        node.left = newParent.right; //right child of newParent < node,
        //So it will become node (old root)'s new left child
        newParent.right = node;

        update(node);
        update(newParent);
        return newParent;
    }

    private Node leftRotation(Node node){
        Node newParent = node.right; //swapping Node's right child with itself
        node.right = newParent.left; //left child of newParent > node,
        //So it will become node (old root)'s new right child
        newParent.left = node; //newParent's left has to be the node itself (b/c smaller)
        update(node);
        update(newParent);
        return newParent;

    }

    public Node remove(Node node, int value){
        if(node == null){
            return null;
        }
        if(value < node.value){ //less than current node, so traverse left
            node.left = remove(node.left, value);
        } else if(value > node.value){ //greater than current node, so traverse right
            node.right = remove(node.right, value);

        } else {
           //here, we've found the node we want to remove
            if(node.left == null){ //case w/ no subtree or only right subtree
                //swap node with right child
                return node.right;
            } else if(node.right == null){ //case w/ no subtree or only left subtree
                //swap node with left child
                return node.left;
            } else { //case w/ both subtrees

                if(node.left.height > node.right.height){ //left subtree greater height

                    int successorValue = findMax(node.left); //digs right to find max

                    //swap value off successor into node
                    node.value = successorValue;

                    //find largest node in left subtree and remove (so no dup values)
                    node.left = remove(node.left, successorValue);
                    
                } else { //subtrees equal height, or right subtree greater height
                    int successorValue = findMin(node.right); //digs left to find min

                    //swap value of successor into node
                    node.value = successorValue;

                    //find smallest node in right subtree and remove (so no dup values)
                    node.right = remove(node.right, successorValue);
                }
            }
        }
        update(node);

        return balance(node);
    }

    private int findMax(Node node){ //dig right helper method
        if(node.right == null){
            return node.value;
        }
        return findMax(node.right);

    }

    private int findMin(Node node){ //dig left helper method
        if(node.left == null){
            return node.value;
        }
        return findMin(node.left);
    }

    
}
