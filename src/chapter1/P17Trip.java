package chapter1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Daniel on 23/04/2016.
 */
public class P17Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0) {
            LinkedList<Float> money = new LinkedList();
            float sum = 0;

            for (int i = 0; i < n; i++) {
                money.add(scanner.nextFloat());
                sum += money.getLast();
            }

            float media = sum / money.size() + .005f;
            float result = 0;

            for (int j = 0; j < n; j++) {
                if (money.get(j) > media) {
                    result += money.get(j) - media;
                }
            }

            System.out.println(String.format("$%.2f", result));
            n = scanner.nextInt();
        }
    }
}
