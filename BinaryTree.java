public class BinaryTree {
    private TreeNode root;

    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);

        root = first;
        first.left = second;
        first.right = third;
    }

    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }
    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
    public int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int maxValue = node.data;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        if (leftMax > maxValue) {
            maxValue = leftMax;
        }
        if (rightMax > maxValue) {
            maxValue = rightMax;
        }
        return maxValue;
    }

    public void printTree() {
        postorderTraversal(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.printTree();
        System.out.println("Maximum value in the tree: " + bt.findMax(bt.root));
    }
}
