package chapter1;

import java.util.Scanner;

/**
 * Created by Daniel on 23/04/2016.
 */
public class P18LCDdisplay {
    public enum NumberPart {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        CENTER;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String number = scanner.next();

        while (n != 0 && number.charAt(0) != '0') {
            int size = number.length();
            int line = 2 * n + 3;
            int column = (n + 2) * size;
            char[][] matrix = new char[line][column];

            for (int i = 0; i < line; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = ' ';
                }
            }

            for (int i = 0; i < size; i++) {
                switch (number.charAt(i)) {
                    case '0':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_LEFT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '1':
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        break;
                    case '2':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_LEFT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '3':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '4':
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        break;
                    case '5':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '6':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_LEFT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '7':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        break;
                    case '8':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_LEFT, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    case '9':
                        setPart(matrix, NumberPart.TOP, n, i);
                        setPart(matrix, NumberPart.TOP_RIGHT, n, i);
                        setPart(matrix, NumberPart.TOP_LEFT, n, i);
                        setPart(matrix, NumberPart.CENTER, n, i);
                        setPart(matrix, NumberPart.BOTTOM_RIGHT, n, i);
                        setPart(matrix, NumberPart.BOTTOM, n, i);
                        break;
                    default:
                        System.out.println("Not number");
                }
            }
            printNumber(matrix);
            n = scanner.nextInt();
            number = scanner.next();
        }
    }

    private static void printNumber(char[][] matrix) {
        for (char[] rows : matrix) {
            for (char element : rows) {
                System.out.printf(String.valueOf(element));
            }
            System.out.println();
        }
    }

    private static void setPart(char[][] matrix, NumberPart part, int n, int i) {
        int offset = i * (n + 2);
        int column;
        int line;

        switch (part) {
            case BOTTOM:
                line = 2 * n + 2;
                for (int j = 1; j <= n; j++) {
                    matrix[line][offset + j] = '-';
                }
                break;
            case BOTTOM_LEFT:
                for (int j = n + 2; j < 2 * n + 2; j++) {
                    matrix[j][offset] = '|';
                }
                break;
            case CENTER:
                line = n + 1;
                for (int j = 1; j <= n; j++) {
                    matrix[line][offset + j] = '-';
                }
                break;
            case TOP:
                for (int j = 1; j <= n; j++) {
                    matrix[0][offset + j] = '-';
                }
                break;
            case TOP_LEFT:
                for (int j = 1; j <= n; j++) {
                    matrix[j][offset] = '|';
                }
                break;
            case BOTTOM_RIGHT:
                column = offset + n + 1;
                for (int j = n + 2; j < 2 * n + 2; j++) {
                    matrix[j][column] = '|';
                }
                break;
            case TOP_RIGHT:
                column = offset + n + 1;
                for (int j = 1; j <= n; j++) {
                    matrix[j][column] = '|';
                }
                break;
            default:
        }
    }
}