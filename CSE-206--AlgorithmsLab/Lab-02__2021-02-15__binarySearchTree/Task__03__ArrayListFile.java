import java.io.*;
import java.util.*;

public class Task__03__ArrayListFile {
	ArrayList<ArrayList<Integer>> graphList = new ArrayList<ArrayList<Integer>>();
	int vertices;
	Task__03__ArrayListFile() {
		listRead();
		listWrite();
	}

	void listRead() {
		try {
			Scanner input = new Scanner(new File("inputList.txt"));
			vertices = input.nextInt();
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
			input.close();
        } catch (IOException inputException) {
        } finally {
            System.out.println("File Read done Successfully!");
        }
	}

	void listWrite() {
		try {
			FileWriter output = new FileWriter("outputList.txt");
			for (int i=0; i<vertices; i++) {
				int listSize = graphList.get(i).size();
				for (int j=0; j<listSize; j++) {
					output.write(Integer.toString((graphList.get(i).get(j))));
					if (j+1 == listSize) output.write("\n");
					else output.write(" ");
				}
			}
			output.close();
        } catch (IOException outputException) {
        } finally {
            System.out.println("File Write done Successfully!");
        }
	}

	public static void main(String[] args) {
		new Task__03__ArrayListFile();
	}
}