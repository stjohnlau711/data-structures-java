import java.util.ArrayList;

public class BSTToSortedArray {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int value;

        public TreeNode(int v) {
            this.value = v;
        }
    }

    static void inOrder(TreeNode node, ArrayList list){ //in order traversal helper
        if(node == null){
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
    static ArrayList<TreeNode> BSTToSortedArray(TreeNode node){
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(node, list);
        return list;
    }

    public static void main(String[] args){

        TreeNode a = new TreeNode(25);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(36);
        TreeNode d = new TreeNode(10);
        TreeNode e = new TreeNode(22);
        TreeNode f = new TreeNode(30);
        TreeNode g = new TreeNode(40);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(12);
        TreeNode j = new TreeNode(28);
        TreeNode k = new TreeNode(38);
        TreeNode l = new TreeNode(48);

        a.left = b; a.right = c;
        b.parent = a; b.left = d; b.right = e;
        c.parent = a; c.left = f; c.right = g;
        d.parent = b; d.left = h; d.right = i;
        e.parent = b;
        f.parent = c; f.left = j;
        g.parent = c; g.left = k; g.right = l;


        ArrayList<TreeNode> list = BSTToSortedArray(a);

        for(int iterator = 0; iterator < list.size(); iterator++){
            System.out.println(list.get(iterator).value);
        }
    }
}
