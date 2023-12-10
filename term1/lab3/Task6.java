import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        boolean two = false;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            list.add(String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0'));
        }
        for (int i = 0; i < list.size(); i++) {
            two = false;
            String line = list.get(i);
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '1') {
                    if (two) {
                        list.remove(i);
                        i--;
                        break;
                    } else {
                        two = true;
                    }
                } else {
                    two = false;
                }
            }
        }
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
