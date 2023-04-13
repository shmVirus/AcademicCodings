import java.io.*;
import java.util.*;

class UVa__11631__DarkRoads {
    int junctions;
    int roads;
    LinkedList<Road> allRoads;
    int parent[];
    int label[];
    LinkedList<Road> minimumCostRoads = new LinkedList<Road>();

    UVa__11631__DarkRoads(int junctions, int roads) {
        this.junctions = junctions;
        this.roads = roads;
        this.allRoads = new LinkedList<Road>();
        this.parent = new int[junctions];
        this.label = new int[junctions];
    }

    class Road {
        int start;
        int destination;
        int cost;

        Road(int start, int destination, int cost) {
            this.start = start;
            this.destination = destination;
            this.cost = cost;
        }
    }

    void connectRoad(int start, int destination, int cost) {
        Road road = new Road(start, destination, cost);
        allRoads.add(road);
    }

    void makeSet() {
        for (int i=0; i<junctions; i++) {
            parent[i] = i;
            label[i] = 0;
        }
    }

    int findSet(int road) {
        if (parent[road] != road) {
            parent[road] = findSet(parent[road]);
        }
        return parent[road];
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

    int mstKruskal() {
        int minimumCost = 0;
        makeSet();
        PriorityQueue<Road> queue = new PriorityQueue<>(allRoads.size(), Comparator.comparingInt(o -> o.cost));
        for (int i=0; i<allRoads.size(); i++) {
            queue.add(allRoads.get(i));
        }
        int index = 0;
        while (index < junctions-1) {
            Road road = queue.remove();
            int u = findSet(road.start);
            int v = findSet(road.destination);
            if (u != v) {
                minimumCostRoads.add(road);
                minimumCost += road.cost;
                setUnion(u, v);
                index++;
            }
        }
        return minimumCost;
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("byteLand.txt"));
            while (input.hasNextLine()) {
                int junctions = input.nextInt();
                int roads = input.nextInt();
                if (junctions == 0) {
                    break;
                }
                int totalCost = 0;
                UVa__11631__DarkRoads byteLand = new UVa__11631__DarkRoads(junctions, roads);
                for (int i=0; i<roads; i++) {
                    int start = input.nextInt();
                    int destination = input.nextInt();
                    int cost = input.nextInt();
                    totalCost += cost;
                    byteLand.connectRoad(start, destination, cost);
                    byteLand.connectRoad(destination, start, cost);
                }
                System.out.println(totalCost - byteLand.mstKruskal());
            }
            System.out.println();
        } catch (IOException inputException) {
        }
    }
}