import java.io.*;
import java.util.*;

class Task__01__DFS {
	int vertices;
    int time;
    LinkedList<Integer> adjacencyList[];
    int label[];
    int parent[];
    int discoveryTime[];
    int finishingTime[];
    boolean visited[];
    Stack<Integer> stack = new Stack<Integer>();
    int numberOfTrees;
    boolean isCyclic;
    boolean isBipartite;
    Color colors[];

    @SuppressWarnings("unchecked")
    Task__01__DFS(int vertices) {
		this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices+1];
        this.label = new int[vertices+1];
        this.parent = new int[vertices+1];
        this.discoveryTime = new int[vertices+1];
        this.finishingTime = new int[vertices+1];
        this.visited = new boolean[vertices+1];
        this.isCyclic = false;
        this.isBipartite = true;
        this.colors = new Color[vertices+1];
        for (int i=1; i<=vertices; i++) {
            this.adjacencyList[i] = new LinkedList<Integer>();
            colors[i] = Color.WHITE;
        }
    }
    
    enum Color{
        WHITE, RED, GREEN
    }

	void connectEdge(int u, int v) {
        this.adjacencyList[u].add(v);
    }

	void dfsTraversal(int source) {
        visited[source] = true;
        colors[source] = Color.RED;
        discoveryTime[source] = ++time;
        Iterator<Integer> list = adjacencyList[source].listIterator();
        while (list.hasNext()) {
            int peek = list.next();
            if (!visited[peek]) {
                label[peek] = label[source]+1;
                parent[peek] = source;
                dfsTraversal(peek);
                if (colors[source] == Color.RED) colors[peek] = Color.GREEN;
                else if (colors[source] == Color.GREEN) colors[peek] = Color.RED;
            }
            else if (visited[peek] && peek!=parent[source] && !isCyclic){
                isCyclic = true;
            }
            if (colors[source] == colors[peek]) isBipartite = false;
        }
        finishingTime[source] = ++time;
        stack.push(source);
        System.out.println("  " + source + "  --->   " + label[source] + "\t---\t" + parent[source] +
        "\t---\t"+discoveryTime[source]  + "\t---\t" + finishingTime[source]);

        //System.out.printf("  %c  --->   %d\t---\t%d\t---\t%d\t---\t%d\n", source+96, label[source], parent[source], discoveryTime[source], finishingTime[source]);
	}

	void DFS(int source) {
        time = 0;
        label[source] = 0;
        parent[source] = -1;
        dfsTraversal(source);
        numberOfTrees = 1;
        for (int i=1; i<=vertices; i++) {
            if (!visited[i]) {
                label[i] = 0;
                parent[i] = -1;
                dfsTraversal(i);
                numberOfTrees++;
            }
        }
        System.out.println("Trees: " + numberOfTrees);
        System.out.println("Cyclic: " + isCyclic);
        System.out.println("Bipartite: " + isBipartite);
        System.out.print("Topological Sort: ");
        for (int i=0; i<vertices; i++) {
            System.out.print(stack.pop());
            if (i+1 == vertices) System.out.println();
            else System.out.print(" ");
        }
    }
    
	public static void main(String args[]){
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__DFS graph = new Task__01__DFS(vertices);
            for (int i=0; i<edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                graph.connectEdge(source, destination);
                //graph.connectEdge(destination, source);
            }
            int source = input.nextInt();
            input.close();
            System.out.println("DFS Traversal: ");
            System.out.println("Node ---> Label ---  Parent     ---  D__Time    ---  F__Time");
            graph.DFS(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
	}
}