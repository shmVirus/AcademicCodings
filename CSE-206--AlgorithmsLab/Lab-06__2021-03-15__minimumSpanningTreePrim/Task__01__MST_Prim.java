import java.io.*;
import java.util.*;
public class Task__01__MST_Prim {

    int vertices;
    LinkedList<Edge> adjacencyList[];
    int parent[];
    int weight[];
    boolean visited[];
    Node[] nodeList;
    @SuppressWarnings("unchecked")
    Task__01__MST_Prim(int vertices, int edges) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        this.parent = new int[vertices];
        this.weight = new int[edges];
        this.visited = new boolean[vertices];
        this.nodeList = new Node[vertices];
        for (int i=0; i<vertices; i++) {
            adjacencyList[i] = new LinkedList<Edge>();
            nodeList[i] = new Node();
        }
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
    
    class Node {
        int vertex;
        int weight;
    }

    class comparator implements Comparator<Node> {
        @Override
        public int compare(Node node, Node node1) {
            return node.weight-node1.weight;
        }
    }
    
    void connectEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].add(edge);
    }
    
    void mstPrim(int source) {
        for (int i=0; i<vertices; i++) {
            visited[i] = false;
            nodeList[i].weight = Integer.MAX_VALUE;
            nodeList[i].vertex = i;
            parent[i] = -1;
        }
        
        visited[source] = true;
        nodeList[source].weight = 0;
        
        TreeSet<Node> queue = new TreeSet<Node>(new comparator());
        
        for (int i=0; i<vertices; i++) {
            queue.add(nodeList[i]);
        }
        
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            visited[node.vertex] = true;
            for (Edge iterator : adjacencyList[node.vertex]) {
                if (!visited[iterator.destination] && nodeList[iterator.destination].weight > iterator.weight) {
                    queue.remove(nodeList[iterator.destination]);
                    nodeList[iterator.destination].weight = iterator.weight;
                    queue.add(nodeList[iterator.destination]);
                    parent[iterator.destination] = node.vertex;
                    weight[iterator.destination] = nodeList[iterator.destination].weight;
                }
            }
        }

        int totalMinWeight = 0;
        System.out.println("Minimum Spanning Tree:");
        for (int i=1; i<vertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " ---> Weight: " + weight[i]);
            totalMinWeight += weight[i];
        }
        System.out.println("Total Minimum Wight: " + totalMinWeight);
    }
    
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__MST_Prim graph = new Task__01__MST_Prim(vertices, edges);
            for (int i=0; i<edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                int weight = input.nextInt();
                graph.connectEdge(source, destination, weight);
                graph.connectEdge(destination, source, weight);
            }
            int source = input.nextInt();
            input.close();
            graph.mstPrim(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}