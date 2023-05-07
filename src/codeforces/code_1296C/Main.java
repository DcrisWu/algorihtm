package codeforces.code_1296C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * completion time = 2023.4.12
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String str = scanner.next();
            // 第一层的key表示 L & R,L用 -1，R用 +1
            // 第二层的key表示 U & P,U用 +1, D用 -1
            // 最后的值表示下标，初始化下标为0，表示在str.charAt(i)前的位置，不包含str.charAt(i)
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            map.put(0, new HashMap<>());
            map.get(0).put(0, 0);
            int x = 0, y = 0;
            int l = -1, r = -1;
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == 'L') {
                    x -= 1;
                } else if (str.charAt(j) == 'R') {
                    x += 1;
                } else if (str.charAt(j) == 'U') {
                    y += 1;
                } else {
                    y -= 1;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        if (l == -1 || j + 1 - map.get(x).get(y) < r - l) {
                            l = map.get(x).get(y) + 1;
                            r = j + 1;
                        }
                    }
                } else {
                    map.put(x, new HashMap<>());
                }
                map.get(x).put(y, j + 1);
            }
            System.out.println(l == -1 ? -1 : l + " " + r);

        }
    }
}
