import java.util.*;
import java.io.*;

class Task__01__BFS__matrix {
	int vertices;
	int adjacencyMatrix[][];
    int label[];
	int parent[];
	boolean visited[];
	
	Task__01__BFS__matrix(int vertices) {
		this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices+1][vertices+1];
        this.label = new int[vertices+1];
        this.parent = new int[vertices+1];
        this.visited = new boolean[vertices+1];
	}

	void connectEdge(int start, int destination) {
		adjacencyMatrix[destination][start] = 1;
	}

	void bfsTraversal(int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while (!queue.isEmpty()) {
			source = queue.poll();
			System.out.println("  " + source + "  --->   " + label[source] +"\t---\t" + parent[source]);
			for (int row=1; row<=vertices; row++) {
				if (adjacencyMatrix[source][row] == 1 && !visited[row]) {
					queue.add(row);
                    visited[row] = true;
                    label[row] = label[source] + 1;
                    parent[row] = source;
				}
			}
		}
	}

	void BFS(int source) {
        label[source] = 0;
        parent[source] = -1;
        bfsTraversal(source);
        
        for (int i=1; i<=vertices; i++) {
            if (!visited[i]) {
                label[i] = 0;
                parent[i] = -1;
                bfsTraversal(i);
            }
        }
    }

	public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("inputGraph.txt"));
            int vertices = input.nextInt();
            int edges = input.nextInt();
            Task__01__BFS__matrix graph = new Task__01__BFS__matrix(vertices);
            for (int i=0; i<edges; i++) {
                int start = input.nextInt();
                int destination = input.nextInt();
                graph.connectEdge(start, destination);
                //graph.connectEdge(destination, start);
            }
            int source = input.nextInt();
            input.close();
            System.out.println("BFS Traversal: ");
            System.out.println("Node ---> Label ---  Parent");
            graph.BFS(source);
        } catch (IOException inputException) {
        } finally {
            System.out.println("File ReadWrite done Successfully!");
        }
    }
}