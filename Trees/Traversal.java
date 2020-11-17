class Tree<E> { //We are not using Queues to implement this, log tree data to console
    E data;
    Tree<E> left;
    Tree<E> right;
    public Tree(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class Traversal { //3 types: Post-order, Pre-order, In-order

    public static void preOrder(Tree t){
        if(t == null){
            return;
        }
        System.out.print(t.data + " ");
        preOrder(t.left);
        preOrder(t.right);
    }

    public static void postOrder(Tree t){
        if(t == null){
            return;
        }
        postOrder(t.left);
        postOrder(t.right);
        System.out.print(t.data + " ");
    }

    public static void inOrder(Tree t){
        if(t == null){
            return;
        }
        inOrder(t.left);
        System.out.print(t.data + " ");
        inOrder(t.right);
    }

    public static Tree invert(Tree t) {
        if(t == null){
            return null;
        }
        Tree newT = new Tree(t.data);
        newT.left = invert(t.right);
        newT.right = invert(t.left);
        return newT;

    }

    public static void inPlaceInvert(Tree t){
        if(t == null){
            return;
        }
        Tree temp = t.left;
        t.left = t.right;
        t.right = temp;
        invert(t.left);
        invert(t.right);
    }
    public static void main(String[] args){

        Tree<Integer> a = new Tree<Integer>(0);
        Tree<Integer> b = new Tree<Integer>(1);
        Tree<Integer> c = new Tree<Integer>(2);
        Tree<Integer> d = new Tree<Integer>(3);
        Tree<Integer> e = new Tree<Integer>(4);
        Tree<Integer> f = new Tree<Integer>(5);
        Tree<Integer> g = new Tree<Integer>(6);
        Tree<Integer> h = new Tree<Integer>(7);
        Tree<Integer> i = new Tree<Integer>(8);

        a.left = b;
        a.right = f;
        b.left = c;
        b.right = d;
        f.right = g;
        d.left = e;
        g.left = h;
        g.right = i;

        preOrder(a);
        System.out.println();
        postOrder(a);
        System.out.println();
        inOrder(a);
        System.out.println();
        System.out.println("=======================");

        Tree<Integer> newA = invert(a);
        preOrder(newA);
        System.out.println();
        postOrder(newA);
        System.out.println();
        inOrder(newA);





    }
}
