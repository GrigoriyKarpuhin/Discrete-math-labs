import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] code = new int[n];
        for (int i = 0; i < Math.pow(3, n - 1); i++) {
            int v = i;
            for (int j = n - 1; j >= 0; j--) {
                code[j] = v % 3;
                v /= 3;
            }
            System.out.print(Arrays.toString(code).replaceAll("]", "").replaceAll(",", "").replaceAll("\\[", "").replaceAll(" ", ""));
            System.out.println();
            for (int k = 0; k <= 1; k++) {
                for (int j = 0; j < n; j++) {
                    code[j] += 1;
                    if (code[j] == 3) {
                        code[j] = 0;
                    }
                }
                System.out.print(Arrays.toString(code).replaceAll("]", "").replaceAll(",", "").replaceAll("\\[", "").replaceAll(" ", ""));
                System.out.println();
            }
        }
    }
}