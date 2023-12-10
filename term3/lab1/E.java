import java.util.*;
 
public class E {
 
    public static class Graph {
        private final int V;
        private final List<Integer>[] adjacencyList;
 
        private final PriorityQueue<Integer> leaves;
 
        public Graph(int V) {
            this.V = V;
            adjacencyList = new List[V];
            for (int i = 0; i < V; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            leaves = new PriorityQueue<>();
        }
 
        public void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source);
        }
 
        public List<Integer> getNeighbors(int vertex) {
            return adjacencyList[vertex];
        }
 
        public int getMinVertexWithOneNeighbor() {
            if (leaves.isEmpty()) {
                for (int i = 0; i < V; i++) {
                    if (adjacencyList[i].size() == 1) {
                        leaves.offer(i);
                    }
                }
            }
            return leaves.remove();
        }
 
        public void removeVertex(int vertex) {
            for (int neighbor : adjacencyList[vertex]) {
                adjacencyList[neighbor].remove(Integer.valueOf(vertex));
                if (adjacencyList[neighbor].size() == 1) {
                    leaves.offer(neighbor);
                }
            }
            adjacencyList[vertex].clear();
        }
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < n - 1; i++) {
            int u_i = scan.nextInt() - 1;
            int v_i = scan.nextInt() - 1;
            graph.addEdge(u_i, v_i);
        }
        scan.close();
 
        while (n > 2) {
            int min = graph.getMinVertexWithOneNeighbor();
            System.out.print((graph.getNeighbors(min).get(0) + 1) + " ");
            graph.removeVertex(min);
            n--;
        }
    }
}