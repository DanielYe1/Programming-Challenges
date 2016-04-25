package chapter1;

import java.util.Scanner;

/**
 * Created by Daniel on 23/04/2016.
 */
public class P19GraphicalEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char code = scanner.next().charAt(0);

        if (code == 'I') {
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            char[][] matrix = new char[linha][coluna];
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    matrix[i][j] = '0';
                }
            }

            while (code != 'X') {
                if (code == 'C') {
                    for (int i = 0; i < linha; i++) {
                        for (int j = 0; j < coluna; j++) {
                            matrix[i][j] = '0';
                        }
                    }
                } else if (code == 'L') {
                    int px = scanner.nextInt();
                    int py = scanner.nextInt();
                    char color = scanner.next().charAt(0);
                    matrix[px - 1][py - 1] = color;

                } else if (code == 'V') {
                    int py = scanner.nextInt();
                    int px1 = scanner.nextInt();
                    int px2 = scanner.nextInt();
                    char color = scanner.next().charAt(0);
                    for (int i = px1; i <= px2; i++) {
                        matrix[i - 1][py - 1] = color;
                    }
                } else if (code == 'H') {
                    int px = scanner.nextInt();
                    int py1 = scanner.nextInt();
                    int py2 = scanner.nextInt();
                    char color = scanner.next().charAt(0);
                    for (int i = py1; i <= py2; i++) {
                        matrix[px - 1][i - 1] = color;
                    }
                } else if (code == 'K') {
                    int px1 = scanner.nextInt();
                    int py1 = scanner.nextInt();
                    int px2 = scanner.nextInt();
                    int py2 = scanner.nextInt();
                    char color = scanner.next().charAt(0);
                    for (int i = px1; i <= px2; i++) {
                        for (int j = py1; j <= py2; j++) {
                            matrix[i-1][j-1] = color;
                        }
                    }
                } else if (code == 'F') {
                    int px = scanner.nextInt();
                    int py = scanner.nextInt();
                    char color = scanner.next().charAt(0);
                    char pixel = matrix[px-1][py-1];
                    for (int i = 0; i < linha; i++) {
                        for (int j = 0; j < coluna; j++) {
                            if (matrix[i][j] == pixel){
                                matrix[i][j] = color;
                            }
                        }
                    }
                } else if (code == 'S') {
                    String name = scanner.next();
                    System.out.println(name);
                    for (int i = 0; i < linha; i++) {
                        for (int j = 0; j < coluna; j++) {
                            System.out.printf(String.valueOf(matrix[i][j]));
                        }
                        System.out.println();
                    }
                }
                code = scanner.next().charAt(0);
            }
        }
    }
}