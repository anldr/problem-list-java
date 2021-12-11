package acwing.Vol3801to3900;

import java.util.Scanner;
import java.util.TreeMap;

public class AcWing3814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int result = -1;
        TreeMap<String, Integer> rowMap = new TreeMap<>();
        while (n > 0) {
            String line = scanner.nextLine();
            rowMap.put(line, rowMap.getOrDefault(line, 0) + 1);
            result = Math.max(result, rowMap.get(line));
            n--;
        }
        System.out.println(result);
    }
}
