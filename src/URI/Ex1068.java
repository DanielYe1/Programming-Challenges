package URI;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Daniel on 03/05/2016.
 */
public class Ex1068 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Stack stack = new Stack();
            String polin = scanner.next();
            boolean correct = true;
            for (int i = 0; i < polin.length(); i++) {
                if (polin.charAt(i) == '(') {
                    stack.push('(');
                } else if (polin.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        correct = false;
                    } else {
                        stack.pop();
                    }

                }
            }

            if (stack.isEmpty() && correct) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }
}
