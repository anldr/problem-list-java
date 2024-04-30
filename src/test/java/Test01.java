import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Test01 {
    @Test
    public void test() {
        int[] array = new int[]{4,5,6,7,0,1,2};

        int idx = findRoateIndex(array, array[0]);
        int idx2 = findRoateIndex2(array, array[0]);
        log.info("第一种下标：{}， 对应值：{}", idx, array[idx]);
        log.info("第二种下标：{}， 对应值：{}", idx2, array[idx2]);


        array = new int[]{1,2,3,3,3,3,3,4,5,6,7};

        idx = findRoateIndex3(array, array[2]);
        idx2 = findRoateIndex4(array, array[2]);
        log.info("第一种下标：{}， 对应值：{}", idx, array[idx]);
        log.info("第二种下标：{}， 对应值：{}", idx2, array[idx2]);
    }

    private int findRoateIndex(int[] array, int tar) {
        int l = 0;
        int r = array.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(array[mid], tar)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int findRoateIndex2(int[] array, int tar) {
        int l = 0;
        int r = array.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(array[mid], tar)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    private int findRoateIndex3(int[] array, int tar) {
        int l = 0;
        int r = array.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(array[mid], tar)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int findRoateIndex4(int[] array, int tar) {
        int l = 0;
        int r = array.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check2(array[mid], tar)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private Boolean check(int a, int b) {
        return a < b;
    }

    private Boolean check2(int a, int b) {
        return a <= b;
    }
}
