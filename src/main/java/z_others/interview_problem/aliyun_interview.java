package z_others.interview_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个任务列表，每个任务有固定的开始和结束时间，同时每个任务需要消耗不同的cpu和内存。
 * 假设每个任务结束后cpu和内存可以立即释放，为了完成这些任务，至少需要什么样的内存和cpu配置？
 *
 * 做法其实不难，将一个任务拆分为两个时间，一个开始时间，一个结束时间
 */
public class aliyun_interview {
    // 任务定义
    static class Task {
        int start;
        int end;
        int cpu;
        int memory;

        public Task(int start, int end, int cpu, int memory) {
            this.start = start;
            this.end = end;
            this.cpu = cpu;
            this.memory = memory;
        }
    }

    // 事件定义
    static class Event {
        int time;
        boolean isStart; // true表示任务开始，false表示任务结束
        int cpu;
        int memory;

        public Event(int time, boolean isStart, int cpu, int memory) {
            this.time = time;
            this.isStart = isStart;
            this.cpu = cpu;
            this.memory = memory;
        }
    }

    public static int[] calculateMinResources(List<Task> tasks) {
        // 1. 生成事件列表
        List<Event> events = new ArrayList<>();
        for (Task task : tasks) {
            events.add(new Event(task.start, true, task.cpu, task.memory));
            events.add(new Event(task.end, false, task.cpu, task.memory));
        }

        // 2. 排序事件
        Collections.sort(events, (a, b) -> {
            if (a.time != b.time) {
                return Integer.compare(a.time, b.time);
            }
            // 时间相同：结束事件优先处理
            return Boolean.compare(b.isStart, a.isStart);
        });

        // 3. 扫描计算峰值
        int currentCpu = 0;
        int currentMem = 0;
        int maxCpu = 0;
        int maxMem = 0;

        for (Event event : events) {
            if (event.isStart) {
                currentCpu += event.cpu;
                currentMem += event.memory;
            } else {
                currentCpu -= event.cpu;
                currentMem -= event.memory;
            }
            maxCpu = Math.max(maxCpu, currentCpu);
            maxMem = Math.max(maxMem, currentMem);
        }

        return new int[]{maxCpu, maxMem};
    }

    public static void main(String[] args) {
        // 测试用例1（与示例一致）
        List<Task> tasks1 = Arrays.asList(
                new Task(1, 3, 2, 3),
                new Task(2, 4, 1, 2),
                new Task(3, 5, 3, 1)
        );
        int[] res1 = calculateMinResources(tasks1);
        System.out.println("测试用例1结果：CPU=" + res1[0] + " 内存=" + res1[1]);

        // 测试用例2（完全重叠任务）
        List<Task> tasks2 = Arrays.asList(
                new Task(0, 5, 4, 6),
                new Task(1, 4, 3, 2),
                new Task(2, 3, 2, 3)
        );
        int[] res2 = calculateMinResources(tasks2);
        System.out.println("测试用例2结果：CPU=" + res2[0] + " 内存=" + res2[1]);

        // 测试用例3（无重叠任务）
        List<Task> tasks3 = Arrays.asList(
                new Task(1, 2, 5, 4),
                new Task(3, 4, 3, 2),
                new Task(5, 6, 2, 3)
        );
        int[] res3 = calculateMinResources(tasks3);
        System.out.println("测试用例3结果：CPU=" + res3[0] + " 内存=" + res3[1]);
    }
}
