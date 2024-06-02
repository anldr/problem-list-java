import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import z_others.CirQueue;

@Slf4j
public class Test02 {
    @Test
    public void test() {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();

        log.info("{}", str1 == str2);
        log.info("{}", str2 == str3);
        log.info("{}", str1 == str3);

        CirQueue queue = new CirQueue(3);

        log.info("{}", queue.push(1));
        log.info("{}", queue.push(2));
        log.info("{}", queue.push(3));
        log.info("{}", queue.push(4));
        log.info("{}", queue.back());
        log.info("{}", queue.is_full());
        log.info("{}", queue.pop());
        log.info("{}", queue.push(4));
        log.info("{}", queue.back());
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1,2,3,4,5,5,5,5};
        binSearch1(nums, 6);
    }

    private int binSearch1(int[] nums, int target) {
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int mid = (l + r) >>1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        System.out.println(l + "  " + r);
        return r;
    }
}
