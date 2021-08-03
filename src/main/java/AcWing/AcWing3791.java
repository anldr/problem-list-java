package AcWing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AcWing3791 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String encodeString = scanner.next();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                deque.offerLast(encodeString.charAt(i));
            } else {
                deque.offerFirst(encodeString.charAt(i));
            }
        }
        StringBuffer ans = new StringBuffer("");
        while (!deque.isEmpty()) {
            ans.append(deque.getFirst());
            deque.removeFirst();
        }
        if ((n & 1) == 1) {
            System.out.println(ans);
        } else {
            System.out.println(ans.reverse());
        }
    }
}
