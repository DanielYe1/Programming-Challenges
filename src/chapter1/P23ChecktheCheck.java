package chapter1;

import java.util.Scanner;

import static java.awt.Color.white;

/**
 * Created by Daniel on 24/04/2016.
 */
public class P23ChecktheCheck {

    public static class bool {
        public static boolean white = false;
        public static boolean black = false;
        public static boolean none = false;
    }

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


        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                switch (matrix[i][j]) {
                    case 'p':
                        if (matrix[i + 1][j - 1] == 'K' || matrix[i + 1][j + 1] == 'K') {
                            bool.white = true;
                        }
                        break;
                    case 'P':
                        if (matrix[i - 1][j - 1] == 'k' || matrix[i - 1][j + 1] == 'k') {
                            bool.black = true;
                        }
                        break;
                    case 'n':
                        if (matrix[i + 2][j + 1] == 'K' || matrix[i + 2][j - 1] == 'K' || matrix[i - 2][j - 1] == 'K' || matrix[i - 2][j + 1] == 'K' || matrix[i + 1][j + 2] == 'K' || matrix[i - 1][j + 2] == 'K' || matrix[i + 1][j - 2] == 'K' || matrix[i - 1][j - 2] == 'K') {
                            bool.white = true;
                        }
                        break;
                    case 'N':
                        if (matrix[i + 2][j + 1] == 'k' || matrix[i + 2][j - 1] == 'k' || matrix[i - 2][j - 1] == 'k' || matrix[i - 2][j + 1] == 'k' || matrix[i + 1][j + 2] == 'k' || matrix[i - 1][j + 2] == 'k' || matrix[i + 1][j - 2] == 'k' || matrix[i - 1][j - 2] == 'k') {
                            bool.black = true;
                        }
                        break;
                    case 'b':  // work with bugs, bug fix tomorrow;
                        setPart(matrix, movements.NORTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHWEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHWEST, i, j, matrix[i][j]);
                    case 'B':  // work with bugs, bug fix tomorrow;
                        setPart(matrix, movements.NORTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHWEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHWEST, i, j, matrix[i][j]);
                    case 'r':
                        setPart(matrix, movements.EAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.WEST, i, j, matrix[i][j]);
                        break;
                    case 'R':
                        setPart(matrix, movements.EAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.WEST, i, j, matrix[i][j]);
                        break;
                    case 'q':
                        setPart(matrix, movements.EAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.WEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHWEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHWEST, i, j, matrix[i][j]);
                    case 'Q':
                        setPart(matrix, movements.EAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTH, i, j, matrix[i][j]);
                        setPart(matrix, movements.WEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.NORTHWEST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHEAST, i, j, matrix[i][j]);
                        setPart(matrix, movements.SOUTHWEST, i, j, matrix[i][j]);
                }
            }
        }

        if (bool.white) {
            System.out.println("white king is in check.");
        } else if (bool.black) {
            System.out.println("black king is in check.");
        } else {
            System.out.println("no king is in check.");
        }
    }


    public static void setPart(char[][] matrix, movements part, int i, int j, char piece) {
        switch (part) {
            case NORTHEAST:
                for (int k = 1; k < 8; k++) {
                    for (int l = 1; l < 8; l++) {
                        if ((i - k) < 2 || (j + k) >= 10) {
                            break;
                        }
                        if (matrix[i - k][j + k] != '.') {
                            if (matrix[i - k][j + k] == 'k' || matrix[i - k][j + k] == 'K') {
                                if (piece == 'b' || piece == 'q' || piece == 'r') {
                                    bool.white = true;

                                } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                    bool.black = true;

                                }
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
                            if (matrix[i - k][j - k] == 'k' || matrix[i - k][j - k] == 'K') {
                                if (piece == 'b' || piece == 'q' || piece == 'r') {
                                    bool.white = true;

                                } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                    bool.black = true;

                                }
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
                            if (matrix[i + k][j + k] == 'k' || matrix[i + k][j + k] == 'K') {
                                if (piece == 'b' || piece == 'q' || piece == 'r') {
                                    bool.white = true;

                                } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                    bool.black = true;

                                }
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
                        if ((i + k) >= 10 || (j - k) < 2) {
                            break;
                        }
                        if (matrix[i + k][j - k] != '.') {
                            if (matrix[i + k][j - k] == 'k' || matrix[i + k][j - k] == 'K') {
                                if (piece == 'b' || piece == 'q' || piece == 'r') {
                                    bool.white = true;

                                } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                    bool.black = true;

                                }
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
                    if ((i - k) < 2) {
                        break;
                    }
                    if (matrix[i - k][j] != '.') {
                        if (matrix[i - k][j] == 'k' || matrix[i - k][j] == 'K') {
                            if (piece == 'b' || piece == 'q' || piece == 'r') {
                                bool.white = true;
                            } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                bool.black = true;

                            }
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
                        if (matrix[i + k][j] == 'k' || matrix[i + k][j] == 'K') {
                            if (piece == 'b' || piece == 'q' || piece == 'r') {
                                bool.white = true;
                            } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                bool.black = true;

                            }
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case WEST:
                for (int k = 1; k < 8; k++) {
                    if ((j - k) < 2) {
                        break;
                    }
                    if (matrix[i][j - k] != '.') {
                        if (matrix[i][j - k] == 'k' || matrix[i][j - k] == 'K') {
                            if (piece == 'b' || piece == 'q' || piece == 'r') {
                                bool.white = true;
                            } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                bool.black = true;

                            }
                            break;
                        } else {
                            break;
                        }
                    }
                }
                break;
            case EAST:
                for (int k = 1; k < 8; k++) {
                    if ((j + k) >= 11) {
                        break;
                    }
                    if (matrix[i][j + k] != '.') {
                        if (matrix[i][j + k] == 'k' || matrix[i][j + k] == 'K') {
                            if (piece == 'b' || piece == 'q' || piece == 'r') {
                                bool.white = true;
                            } else if (piece == 'B' || piece == 'Q' || piece == 'R') {
                                bool.black = true;

                            }
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



