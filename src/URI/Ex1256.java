package URI;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
/**
 * Created by Daniel on 10/05/2016.
 */

public class Ex1256 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Dictionary dict = new Hashtable();
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int diclen = scanner.nextInt();
            int quant = scanner.nextInt();
            for (int j = 0; j < diclen; j++) {
                dict.put(j, String.format("%d -> ",j));
            }
            for (int j = 0; j < quant; j++) {
                int number = scanner.nextInt();
                int rest = number%diclen;
                dict.put(rest, dict.get(rest) + String.format("%d -> ", number));
            }
            if (i==0) {
                for (int j = 0; j < diclen; j++) {
                    System.out.println(dict.get(j) + String.format("\\"));
                }
            }else{
                System.out.println();
                for (int j = 0; j < diclen; j++) {
                    System.out.println(dict.get(j) + String.format("\\"));
                }
            }
        }
    }
}
