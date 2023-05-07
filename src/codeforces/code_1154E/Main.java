package codeforces.code_1154E;

import java.util.*;

/**
 * completion time = 2023.4.13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        // 数组模拟链表
        int[] pre = new int[n];
        int[] next = new int[n];
        pre[0] = -1;
        next[n - 1] = -1;
        // set存的也是下标，但是按照arr[i]进行排序
        SortedSet<Integer> set = new TreeSet<>((o1, o2) -> arr[o2] - arr[o1]) {
        };
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            set.add(i);
            // 只讨论符合条件的情况
            if (i != 0) {
                pre[i] = i - 1;
            }
            if (i != n - 1) {
                next[i] = i + 1;
            }
        }
        int[] ans = new int[n];
        int time = 0;
        int count = 0;
        while (count < n) {
            Integer first = set.first();
            ArrayList<Integer> needDelete = new ArrayList<>();
            needDelete.add(first);
            int tmpIndex = pre[first];
            for (int i = 0; i < k; i++) {
                if (tmpIndex == -1) {
                    break;
                }
                needDelete.add(tmpIndex);
                tmpIndex = pre[tmpIndex];
            }
            tmpIndex = next[first];
            for (int i = 0; i < k; i++) {
                if (tmpIndex == -1) {
                    break;
                }
                needDelete.add(tmpIndex);
                tmpIndex = next[tmpIndex];
            }
            count += needDelete.size();
            for (Integer integer : needDelete) {
                delete(integer, pre, next);
                set.remove(integer);
                if (time % 2 == 0) {
                    ans[integer] = 1;
                } else {
                    ans[integer] = 2;
                }
            }
            time++;
        }
        for (int an : ans) {
            System.out.print(an);
        }
    }

    // 本题的关键是删除一个节点后，数组模拟的链表该如何变化
    // 只要判断当前节点，是否有前向节点或者是否有后向节点
    // 有符合要求的前向或者后向节点，就可以更新，否则跳过就可以了
    public static void delete(int index, int[] pre, int[] next) {
        int preIndex = pre[index];
        int nextIndex = next[index];
        int n = pre.length;
        if (preIndex != -1) {
            next[preIndex] = next[index];
        }
        if (nextIndex != -1) {
            pre[nextIndex] = pre[index];
        }
        pre[index] = -1;
        next[index] = -1;
    }
}
