public class SortedArrayToBST{

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int value;

        public TreeNode(int v) {
            this.value = v;
        }
    }

    static TreeNode root;

    static TreeNode sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = sortedArrayToBST(arr, start, mid - 1);

        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int n = arr.length;
        root = sortedArrayToBST(arr, 0, n - 1);

        inOrder(root);
    }
}
