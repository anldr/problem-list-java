package algorithm_template;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MergeSort {
    public static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return ;
        }

        int mid = (l + r) >> 1;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);

        int[] tmp = new int[array.length];
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= r) {
            tmp[k++] = array[j++];
        }

        for (i = l, k = 0; i <= r; i++, k++) {
            array[i] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{49, 59, 88, 37, 98, 97, 68, 54, 31, 3};

        log.info("排序前：{}", Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        log.info("排序后：{}", Arrays.toString(array));

        int[] array2 = new int[]{6, 16, 59, 36, 24, 68, 3, 72};

        log.info("排序前：{}", Arrays.toString(array2));
        mergeSort(array2, 0, array2.length - 1);
        log.info("排序后：{}", Arrays.toString(array2));
    }
}
