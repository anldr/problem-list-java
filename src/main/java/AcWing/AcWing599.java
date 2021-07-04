package AcWing;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class AcWing599 {
    private static final int offset = 3;

//    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int ans = 0;
//        int[] high = new int[n + offset];
//        int[] value = new int[n + offset];
//        int[] result = new int[n + offset];
//        Deque<Integer> q = new LinkedList<>();
//        Deque<Integer> p = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            high[i] = scanner.nextInt();
//            value[i] = scanner.nextInt();
//            while (q.size() > 0 && high[q.getLast()] <= high[i]) {
//                q.removeLast();
//            }
//            if (q.size() > 0) {
//                result[q.getLast()] += value[i];
//                ans = Math.max(ans, result[q.getLast()]);
//            }
//            q.offerLast(i);
//            while (p.size() > 0 && high[p.getLast()] < high[i]) {
//                result[i] += value[p.getLast()];
//                ans = Math.max(ans, result[i]);
//                p.removeLast();
//            }
//            p.offerLast(i);
//        }
//        System.out.println(ans);
//    }

    public static void main (String[] args) throws IOException {
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int ans = 0;
        int[] high = new int[n + offset];
        int[] value = new int[n + offset];
        int[] result = new int[n + offset];
        Deque<Integer> q = new LinkedList<>();
        Deque<Integer> p = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String line = reader.readLine();
            String[] lineArray = line.split("\\s+");
            high[i] = Integer.parseInt(lineArray[0]);
            value[i] = Integer.parseInt(lineArray[1]);
            while (q.size() > 0 && high[q.getLast()] <= high[i]) {
                q.removeLast();
            }
            if (q.size() > 0) {
                result[q.getLast()] += value[i];
                ans = Math.max(ans, result[q.getLast()]);
            }
            q.offerLast(i);
            while (p.size() > 0 && high[p.getLast()] < high[i]) {
                result[i] += value[p.getLast()];
                ans = Math.max(ans, result[i]);
                p.removeLast();
            }
            p.offerLast(i);
        }
        r.close();
        reader.close();
        log.write(ans + "\n");
        log.flush();
        log.close();
    }
}
