import java.util.*;

public class Task14 {
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
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = scan.nextInt();
        }
        scan.close();
        ArrayList<Integer> res = new ArrayList<>();
        long result = 0;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count = j;
                if (res.contains(count)) {
                    count++;
                } else {
                    break;
                }
            }
            res.add(count);
            while (res.get(i - 1) != perm[i - 1]) {
                result += factorial(n - i);
                res.remove(i - 1);
                count++;
                while (res.contains(count)) {
                    count++;
                }
                res.add(count);
            }
        }
        System.out.println(result);
    }
}
