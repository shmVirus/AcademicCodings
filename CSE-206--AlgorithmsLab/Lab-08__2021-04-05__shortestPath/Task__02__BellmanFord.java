import java.io.*;
import java.util.*;

public class Task__02__BellmanFord {
    int vertices;
    int edges;
    LinkedList<Edge> allEdges;
    int distance[];
    boolean hasNegativeCycle = false;

    Task__02__BellmanFord(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.allEdges = new LinkedList<Edge>();
        this.distance = new int[vertices];
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

    void bellmanFordShortestPath(int source) {
        for (int i=0; i<vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i=0; i<vertices; i++) {
            for (int j=0; j<allEdges.size(); j++) {
                Edge extractEdge = allEdges.get(j);
                if (distance[extractEdge.source] != Integer.MAX_VALUE && distance[extractEdge.source] + extractEdge.weight < distance[extractEdge.destination] ) {
                    distance[extractEdge.destination] = distance[extractEdge.source] + extractEdge.weight;
                    if (i+1 == vertices) hasNegativeCycle = true;
                }
            }
        }
        
        if (!hasNegativeCycle) {
            System.out.println("BellmanFord's ShortestPath:");
            for (int i=0; i<vertices; i++) {
                if (i != source) {
                    System.out.println("Minimum distance between \"" + source + "-" + i + "\": " + distance[i]);
                }
            }
        }
        else {
            System.out.println("Solution doesn't Exists!");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__02__BellmanFord graph = new Task__02__BellmanFord(vertices, edges);
            for (int i=0; i<edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                int weight = input.nextInt();
                graph.connectEdge(source, destination, weight);
                //graph.connectEdge(destination, source, weight);
            }
            int source = input.nextInt();
            input.close();
            graph.bellmanFordShortestPath(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}