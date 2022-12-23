package TowardsOffer2_Special.day_37_图.code_109_开锁密码;

import java.util.*;

/**
 * completion time = 2022.11.16
 */
class Solution {
    public static void main(String[] args) {
        String[] arr = {"0201", "0101", "0102", "1212", "2002"};
        Solution solution = new Solution();
        System.out.println(solution.openLock(arr, "0202"));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(List.of(deadends));
        String init = "0000";
        if (dead.contains(init)) {
            return -1;
        }
        if(target.equals(init)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(init);
        seen.add(init);
        int times = 0;
        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (dead.contains(poll)) {
                    continue;
                }
                char[] array = poll.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char temp = array[j];
                    array[j] = numInc(temp);
                    String s1 = new String(array);
                    if (target.equals(s1)) {
                        return times;
                    }
                    if (!seen.contains(s1)) {
                        queue.offer(s1);
                        seen.add(s1);
                    }
                    array[j] = numDesc(temp);
                    String s2 = new String(array);
                    if (target.equals(s2)) {
                        return times;
                    }
                    if (!seen.contains(s2)) {
                        queue.offer(s2);
                        seen.add(s2);
                    }
                    array[j] = temp;
                }
            }
        }
        return -1;
    }

    char numInc(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    char numDesc(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }
}