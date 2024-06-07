// Node class to represent each node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {
    // Root node of the BST
    Node root;

    // Constructor for BST
    BinarySearchTree() {
        root = null;
    }

    // Method to insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in the BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the unchanged node pointer
        return root;
    }

    // Method to search a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search a key in the BST
    boolean searchRec(Node root, int key) {
        // Base cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null;

        // Key is greater than root's key
        if (root.key < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Method for in-order traversal
    void inorder() {
        inorderRec(root);
    }

    // A recursive function for in-order traversal of the BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting keys into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print in-order traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        // Searching keys in the BST
        int keyToSearch = 40;
        System.out.println("\nSearch " + keyToSearch + ": " + (bst.search(keyToSearch) ? "Found" : "Not Found"));

        keyToSearch = 90;
        System.out.println("Search " + keyToSearch + ": " + (bst.search(keyToSearch) ? "Found" : "Not Found"));
    }
}
