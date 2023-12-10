import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        for (int i = 0; i < Math.pow(2, len); i++) {
            String result = String.format("%" + len + "s", Integer.toBinaryString(i)).replace(' ', '0');
            System.out.println(result);
        }
    }
}
