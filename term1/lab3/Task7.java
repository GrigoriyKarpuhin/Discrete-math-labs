import java.util.Scanner;

public class Task7 {
    public static long factorial(int f) {
        long result = 1;
        for (int i = 2; i <= f; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int[] perm = new int[n];
        for (int i = 1; i <= n; i++) {
            perm[i - 1] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(perm[i] + " ");
        }
        System.out.println();
        for (int k = 0; k < factorial(n) - 1; k++) {
            int mark1 = 0;
            int mark2 = 0;
            for (int i = n - 1; i >= 1; i--) {
                if (perm[i] > perm[i - 1]) {
                    mark1 = i - 1;
                    break;
                }
            }
            for (int i = n - 1; i >= 1; i--) {
                if (perm[i] > perm[mark1]) {
                    mark2 = i;
                    break;
                }
            }
            int buffer = perm[mark1];
            perm[mark1] = perm[mark2];
            perm[mark2] = buffer;
            for (int i = mark1 + 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (perm[i] > perm[j]) {
                        buffer = perm[i];
                        perm[i] = perm[j];
                        perm[j] = buffer;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(perm[i] + " ");
            }
            System.out.println();
        }
    }
}
