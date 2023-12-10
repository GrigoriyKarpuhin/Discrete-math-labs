import java.io.*;
import java.util.*;

public class B {
    private static class Pair {
        int state;
        String symbol;
        Pair(int state, String symbol) {
            this.state = state;
            this.symbol = symbol;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("problem2.in")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("problem2.out")));
        String word = br.readLine();
        int n, m, k;
        String nmk = br.readLine();
        n = Integer.parseInt(nmk.split(" ")[0]);
        m = Integer.parseInt(nmk.split(" ")[1]);
        k = Integer.parseInt(nmk.split(" ")[2]);
        Set<Integer> terminalStates = new HashSet<>();
        String[] terminalStateStr = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            terminalStates.add(Integer.parseInt(terminalStateStr[i]) - 1);
        }
        Map<Integer, ArrayList<Pair>> transitions = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]) - 1;
            int to = Integer.parseInt(s[1]) - 1;
            String symbol = s[2];
            if (!transitions.containsKey(from)) {
                transitions.put(from, new ArrayList<>());
            }
            transitions.get(from).add(new Pair(to, symbol));
        }
        br.close();

        Set<Integer> currentStates = new HashSet<>();
        Set<Integer> nextStates = new HashSet<>();
        currentStates.add(0);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int state : currentStates) {
                for (Pair transition : transitions.getOrDefault(state, new ArrayList<>())) {
                    if (transition.symbol.charAt(0) == c) {
                        nextStates.add(transition.state);
                    }
                }
            }
            currentStates = nextStates;
            nextStates = new HashSet<>();
        }

        boolean accepted = false;
        for (int state : currentStates) {
            if (terminalStates.contains(state)) {
                accepted = true;
                break;
            }
        }

        if (accepted) {
            bw.write("Accepts");
        } else {
            bw.write("Rejects");
        }
        bw.close();
    }
}
