package competition.leetcode_weekly.No_351_day_2023_6_25.code_6891_机器人碰撞;

import java.util.*;

/**
 * completion time = 2023.6.25
 */
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // 位置i -> 机器人编号
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            pos.put(positions[i], i);
        }
        Arrays.sort(positions);
        // stack 存储的是机器人编号, - 表示向左，+ 表示向右
        Deque<Integer> stack = new ArrayDeque<>();
        for (int position : positions) {
            Integer idx = pos.get(position);
            char c = directions.charAt(idx);
            // 如果当前是向右的话，不会与之前的相撞
            if (c == 'R') {
                stack.push(idx);
            } else {
                // 如果是向左，可能会与之前的机器人相撞
                while (!stack.isEmpty()) {
                    // 栈顶的机器人也是向左的话，就不会相撞
                    if (stack.peek() < 0) {
                        stack.add(-1 * idx);
                        break;
                    } else {
                        // 如果栈顶的机器人向右
                        Integer peek = stack.peek();
                        if (healths[peek] < healths[idx]) {
                            // 栈顶的机器人血量小于等于当前机器人，栈顶的机器人死亡
                            healths[peek] = 0;
                            healths[idx] -= 1;
                            stack.pop();
                        } else if (healths[peek] > healths[idx]) {
                            // 栈顶的机器人血量大于当前机器人，当前机器人死亡
                            healths[idx] = 0;
                            healths[peek] -= 1;
                            break;
                        } else {
                            healths[peek] = 0;
                            stack.pop();
                            healths[idx] = 0;
                            break;
                        }
                    }
                }
            }

        }
        List<Integer> ans = new ArrayList<>();
        for (int health : healths) {
            if (health > 0) {
                ans.add(health);
            }
        }
        return ans;
    }
}
