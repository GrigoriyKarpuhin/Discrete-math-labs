import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.next();
        scan.close();
        boolean one = false;
        char[] letters1 = n.toCharArray();
        for (int i = n.length() - 1; i >= 0; i--) {
            if (letters1[i] == '1') {
                letters1[i] = '0';
                one = true;
                break;
            } else {
                letters1[i] = '1';
            }
        }
        if (one) {
            System.out.println(letters1);
        } else {
            System.out.println('-');
        }
        one = false;
        char[] letters = n.toCharArray();
        for (int i = n.length() - 1; i >= 0; i--) {
            if (letters[i] == '0') {
                letters[i] = '1';
                one = true;
                break;
            } else {
                letters[i] = '0';
            }
        }
        if (one) {
            System.out.println(letters);
        } else {
            System.out.println('-');
        }
    }
}
