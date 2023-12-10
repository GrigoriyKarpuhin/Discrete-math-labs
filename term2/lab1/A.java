import java.io.*;
import java.util.*;

public class A {
    private static class Pair {
        int first;
        String second;

        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("problem1.in")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("problem1.out")));
        String word = br.readLine();
        int n, m, k;
        String nmk = br.readLine();
        n = Integer.parseInt(nmk.split(" ")[0]);
        m = Integer.parseInt(nmk.split(" ")[1]);
        k = Integer.parseInt(nmk.split(" ")[2]);
        Set<Integer> term = new HashSet<>();
        String[] termStr = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            term.add(Integer.parseInt(termStr[i]) - 1);
        }
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]) - 1;
            int to = Integer.parseInt(s[1]) - 1;
            String c = s[2];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new Pair(to, c));
        }
        br.close();
        int state = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean flag = false;
            for (Pair p : map.getOrDefault(state, new ArrayList<>())) {
                if (p.second.charAt(0) == c) {
                    state = p.first;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                bw.write("Rejects");
                bw.close();
                return;
            }
        }
        if (term.contains(state)) {
            bw.write("Accepts");
        } else {
            bw.write("Rejects");
        }
        bw.close();
    }
}
