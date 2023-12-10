import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Set<String> list = new HashSet<>();
        StringBuilder line = new StringBuilder((String.format("%" + n + "s", Integer.toBinaryString(0)).replace(' ', '0')));
        list.add(line.toString());
        System.out.println(line);
        for (int i = 0; i < Math.pow(2, n) - 1; i++) {
            line.delete(0, 1);
            line.append(1);
            if (list.contains(line.toString())) {
                line.delete(n - 1, n);
                line.append(0);
            }
            list.add(line.toString());
            System.out.println(line);
        }
    }
}