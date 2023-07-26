import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class treeInversion {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        //Swap the left and right subtrees using a temp variable
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode createTree(Scanner sc) {
        System.out.println("Enter node value (or -1 to stop)");
        int value = sc.nextInt();
        if(value == -1) return null;

        TreeNode newNode = new TreeNode(value);

        System.out.println("Enter the left child of " + value);
        newNode.left = createTree(sc);
        
        System.out.println("Enter the right child of " + value);
        newNode.right = createTree(sc);

        return newNode;
    }

    public void printTree(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        treeInversion inverter = new treeInversion();
        Scanner sc = new Scanner(System.in);

        System.out.println("Input the values of the Binary tree nodes: ");
        TreeNode root = inverter.createTree(sc);

        System.out.println("\nOriginal Tree (Pre-order traversal)");
        inverter.printTree(root);

        TreeNode invertedRoot = inverter.invertTree(root);

        System.out.println("\nInverted Tree (Pre-order traversal)");
        inverter.printTree(invertedRoot);
    }
}