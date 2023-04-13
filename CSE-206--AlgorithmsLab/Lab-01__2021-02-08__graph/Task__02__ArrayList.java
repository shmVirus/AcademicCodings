import java.util.Scanner;
import java.util.ArrayList;
public class Task__02__ArrayList {
	public static void main(String[] args) {
		new Graph();
	}
}
class Graph {
	Scanner input = new Scanner(System.in);
	ArrayList<ArrayList<Integer>> graphList = new ArrayList<ArrayList<Integer>>();
	int vertices;
	Graph() {
		System.out.printf("Vertices: ");
        this.vertices = input.nextInt();
		graphInput();
		graphPrint();
	}
	void graphInput() {
		int temp;
		for (int i=0; i<vertices; i++) {
			ArrayList<Integer> tempGraph = new ArrayList<Integer>();
			boolean isDone=false;
			while (!isDone) {
				temp = input.nextInt();
				if (temp == -1) isDone=true;
				else tempGraph.add(temp);
			}
			graphList.add(tempGraph);
		}
	}
	void graphPrint() {
		System.out.println("AdjacencyList: ");
		for (int i=0; i<vertices; i++) {
			int listSize = graphList.get(i).size();
			for (int j=0; j<listSize; j++) {
				System.out.print(graphList.get(i).get(j));
				if (j+1 == listSize) System.out.println();
                else System.out.printf(" ");
			}
		}
	}
}
