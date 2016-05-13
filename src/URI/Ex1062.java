package URI;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Daniel on 13/05/2016.
 */
public class Ex1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack inStation = new Stack();
        int qtVag = scanner.nextInt();
        int[] saida = new int[qtVag];
        int[] entrada = new int[qtVag];
        int indEnter = 0;

        while (qtVag != 0) {
            for (int i = 0; i < qtVag; i++) {
                saida[i] = scanner.nextInt();
                if (saida[0] == 0) {
                    break;
                }
                entrada[i] = i + 1;
            }
            while (saida[0] != 0) {
                for (int i = 0; i < qtVag; i++) {
                    inStation.push(entrada[i]);
                    while (!inStation.isEmpty() && (Integer) inStation.peek() == saida[indEnter]) {
                        inStation.pop();
                        indEnter += 1;
                    }
                }
                if (inStation.isEmpty()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }


                for (int i = 0; i < qtVag; i++) {
                    saida[i] = scanner.nextInt();
                    if (saida[0] == 0) {
                        break;
                    }
                    entrada[i] = i + 1;
                }
                indEnter = 0;
                inStation.clear();
            }
            System.out.println();
            inStation.clear();
            qtVag = scanner.nextInt();
            saida = new int[qtVag];
            entrada = new int[qtVag];
            indEnter = 0;
        }
    }
}
