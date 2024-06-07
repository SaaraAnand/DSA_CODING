import java.util.*;

public class BFS {
    private Map<String, List<String>> adjVertices;

    public BFS() {
        adjVertices = new HashMap<>();
    }

    public void addVertex(String label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    public void addEdge(String label1, String label2) {
        adjVertices.get(label1).add(label2);
        adjVertices.get(label2).add(label1); // For undirected graph
    }

    public List<String> getAdjVertices(String label) {
        return adjVertices.get(label);
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            for (String v : adjVertices.get(vertex)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        System.out.println("BFS traversal starting from vertex A:");
        graph.bfs("A");
    }
}

