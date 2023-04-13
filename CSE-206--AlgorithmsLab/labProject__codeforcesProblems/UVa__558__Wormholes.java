import java.io.*;
import java.util.*;

public class UVa__558__Wormholes {
    int vertices;
    int edges;
    LinkedList<Edge> allEdges;
    int distance[];
    boolean traveledBack = false;
    UVa__558__Wormholes(int vertices, int edges) {
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

    void bellmanFordShortestPath() {
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        for (int i=0; i<vertices; i++) {
            for (int j=0; j<allEdges.size(); j++) {
                Edge extractEdge = allEdges.get(j);
                if (distance[extractEdge.source] != Integer.MAX_VALUE && distance[extractEdge.destination] > distance[extractEdge.source] + extractEdge.weight) {
                    distance[extractEdge.destination] = distance[extractEdge.source] + extractEdge.weight;
                    if (i+1 == vertices) traveledBack = true;
                }
            }
        }
        if (traveledBack) System.out.println("possible");
        else System.out.println("not possible");
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("wormHoles.txt"));
            int testCases = input.nextInt();
            while (testCases-- > 0) {
                int vertices = input.nextInt();
                int edges = input.nextInt();
                UVa__558__Wormholes graph = new UVa__558__Wormholes(vertices, edges);
                for (int i=0; i<edges; i++) {
                    int source = input.nextInt();
                    int destination = input.nextInt();
                    int weight = input.nextInt();
                    graph.connectEdge(source, destination, weight);
                }
                graph.bellmanFordShortestPath();
            }
        } catch (IOException inputException) {
        }
    }
}