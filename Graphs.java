import java.util.Arrays;

class Graph {
    private int[][] adjMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1; // For undirected graph
        } else {
            System.out.println("Invalid vertices");
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0; // For undirected graph
        } else {
            System.out.println("Invalid vertices");
        }
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            return adjMatrix[i][j] == 1;
        }
        return false;
    }
}

public class Graphs {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("Adjacency Matrix:");
        graph.printGraph();

        System.out.println("Removing edge between 0 and 1");
        graph.removeEdge(0, 1);
        graph.printGraph();
        
        System.out.println("Checking if there is an edge between 0 and 1: " + graph.isEdge(0, 1));
        System.out.println("Checking if there is an edge between 1 and 3: " + graph.isEdge(1, 3));
    }
}
