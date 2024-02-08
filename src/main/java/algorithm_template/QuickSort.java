package algorithm_template;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class QuickSort {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return ;
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

        quickSort(array, l, j);
        quickSort(array, j + 1, r);
    }

    public static void main(String[] args) {
        int[] array = new int[]{49, 59, 88, 37, 98, 97, 68, 54, 31, 3};

        log.info("排序前：{}", Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        log.info("排序后：{}", Arrays.toString(array));

        int[] array2 = new int[]{6, 16, 59, 36, 24, 68, 3, 72};

        log.info("排序前：{}", Arrays.toString(array2));
        quickSort(array2, 0, array2.length - 1);
        log.info("排序后：{}", Arrays.toString(array2));
    }
}
