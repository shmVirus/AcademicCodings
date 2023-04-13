import java.io.*;
import java.util.*;
public class Task__01__MST_Kruskal {

    int vertices;
    int edges;
    LinkedList<Edge> allEdges;
    int parent[];
    int label[];
    LinkedList<Edge> minimumSpanningTree = new LinkedList<Edge>();

    Task__01__MST_Kruskal(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.allEdges = new LinkedList<Edge>();
        this.parent = new int[vertices];
        this.label = new int[vertices];
    }

    class Edge {
        int source;
        int destination;
        int weight;
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    void connectEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge);
    }

    void makeSet() {
        for (int i=0; i<vertices; i++) {
            parent[i] = i;
            label[i] = 0;
        }
    }

    int findSet(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findSet(parent[vertex]);
        }
        return parent[vertex];
    }

    void setUnion(int u, int v) {
        int uRoot = findSet(u);
        int vRoot = findSet(v);

        if (label[uRoot] < label[vRoot]) {
            parent[uRoot] = uRoot;
        } else if (label[uRoot] > label[vRoot]) {
            parent[vRoot] = vRoot;
        } else {
            parent[vRoot] = uRoot;
        }
    }

    void mstKruskal() {
        
        makeSet();

        PriorityQueue<Edge> queue = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
        for (int i=0; i<allEdges.size(); i++) {
            queue.add(allEdges.get(i));
        }

        int index=0;
        while (index<vertices-1) {
            Edge edge = queue.remove();
            int u = findSet(edge.source);
            int v = findSet(edge.destination);
            if (u != v) {
                minimumSpanningTree.add(edge);
                setUnion(u, v);
                index++;
            }
        }

        System.out.println("Minimum Spanning Tree: ");
        int minimumCost = 0;
        for (int i=0; i<minimumSpanningTree.size(); i++) {
            Edge edge = minimumSpanningTree.get(i);
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " ---> Cost: " + edge.weight);
            minimumCost += edge.weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }
    
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__MST_Kruskal graph = new Task__01__MST_Kruskal(vertices, edges);
            for (int i=0; i<edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                int weight = input.nextInt();
                graph.connectEdge(source, destination, weight);
                graph.connectEdge(destination, source, weight);
            }
            input.close();
            graph.mstKruskal();
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}