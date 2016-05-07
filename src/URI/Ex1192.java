package URI;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Daniel on 03/05/2016.
 */
public class Ex1192 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();

        for (int k = 0; k < times; k++) {
            String test = scanner.next();
            boolean b1 = Character.isUpperCase(test.charAt(1));
            int i = 0;
            if (test.charAt(0) == test.charAt(2)) {
                i = (int) (test.charAt(2) - 48) * (test.charAt(0) - 48);
            } else if (b1) {
                i = (int) test.charAt(2) - test.charAt(0);
            } else {
                i = (int) test.charAt(0) + test.charAt(2) - 48 - 48;
            }
            System.out.println(i);
        }
    }
}
