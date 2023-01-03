package daily.year_2023.January.day_2_code_1801_积压订单中的订单总数;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] orders =
                {{19, 28, 0}, {9, 4, 1}, {25, 15, 1}};
        solution.getNumberOfBacklogOrders(orders);
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Integer> buy = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> sell = new PriorityQueue<>();
        Map<Integer, Integer> buyCount = new HashMap<>();
        Map<Integer, Integer> sellCount = new HashMap<>();
        for (int[] order : orders) {
            // 采购订单
            if (order[2] == 0) {
                while (true) {
                    // 如果销售列表为空
                    if (sell.isEmpty()) {
                        // 直接加入队列和Map中
                        buy.add(order[0]);
                        buyCount.put(order[0], buyCount.getOrDefault(order[0], 0) + order[1]);
                        break;
                    } else {
                        // 如果卖的太贵了
                        if (sell.peek() > order[0]) {
                            buy.add(order[0]);
                            buyCount.put(order[0], buyCount.getOrDefault(order[0], 0) + order[1]);
                            break;
                        }
                        int min = Math.min(sellCount.get(sell.peek()), order[1]);
                        // 如果卖的最便宜的卖完了，先把最便宜的买了，再看下一个最便宜的
                        if (sellCount.get(sell.peek()) == min) {
                            sellCount.remove(sell.peek());
                            sell.poll();
                            order[1] = order[1] - min;
                        } else {
                            // 如果卖的最便宜的没卖完，就是买的已经买够了
                            sellCount.put(sell.peek(), sellCount.get(sell.peek()) - min);
                            break;
                        }
                    }
                }
            } else {
                // 销售订单
                while (true) {
                    // 如果买的队列尾空
                    if (buy.isEmpty()) {
                        sell.add(order[0]);
                        sellCount.put(order[0], sellCount.getOrDefault(order[0], 0) + order[1]);
                        break;
                    } else {
                        // 如果买的出价太低
                        if (buy.peek() < order[0]) {
                            sell.add(order[0]);
                            sellCount.put(order[0], sellCount.getOrDefault(order[0], 0) + order[1]);
                            break;
                        }
                        int min = Math.min(buyCount.get(buy.peek()), order[1]);
                        // 如果出价高的都销售出去的，就循环看下一个
                        if (buyCount.get(buy.peek()) == min) {
                            buyCount.remove(buy.peek());
                            buy.poll();
                            order[1] -= min;
                        } else {
                            // 如果出价高的没有销售完，就说明已经销售完
                            buyCount.put(buy.peek(), buyCount.get(buy.peek()) - min);
                            break;
                        }
                    }
                }
            }

        }
        long mod = (long) (1e9 + 7);
        long ans = 0;
        for (Integer value : buyCount.values()) {
            if (value != null) {
                ans = (ans + value) % mod;
            }
        }
        for (Integer value : sellCount.values()) {
            ans = (ans + value) % mod;
        }
        return (int) ans;


    }


}
