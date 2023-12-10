import java.util.*;
 
public class C {
    static Scanner scan = new Scanner(System.in);
 
    public static void main(String[] args) {
        int n = scan.nextInt();
        List<Integer> lamps = new LinkedList<>();
 
        for (int i = 0; i < n; ++i) {
            lamps.add(i + 1);
        }
 
        lamps.sort(C.customComparator);
 
        System.out.print(0 + " ");
        for (Integer lamp : lamps) {
            System.out.print(lamp + " ");
        }
    }
 
    static boolean comparator(int i, int j) {
        System.out.println(1 + " " + i + " " + j);
        String answer = scan.next();
        return answer.charAt(0) == 'Y';
    }
 
    static Comparator<Integer> customComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer i, Integer j) {
            if (C.comparator(i, j)) {
                return -1;
            } else {
                return 1;
            }
        }
    };
}