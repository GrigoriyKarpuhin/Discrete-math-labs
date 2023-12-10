import java.util.Scanner;
import java.util.TreeSet;
 
public class H {
 
    public static class Pair implements Comparable<Pair> {
        private final int first;
        private final int second;
 
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
 
        @Override
        public int compareTo(Pair o) {
            if (this.first != o.first) {
                return Integer.compare(this.first, o.first);
            }
            return Integer.compare(this.second, o.second);
        }
    }
 
    public static int[] chromPolynomial(int n, TreeSet<Pair> edges, int rm) {
        int[] result = new int[rm];
        if (edges.isEmpty()) {
            result[n - 1] = 1;
            return result;
        }
        Pair rem = new Pair(edges.first().first, edges.first().second);
        edges.pollFirst();
        TreeSet<Pair> newEdges = new TreeSet<>();
        for (Pair i : edges) {
            if (i.first == rem.second) {
                if (rem.first < i.second) {
                    newEdges.add(new Pair(rem.first, i.second));
                } else {
                    newEdges.add(new Pair(i.second, rem.first));
                }
            } else if (i.second == rem.second) {
                if (rem.first < i.first) {
                    newEdges.add(new Pair(rem.first, i.first));
                } else {
                    newEdges.add(new Pair(i.first, rem.first));
                }
            } else {
                newEdges.add(i);
            }
        }
        int[] first = chromPolynomial(n, edges, rm);
        int[] second = chromPolynomial(n - 1, newEdges, rm);
        for (int i = 0; i < n; i++) {
            result[i] = first[i] -= second[i];
        }
        return result;
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        TreeSet<Pair> graph = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int u_i = scan.nextInt() - 1;
            int v_i = scan.nextInt() - 1;
            if (u_i < v_i) {
                graph.add(new Pair(u_i, v_i));
            } else {
                graph.add(new Pair(v_i, u_i));
            }
        }
        scan.close();
        int[] ans = chromPolynomial(n, graph, n);
        System.out.println(n);
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(0);
    }
}