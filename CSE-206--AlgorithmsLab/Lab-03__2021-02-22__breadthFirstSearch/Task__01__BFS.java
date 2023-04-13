import java.util.*;
import java.io.*;

public class Task__01__BFS {

    int vertices;
    LinkedList<Integer> adjacencyList[];
    int label[];
    int parent[];
    boolean visited[];
    int numberOfTrees;
    boolean isBipartite;
    Color colors[];

    @SuppressWarnings("unchecked")
    Task__01__BFS(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices+1];
        this.label = new int[vertices+1];
        this.parent = new int[vertices+1];
        this.visited = new boolean[vertices+1];
        this.isBipartite = true;
        this.colors = new Color[vertices+1];
        for (int i=1; i<=vertices; i++) {
            this.adjacencyList[i] = new LinkedList<Integer>();
            //this.label[i] = -1;
            //this.parent[i] = -1;
            colors[i] = Color.WHITE;
        }
    }

    enum Color{
        WHITE, RED, GREEN
    }

    void connectEdge(int start, int destination) {
        this.adjacencyList[start].add(destination);
    }

    void bfsTraversal(int source) {
        try {
            FileWriter output = new FileWriter("outputGraph.txt");
            //output.write("BFS Traversal: \nNode ---> Label ---  Parent\n");
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(source);
            visited[source] = true;
            colors[source] = Color.RED;
            while (queue.size() != 0) {
                source = queue.poll();
                //output.write("  " + Integer.toString(source) + "  --->   " + Integer.toString(label[source]) + "\t---\t" + Integer.toString(parent[source]) + "\n");
                System.out.println("  " + source + "  --->   " + label[source] +"\t---\t" + parent[source]);
                for (int i=0; i<adjacencyList[source].size(); i++) {
                    int peek = this.adjacencyList[source].get(i);
                    if (!visited[peek]) {
                        queue.add(peek);
                        visited[peek] = true;
                        label[peek] = label[source] + 1;
                        parent[peek] = source;
                        if (colors[source] == Color.RED) colors[peek] = Color.GREEN;
                        else if (colors[source] == Color.GREEN) colors[peek] = Color.RED;
                    }
                    else if (colors[source] == colors[peek]) isBipartite = false;
                }
            }
            output.close();
        } catch (IOException outputException) {
        }
    }

    void BFS(int source) {
        System.out.println("BFS Traversal: ");
        System.out.println("Node ---> Label ---  Parent");
        label[source] = 0;
        parent[source] = -1;
        bfsTraversal(source);
        numberOfTrees = 1;
        
        for (int i=1; i<=vertices; i++) {
            if (!visited[i]) {
                label[i] = 0;
                parent[i] = -1;
                bfsTraversal(i);
                numberOfTrees++;
            }
        }
        System.out.println("Trees: " + numberOfTrees);
        System.out.println("Bipartite: " + isBipartite);
    }

    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__BFS graph = new Task__01__BFS(vertices);
            for (int i=0; i<edges; i++) {
                int start = input.nextInt();
                int destination = input.nextInt();
                graph.connectEdge(start, destination);
                //graph.connectEdge(destination, start);
            }
            int source = input.nextInt();
            input.close();
            graph.BFS(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}