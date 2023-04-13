import java.io.*;
import java.util.*;

class Task__01__SCC {
    int vertices;
    int time;
    LinkedList<Integer> adjacencyList[];
    int label[];
    int parent[];
    int discoveryTime[];
    int finishingTime[];
    boolean visited[];
    Stack<Integer> stack = new Stack<Integer>();

    int transposeTime;
    LinkedList<Integer> transposeAdjacencyList[];
    int transposeLabel[];
    int transposeParent[];
    int transposeDiscoveryTime[];
    int transposeFinishingTime[];
    boolean transposeVisited[];
    int sscCount=0;

    @SuppressWarnings("unchecked")
    Task__01__SCC(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices+1];
        this.label = new int[vertices+1];
        this.parent = new int[vertices+1];
        this.discoveryTime = new int[vertices+1];
        this.finishingTime = new int[vertices+1];
        this.visited = new boolean[vertices+1];

        this.transposeAdjacencyList = new LinkedList[vertices+1];
        this.transposeLabel = new int[vertices+1];
        this.transposeParent = new int[vertices+1];
        this.transposeDiscoveryTime = new int[vertices+1];
        this.transposeFinishingTime = new int[vertices+1];
        this.transposeVisited = new boolean[vertices+1];
        for (int i=1; i<=vertices; i++) {
            this.adjacencyList[i] = new LinkedList<Integer>();
            this.transposeAdjacencyList[i] = new LinkedList<Integer>();
        }
	}

	void connectEdge(int u, int v) {
        this.adjacencyList[u].add(v);
        this.transposeAdjacencyList[v].add(u);
    }

	void dfsTraversal(int source) {
        visited[source] = true;
        discoveryTime[source] = ++time;
        Iterator<Integer> list = adjacencyList[source].listIterator();
        while (list.hasNext()) {
            int peek = list.next();
            if (!visited[peek]) {
                label[peek] = label[source]+1;
                parent[peek] = source;
                dfsTraversal(peek);
            }
        }
        finishingTime[source] = ++time;
        stack.push(source);
    }
    
    void dfsTransposeTraversal(int source) {
        transposeVisited[source] = true;
        transposeDiscoveryTime[source] = ++time;
        Iterator<Integer> transposeList = transposeAdjacencyList[source].listIterator();
        while (transposeList.hasNext()) {
            int peek = transposeList.next();
            if (!transposeVisited[peek]) {
                transposeLabel[peek] = transposeLabel[source]+1;
                transposeParent[peek] = source;
                dfsTransposeTraversal(peek);
            }
        }
        transposeFinishingTime[source] = ++time;
        System.out.print(source);
        if (transposeParent[source] != -1) System.out.print(" ");
        else System.out.println();
	}

	void SCC(int source) {
        time = 0;
        label[source] = 0;
        parent[source] = -1;
        dfsTraversal(source);
        for (int i=1; i<=vertices; i++) {
            if (!visited[i]) {
                label[i] = 0;
                parent[i] = -1;
                dfsTraversal(i);
            }
        }
        time = 0;
        for (int i=1; i<vertices; i++) {
            source = stack.pop();
            if (!transposeVisited[source]) {
                transposeLabel[source] = 0;
                transposeParent[source] = -1;
                System.out.print("Component " + ++sscCount + ": ");
                dfsTransposeTraversal(source);
            }
        }
    }
    
	public static void main(String args[]){
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__SCC graph = new Task__01__SCC(vertices);
            for (int i=0; i<edges; i++) {
                int source = input.nextInt();
                int destination = input.nextInt();
                graph.connectEdge(source, destination);
                //graph.connectEdge(destination, source);
            }
            int source = input.nextInt();
            input.close();
            System.out.println("SCC Traversal: ");
            graph.SCC(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
	}
}