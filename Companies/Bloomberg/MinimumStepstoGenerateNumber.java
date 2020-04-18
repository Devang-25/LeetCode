package Companies.Bloomberg;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumStepstoGenerateNumber {
    public int minSteps(int target) {
        Deque<Integer> q = new LinkedList<>();
        q.add(1);
        int step = 0, size = 0;
        int index = 0;
//        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
//                if (visited.contains(num)) {
//                    continue;
//                }
//                visited.add(num);
//                index++;
                if (num == target) {
//                    System.out.println(index);
                    return step;
                }
                q.add(num*2);
                if (num/3 != 0) {
                    q.add(num/3);
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String...args) {
        MinimumStepstoGenerateNumber test = new MinimumStepstoGenerateNumber();
        System.out.println(test.minSteps(10)); // 6 -> 1 * 2 * 2 * 2 * 2 / 3 * 2
        System.out.println(test.minSteps(3)); // 7 -> 1 * 2 * 2 * 2 * 2 * 2 / 3 / 3
    }
}
