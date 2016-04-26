package chapter1;

import java.util.Scanner;

/**
 * Created by Daniel on 24/04/2016.
 */
public class P23ChecktheCheck {
    public enum movements {
        NORTHEAST,
        NORTHWEST,
        SOUTHWEST,
        SOUTHEAST,
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[8]; // start putting in the matrix

        for (int i = 0; i < 8; i++) {
            input[i] = scanner.next();
        }

        char[][] matrix = new char[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matrix[i][j] = '1';
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i + 2][j + 2] = input[i].charAt(j);
            }
        }
        printMatrix(matrix, 8, 8); // debug matrix

        // for the part of cols and rows, can put enums, causa the queen will use the same object as
        // the rook and the bishop
        // bishop seems the most difficult
        // rook can use some cols and rows logic
        // pawn,king aren't hardly to do
        // no logic to do with knight

        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                switch (matrix[i][j]) {
                    case 'p':
                        if (matrix[i + 1][j - 1] == 'K' || matrix[i + 1][j + 1] == 'K') {
                            System.out.println("Pawn Check!");
                        }
                        break;
                    case 'P':
                        if (matrix[i - 1][j - 1] == 'k' || matrix[i - 1][j + 1] == 'k') {
                            System.out.println("Pawn Check!");
                        }
                        break;
                    case 'n':
                        if (matrix[i + 2][j + 1] == 'K' || matrix[i + 2][j - 1] == 'K' || matrix[i - 2][j - 1] == 'K' || matrix[i - 2][j + 1] == 'K' || matrix[i + 1][j + 2] == 'K' || matrix[i - 1][j + 2] == 'K' || matrix[i + 1][j - 2] == 'K' || matrix[i - 1][j - 2] == 'K') {
                            System.out.println("Knight Check!");
                        }
                        break;
                    case 'N':
                        if (matrix[i + 2][j + 1] == 'k' || matrix[i + 2][j - 1] == 'k' || matrix[i - 2][j - 1] == 'k' || matrix[i - 2][j + 1] == 'k' || matrix[i + 1][j + 2] == 'k' || matrix[i - 1][j + 2] == 'k' || matrix[i + 1][j - 2] == 'k' || matrix[i - 1][j - 2] == 'k') {
                            System.out.println("Knight Check!");
                        }
                        break;
                    case 'b':  // work with bugs, bug fix tomorrow;
                        setPart(matrix, movements.NORTHEAST,i,j);
                        setPart(matrix, movements.NORTHWEST,i,j);
                        setPart(matrix, movements.SOUTHEAST,i,j);
                        setPart(matrix, movements.SOUTHWEST,i,j);
                    case 'B':  // work with bugs, bug fix tomorrow;
                        setPart(matrix, movements.NORTHEAST,i,j);
                        setPart(matrix, movements.NORTHWEST,i,j);
                        setPart(matrix, movements.SOUTHEAST,i,j);
                        setPart(matrix, movements.SOUTHWEST,i,j);
                    case 'r':
                        setPart(matrix, movements.EAST,i,j);
                        setPart(matrix, movements.NORTH,i,j);
                        setPart(matrix, movements.SOUTH,i,j);
                        setPart(matrix, movements.WEST,i,j);
                        break;
                    case 'R':
                        setPart(matrix, movements.EAST,i,j);
                        setPart(matrix, movements.NORTH,i,j);
                        setPart(matrix, movements.SOUTH,i,j);
                        setPart(matrix, movements.WEST,i,j);
                        break;
                    case 'q':
                        setPart(matrix, movements.EAST,i,j);
                        setPart(matrix, movements.NORTH,i,j);
                        setPart(matrix, movements.SOUTH,i,j);
                        setPart(matrix, movements.WEST,i,j);
                        setPart(matrix, movements.NORTHEAST,i,j);
                        setPart(matrix, movements.NORTHWEST,i,j);
                        setPart(matrix, movements.SOUTHEAST,i,j);
                        setPart(matrix, movements.SOUTHWEST,i,j);
                    case 'Q':
                        setPart(matrix, movements.EAST,i,j);
                        setPart(matrix, movements.NORTH,i,j);
                        setPart(matrix, movements.SOUTH,i,j);
                        setPart(matrix, movements.WEST,i,j);
                        setPart(matrix, movements.NORTHEAST,i,j);
                        setPart(matrix, movements.NORTHWEST,i,j);
                        setPart(matrix, movements.SOUTHEAST,i,j);
                        setPart(matrix, movements.SOUTHWEST,i,j);
                }
            }
        }

    }

    private static void printMatrix(char[][] matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf(String.valueOf(matrix[i + 2][j + 2]));
            }
            System.out.println();
        }
    }

    private static void setPart(char[][] matrix, movements part,int i, int j) {
        switch (part) {
            case NORTHEAST:
                for (int k = 1; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if ((i - k) <= 2 || (j + k) >= 10) {
                            break;
                        }
                        if (matrix[i - k][j + k] != '.') {
                            if (matrix[i - k][j + k] == 'k'|| matrix[i - k][j + k] == 'K') {
                                System.out.println("bishop check");
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case NORTHWEST:
                for (int k = 1; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if ((i - k) < 2 || (j - k) < 2) { //index out
                            break;
                        }                                   // index out
                        if (matrix[i - k][j - k] != '.') {
                            if (matrix[i - k][j - k] == 'k'|| matrix[i - k][j - k] == 'K') {
                                System.out.println("bishop check");
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case SOUTHEAST:
                for (int k = 1; k < 8; k++) {  // southeast
                    for (int l = 1; l < 8; l++) {
                        if ((i + k) >= 10 || (j + k) >= 10) {
                            break;
                        }
                        if (matrix[i + k][j + k] != '.') {
                            if (matrix[i + k][j + k] == 'k'|| matrix[i + k][j + k] == 'K') {
                                System.out.println("bishop check");
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case SOUTHWEST:
                for (int k = 1; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if ((i + k) >= 10 || (j - k) <= 2) {
                            break;
                        }
                        if (matrix[i + k][j - k] != '.') {
                            if (matrix[i + k][j - k] == 'k'|| matrix[i + k][j - k] == 'K') {
                                System.out.println("bishop check");
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                }
                break;
            case NORTH:
                for (int k = 1; k < 8; k++) {
                    if ((i - k) <= 2) {
                        break;
                    }
                    if (matrix[i - k][j] != '.') {
                        if (matrix[i - k][j] == 'k'|| matrix[i - k][j] == 'K') {
                            System.out.println("rook check");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case SOUTH:
                for (int k = 1; k < 8; k++) {
                    if ((i - k) >= 10) {
                        break;
                    }
                    if (matrix[i + k][j] != '.') {
                        if (matrix[i + k][j] == 'k'|| matrix[i + k][j] == 'K') {
                            System.out.println("rook check");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case WEST:
                for (int k = 1; k < 8; k++) {
                    if ((j - k) <= 2) {
                        break;
                    }
                    if (matrix[i][j - k] != '.') {
                        if (matrix[i][j - k] == 'k'|| matrix[i][j - k] == 'K') {
                            System.out.println("rook check");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case EAST:
                for (int k = 1; k < 8; k++) {
                    if ((j + k) <= 10) {
                        break;
                    }
                    if (matrix[i][j + k] != '.') {
                        if (matrix[i][j + k] == 'k'|| matrix[i][j + k] == 'K') {
                            System.out.println("rook check");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
        }
    }

}



