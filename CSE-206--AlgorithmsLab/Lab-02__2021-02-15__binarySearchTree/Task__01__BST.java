import java.util.Scanner;

public class Task__01__BST {
    class Node {
        int data;
        Node leftLink, rightLink;

        Node(int temp) {
            data = temp;
            leftLink = rightLink = null;
        }
    }

    static Node vertex;
    int vertices;
    int tempVertices;

    Task__01__BST() {
        vertex = null;
    }

    void insertData(int data) {
        Node node = new Node(data);
        if (vertex == null) vertex = node;
        else insertData(vertex, node);
    }

    void insertData(Node vertex, Node node) {
        if (node.data <= vertex.data) {
            if (vertex.leftLink == null) vertex.leftLink = node;
            else insertData(vertex.leftLink, node);
        }
        else if (node.data > vertex.data) {
            if (vertex.rightLink == null) vertex.rightLink = node;
            else insertData(vertex.rightLink, node);
        }
    }

    void preOrder(Node vertex) {
        if (vertex != null) {
            System.out.print(vertex.data);
            tempVertices++;
            if (tempVertices == vertices) System.out.println();
            else System.out.print(" ");
            preOrder(vertex.leftLink);
            preOrder(vertex.rightLink);
        }
    }

    void inOrder(Node vertex) {
        if (vertex != null) {
            inOrder(vertex.leftLink);
            System.out.print(vertex.data);
            tempVertices++;
            if (tempVertices == vertices) System.out.println();
            else System.out.print(" ");
            inOrder(vertex.rightLink);
        }
    }

    void postOrder(Node vertex) {
        if (vertex != null) {
            postOrder(vertex.leftLink);
            postOrder(vertex.rightLink);
            System.out.print(vertex.data);
            tempVertices++;
            if (tempVertices == vertices) System.out.println();
            else System.out.print(" ");
        }
    }

    void printTree() {
        if (vertices != 0) {
            tempVertices = 0;
            System.out.print("Pre-Order Traversal: ");
            preOrder(vertex);
            tempVertices = 0;
            System.out.print("In-Order Traversal: ");
            inOrder(vertex);
            tempVertices = 0;
            System.out.print("Post-Order Traversal: ");
            postOrder(vertex);
        }
        else System.out.println("The Tree didn't Grow.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Task__01__BST tree = new Task__01__BST();
        System.out.print("Vertices: ");
        tree.vertices = input.nextInt();
        for (int i = 0; i < tree.vertices; i++) {
            int data = input.nextInt();
            tree.insertData(data);
        }
        input.close();
        
        tree.printTree();
    }
}