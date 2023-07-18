import java.util.TreeSet;

public class TreeTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = createTree();
        System.out.println("Pre order traversal");
        preOrder(root);
        System.out.println();
        System.out.println("post order traversal");
        postOrder(root);
        System.out.println();
        System.out.println("in order traversal");
        inOrder(root);

    }

    static void addLeftChild(Node node, Node child) {
        node.left = child;
    }

    static void addRightChild(Node node, Node child) {
        node.right = child;
    }

    public static Node createTree() {
        Node two = new Node(2);
        Node seven = new Node(7);
        Node nine = new Node(9);
        addLeftChild(two, seven);
        addRightChild(two, nine);
        Node one = new Node(1);
        Node six = new Node(6);
        addLeftChild(seven, one);
        addRightChild(seven, six);
        Node five = new Node(5);
        Node ten = new Node(10);
        addLeftChild(six, five);
        addRightChild(six, ten);
        Node eight = new Node(8);
        addRightChild(nine, eight);
        Node three = new Node(3);
        Node four = new Node(4);
        addLeftChild(eight, three);
        addRightChild(eight, four);
        return two;
    }

    static void preOrder(Node node) {
        System.out.print(node.data + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    static void postOrder(Node node) {
        if(node.left!=null){
            postOrder(node.left);
        }
        if(node.right!=null){
            postOrder(node.right);
        }
        System.out.print(node.data+" ");
    }
    static void inOrder(Node node){
        if(node.left!=null){
            inOrder(node.left);
        }
        System.out.print(node.data+" ");
        if(node.right!=null){
            inOrder(node.right);
        }
    }
}
