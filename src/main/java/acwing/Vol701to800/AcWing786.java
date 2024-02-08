package acwing.Vol701to800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing786 {
    public static int quickSort(int[] array, int l, int r, int k) {
        if (l >= r) {
            return array[l];
        }

        int i = l - 1;
        int j = r + 1;
        int x = array[(l + r) >> 1];
        while (i < j) {
            do i++; while (array[i] < x) ;
            do j--; while (array[j] > x) ;
            if (i < j) {
                swap(array, i, j);
            }
        }

        if (k <= j) {
            return quickSort(array, l, j, k);
        }
        return quickSort(array, j + 1, r, k);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int k = Integer.parseInt(params[1]);

        int[] array = new int[n];
        params = buf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(params[i]);
        }

        System.out.println(quickSort(array, 0, array.length - 1, k - 1));
    }
}
