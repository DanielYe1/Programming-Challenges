package URI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class Ex1110 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        while (times != 0) {
            ArrayList list = new ArrayList();
            for (int i = 1; i <= times; i++) {
                list.add(i);
            }
            if (times == 1) {
                System.out.println("Discarded cards:");
                System.out.println("Remaining card: 1");
            } else {
                System.out.printf("Discarded cards:");
                int size = list.size();
                while (size > 1) {
                    if (size == 2) {
                        System.out.println(String.format(" %d", list.remove(0)));
                    } else {
                        System.out.printf(String.format(" %d,", list.remove(0)));
                    }

                    list.add(list.remove(0));
                    size--;
                }
                System.out.println(String.format("Remaining card: %d", list.get(0)));
            }
            times = scanner.nextInt();
        }
    }
}