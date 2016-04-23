package chapter1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Daniel on 22/04/2016.
 */
public class Minesweeper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 1;

        while (m != 0 && n != 0) {
            String[] input = new String[n];

            for (int i = 0; i < n; i++) {
                input[i] = scanner.next();
            }

            char[][] matrix = new char[n + 2][m + 2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i + 1][j + 1] = input[i].charAt(j); // change (+1)
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i + 1][j + 1] != '*') {
                        int p = 0; // p = 0 to loop correctly
                        matrix[i + 1][j + 1] = 0;
                        for (int line = -1; line < 2; line++) {
                            for (int column = -1; column < 2; column++) {
                                if (matrix[i + 1 + line][j + 1 + column] == '*') {
                                    p = p + 1;
                                    matrix[i + 1][j + 1] = String.valueOf(p).charAt(0);
                                }
                            }
                        }
                    }
                }
            }
            System.out.print(String.format("Field #%d:", count++));
            printMatrix(matrix);

            n = scanner.nextInt();
            m = scanner.nextInt();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] line : matrix) {
            for (char c : line) {
                System.out.printf(String.valueOf(c));
            }
            System.out.println();
        }
    }
}
