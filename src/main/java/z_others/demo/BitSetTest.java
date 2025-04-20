package z_others.demo;

import java.util.*;

public class BitSetTest {
    public static void main(String[] args) {
        // 创建一个大小为1000的BitSet，初始所有位为false
        BitSet bitSet = new BitSet(1000);

        // 假设已有的100个随机数
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomNum = random.nextInt(1000) + 1; // 生成1到1000之间的随机数
            bitSet.set(randomNum - 1); // 设置对应位为true，注意位索引是从0开始的
        }

        // 查找BitSet中仍为false的位所对应的整数，即未出现过的数
        for (int i = bitSet.nextClearBit(0); i < 1000 && i >= 0; i = bitSet.nextClearBit(i + 1)) {
            System.out.println(i + 1); // 输出未出现过的数（+1是因为位索引从0开始）
        }
    }
}
