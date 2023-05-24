package codeforces.code_229B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n个点，m条边
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a - 1].add(new int[]{b - 1, c});
            g[b - 1].add(new int[]{a - 1, c});
        }
        ArrayList<int[]>[] t = new ArrayList[n];
        Arrays.setAll(t, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int pre = -2;
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int time = sc.nextInt();
                if (time != pre + 1) {
                    t[i].add(new int[]{time, time});
                } else {
                    int[] last = t[i].get(t[i].size() - 1);
                    last[1] = time;
                }
                pre = time;
            }
        }
        int res = -1, destination = n - 1;
        boolean[] visit = new boolean[n];
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        if (!t[0].isEmpty() && t[0].get(0)[0] == 0) {
            dis[0] = t[0].get(0)[1] + 1;
        }
        while (true) {
            int x = -1;
            for (int i = 0; i < n; i++) {
                if (!visit[i] && (x == -1 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x == destination) {
                res = dis[x];
                break;
            }
            visit[x] = true;
            for (int[] edge : g[x]) {
                int target = edge[0];
                int len = edge[1];
                if (visit[target]) {
                    continue;
                }
                int newDis = dis[x] + len;
                if (target == destination) {
                    dis[target] = Math.min(dis[target], newDis);
                    continue;
                }
                int idx = search(newDis, t[target]);
                if (idx < t[target].size() && t[target].get(idx)[0] <= newDis) {
                    dis[target] = Math.min(dis[target], t[target].get(idx)[1] + 1);
                } else {
                    dis[target] = Math.min(dis[target], newDis);
                }
            }
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static int search(int arrive, ArrayList<int[]> t) {
        int l = 0, r = t.size() - 1;
        int ans = t.size();
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (t.get(mid)[1] >= arrive) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
