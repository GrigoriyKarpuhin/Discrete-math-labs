import java.util.Scanner;
public class Task27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder line = new StringBuilder(scan.next());
        scan.close();
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
        line.delete(line.length() - counter_open - counter_close, line.length());
        if (!line.toString().equals("")) {
            line.append(')');
            line.append("(".repeat(Math.max(0, counter_open)));
            line.append(")".repeat(Math.max(0, counter_close - 1)));
            System.out.println(line);
        } else {
            System.out.println("-");
        }
    }
}
