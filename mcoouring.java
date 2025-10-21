import java.util.*;

public class mcoouring {

    // Function to check if a node can be safely colored
    private static boolean isSafe(int node, int col, int[] color, List<Integer>[] graph) {
        for (int neighbor : graph[node]) {
            if (color[neighbor] == col) return false;
        }
        return true;
    }

    // Recursive function to color the graph
    private static boolean solve(int node, int[] color, int n, int m, List<Integer>[] graph) {
        if (node == n) return true; // all nodes colored successfully

        for (int c = 1; c <= m; c++) { // try each color
            if (isSafe(node, c, color, graph)) {
                color[node] = c;
                if (solve(node + 1, color, n, m, graph))
                    return true; // successful coloring
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    // Main function to check if M-coloring is possible
    public static boolean graphColoring(List<Integer>[] graph, int m) {
        int n = graph.length;
        int[] color = new int[n];
        return solve(0, color, n, m, graph);
    }

    public static void main(String[] args) {
        int N = 4, M = 3;
       @SuppressWarnings("unchecked")
        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        // Example graph edges (undirected)
        graph[0].addAll(Arrays.asList(1, 2, 3));
        graph[1].addAll(Arrays.asList(0, 2));
        graph[2].addAll(Arrays.asList(0, 1, 3));
        graph[3].addAll(Arrays.asList(0, 2));

        boolean canColor = graphColoring(graph, M);
        System.out.println(canColor ? "1" : "0");
    }
}
