package acwing;

import java.util.Scanner;
import java.util.TreeMap;

public class AcWing3761 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            TreeMap<Integer,Integer> indexMap = new TreeMap<>();
            TreeMap<Integer,Integer> numMap = new TreeMap<>();
            for (int i = 0 ; i < n; i++) {
                int x = scanner.nextInt();
                indexMap.put(x, i + 1);
                numMap.put(x, numMap.getOrDefault(x, 0) + 1);
            }
            int result = -1;
            for (Integer tempNum : numMap.keySet()) {
                if (numMap.get(tempNum) == 1) {
                    result = indexMap.get(tempNum);
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
