import java.util.*;

public class DFS {
    private Map<String, List<String>> adjVertices;

    public DFS() {
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

    public void dfsIterative(String start) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");

                for (String v : adjVertices.get(vertex)) {
                    if (!visited.contains(v)) {
                        stack.push(v);
                    }
                }
            }
        }
    }

    public void dfsRecursive(String start) {
        Set<String> visited = new HashSet<>();
        dfsRecursiveHelper(start, visited);
    }

    private void dfsRecursiveHelper(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.print(vertex + " ");
            for (String v : adjVertices.get(vertex)) {
                dfsRecursiveHelper(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");

        System.out.println("DFS traversal (iterative) starting from vertex A:");
        graph.dfsIterative("A");

        System.out.println("\nDFS traversal (recursive) starting from vertex A:");
        graph.dfsRecursive("A");
    }
}

