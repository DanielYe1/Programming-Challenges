package chapter1;

import java.util.Scanner;

/**
 * Created by Daniel on 23/04/2016.
 */
public class P15ThreeNplusOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int max = 0;

        for (int i = x; i <= y; i++) {
            max = Math.max(max, cycleLength(i));
        }

        System.out.println(String.format("%d %d %d", x, y, max));
    }

    private static int cycleLength(int n) {
        int count = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count++;
            } else {
                n = n * 3 + 1;
                count++;
            }
        }
        return count;
    }
}
