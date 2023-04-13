import java.io.*;
import java.util.*;

public class Task__01__Dijkstra {
    int vertices;
    int edges;
    LinkedList<Edge> adjacencyList[];
    boolean visited[];
    int distance[];

    @SuppressWarnings("unchecked")
    Task__01__Dijkstra(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.adjacencyList = new LinkedList[vertices];
        this.visited = new boolean[vertices];
        this.distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Edge>();
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

    void connectEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList[source].add(edge);
    }

    void dijkstraShortestPath(int source) {
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>(vertices, Comparator.comparingInt(o -> o.weight));
        distance[source] = 0;
        queue.add(adjacencyList[source].get(0));
        while (queue.size() != 0) {
            Edge extractEdge = queue.poll();
            visited[extractEdge.source] = true;
            LinkedList<Edge> list = adjacencyList[extractEdge.source];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.destination]) {
                    if (distance[edge.destination] > distance[extractEdge.source] + edge.weight) {
                        distance[edge.destination] = distance[extractEdge.source] + edge.weight;
                        queue.add(adjacencyList[edge.destination].get(0));
                    }
                }
            }
        }
        System.out.println("Dijkstra's ShortestPath:");
        for (int i = 0; i < vertices; i++) {
            if (i != source) {
                System.out.println("Minimum distance between \"" + source + "-" + i + "\": " + distance[i]);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__Dijkstra graph = new Task__01__Dijkstra(vertices, edges);
            for (int i = 0; i < edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                int weight = input.nextInt();
                graph.connectEdge(source, destination, weight);
                graph.connectEdge(destination, source, weight);
            }
            int source = input.nextInt();
            input.close();
            graph.dijkstraShortestPath(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}