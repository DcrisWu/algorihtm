package competition.No_320_day_2022_11_20.code_6243_到达首都的最少油耗;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
        Solution solution = new Solution();
        System.out.println(solution.minimumFuelCost(arr, 5));
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        long cost = 0;
        int n = roads.length + 1;
        List<Integer>[] graph = new ArrayList[n];

        // 表示到达i城市时车辆处于不满载情况下每辆车的车载人数量
        PriorityQueue<Integer>[] notFullCarQueue = new PriorityQueue[n];
        // full[i] 表示到达i城市满载的车辆数
        int[] fullCarNum = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();

            notFullCarQueue[i] = new PriorityQueue();
            if (seats == 1) {
                fullCarNum[i] = 1;
            } else {
                notFullCarQueue[i].offer(1);
            }
        }

        int[] degree = new int[n];
        for (int[] road : roads) {
            int s = road[0], t = road[1];
            degree[s]++;
            degree[t]++;

            graph[s].add(t);
            graph[t].add(s);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && i != 0) {
                queue.offer(i);
            }
        }

        boolean[] vis = new boolean[n];
        while (!queue.isEmpty()) {
            int from = queue.poll();
            vis[from] = true;

            for (Integer to : graph[from]) {
                if (vis[to]) {
                    continue;
                }

                // 满载的车从 from 到 to 城市
                cost += fullCarNum[from];
                fullCarNum[to] += fullCarNum[from];

                // 到达首都
                if (to == 0) {
                    cost += notFullCarQueue[from].size();
                    break;
                }

                // 非满载的车辆来到 to 城市
                PriorityQueue<Integer> fromCars = notFullCarQueue[from];
                PriorityQueue<Integer> toCars = notFullCarQueue[to];
                while (!fromCars.isEmpty()) {
                    int count = fromCars.poll();
                    cost++;

                    // 搭顺风车
                    int size = toCars.size();
                    for (int i = 0; i < size && count > 0; i++) {
                        Integer cur = toCars.poll();
                        if (cur + count < seats) {
                            // 所有人加塞进去
                            toCars.offer(cur + count);
                            count = 0;
                        } else {
                            // 加塞部分人
                            fullCarNum[to]++;
                            count -= (seats - cur);
                        }
                    }

                    // 加塞后剩余的人
                    if (count > 0) {
                        toCars.offer(count);
                    }
                }


                degree[from]--;
                degree[to]--;
                if (degree[to] == 1) {
                    queue.offer(to);
                }
            }
        }

        return cost;
    }
}
