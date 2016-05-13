package URI;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Daniel on 05/05/2016.
 */
public class Ex1527 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int qtplayers = scanner.nextInt();
        int qtmoves = scanner.nextInt();
        int[] points = new int[qtplayers];
        int[] moves = new int[3];
        for (int i = 0; i < qtplayers; i++) {
            points[i] = scanner.nextInt();
        }
        for (int i = 0; i < qtmoves; i++) {
            for (int j = 0; j < 3; j++) {
                moves[j] = scanner.nextInt();
            }
            if (moves[0] == 1) {

            } else if (moves[0] == 2) {

            }
        }
    }
}
// create dictionary, put every number on int, if they start a guild, put the same number for then and
// the total lvl as the sum os the 2 lvls.

// create a lot of dictionarys, 1 per great guild, and if the key[player] isIn the dict, put the another
// player in the dictionary and every player inside the dict receives the sum of all values + the new one