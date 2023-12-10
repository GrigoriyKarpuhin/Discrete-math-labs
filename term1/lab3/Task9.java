import java.util.*;

public class Task9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder line0 = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                line0.append('(');
            } else {
                line0.append(')');
            }
        }
        StringBuilder example = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                example.append('(');
            } else {
                example.append(')');
            }
        }
        String line = line0.toString();
        System.out.println(line);
        while (!line.equals(String.valueOf(example))) {
            int counter_close = 0;
            int counter_open = 0;
            for (int i = line.length() - 1; i >= 0; i--) {
                if (line.charAt(i) == '(') {
                    counter_open++;
                    if (counter_close > counter_open) {
                        break;
                    }
                } else {
                    counter_close++;
                }
            }
            line = line.substring(0, line.length() - counter_open - counter_close);
            if (!line.equals("")) {
                line = line + ')';
                for (int i = 0; i < counter_open; i++) {
                    line = line + '(';
                }
                for (int i = 0; i < counter_close - 1; i++) {
                    line = line + ')';
                }
                System.out.println(line);
            }
        }
    }
}
