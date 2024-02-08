package acwing.Vol4601to4700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing4653 {
    public static int quickSort(int[] array, int[] arrayDig, int l, int r, int k) {
        if (l >= r) {
            return array[l];
        }

        int i = l - 1;
        int j = r + 1;
        int x = array[(l + r) >> 1];
        while (i < j) {
            do i++; while (compare(arrayDig, array[i], x)) ;
            do j--; while (compareV2(arrayDig, array[j], x)) ;
            if (i < j) {
                swap(array, i, j);
            }
        }

        if (k <= j) {
            return quickSort(array, arrayDig, l, j, k);
        }
        return quickSort(array, arrayDig, j + 1, r, k);
    }

    private static boolean compare(int[] arrayDig, int a, int b) {
        return arrayDig[a - 1] == arrayDig[b - 1] ? a < b : arrayDig[a - 1] < arrayDig[b - 1];
    }

    private static boolean compareV2(int[] arrayDig, int a, int b) {
        return arrayDig[a - 1] == arrayDig[b - 1] ? a > b : arrayDig[a - 1] > arrayDig[b - 1];
    }

    private static int digtalTotal(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x = x / 10;
        }
        return result;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String param = buf.readLine();
        int n = Integer.parseInt(param);
        param = buf.readLine();
        int m = Integer.parseInt(param);

        int[] array = new int[n];
        int[] arrayDig = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
            arrayDig[i] = digtalTotal(i + 1);
        }

        System.out.println(quickSort(array, arrayDig, 0, array.length - 1, m - 1));
    }
}
