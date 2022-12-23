package TowardsOffer2_Special.day_38_图.code_113_课程顺序;

import java.util.*;

/**
 * completion time = 2022.11.17
 */
class Solution {
    private boolean[] seen;
    private boolean[] learn;
    private Map<Integer, Set<Integer>> top = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        seen = new boolean[numCourses];
        learn = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            top.putIfAbsent(prerequisite[0], new HashSet<>());
            top.get(prerequisite[0]).add(prerequisite[1]);
        }
        List<Integer> init = new ArrayList<>();
        boolean dfs = true;
        for (int i = 0; i < numCourses; i++) {
            if (!seen[i]){
                dfs = dfs(i, init);
                if (!dfs){
                    return new int[]{};
                }
            }
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = init.get(i);
        }
        return ans;
    }

    boolean dfs(int course, List<Integer> pre) {
        if (learn[course]) {
            return learn[course];
        }
        if (!seen[course] && !top.containsKey(course)) {
            seen[course] = true;
            learn[course] = true;
            pre.add(course);
            return true;
        }
        if (seen[course]) {
            return false;
        }
        seen[course] = true;
        boolean judge = true;
        for (Integer integer : top.get(course)) {
            judge &= dfs(integer, pre);
        }
        if (judge) {
            learn[course] = true;
            pre.add(course);
        }
        return judge;
    }

    public static void main(String[] args) {
//        int[][] arr = {{3, 1}, {3, 2}, {1, 0}, {2, 0}};
        Solution solution = new Solution();
        int[] order = solution.findOrder(2, new int[][]{});
        for (int i : order) {
            System.out.println(i);
        }
    }
}