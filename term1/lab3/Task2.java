import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        StringBuilder[] array = new StringBuilder[(int) Math.pow(2, len)];
        array[0] = new StringBuilder("0");
        array[1] = new StringBuilder("1");
        for (int r = 2; r < array.length; r++) {
            array[r] = new StringBuilder();
        }
        int phantomLen = 2;
        for (int i = 1; i < len; i++) {
            phantomLen *= 2;
            for (int k = 0; k < phantomLen / 2; k++) {
                    array[phantomLen / 2 + k] = new StringBuilder(array[phantomLen / 2 - k - 1]);
                }
            for (int j = 0; j <= phantomLen / 2 - 1; j++){
                array[j].insert(0, 0);
            }
            for (int l = phantomLen / 2; l <= phantomLen - 1; l++){
                array[l].insert(0, 1);
            }
        }
        System.out.println();
        for (int k = 0; k <= array.length - 1; k++) {
            System.out.println(array[k]);
        }
    }
}

