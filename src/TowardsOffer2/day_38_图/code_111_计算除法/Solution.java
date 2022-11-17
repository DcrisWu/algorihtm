package TowardsOffer2.day_38_图.code_111_计算除法;

import java.util.*;

/**
 * completion time = 2022.11.17
 */
class Solution {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("c");
        equations.add(l1);
        equations.add(l2);
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        List<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        List<String> q3 = new ArrayList<>();
        q3.add("a");
        q3.add("e");
        List<String> q4 = new ArrayList<>();
        q4.add("a");
        q4.add("a");
        List<String> q5 = new ArrayList<>();
        q5.add("x");
        q5.add("x");
        queries.add(q1);
        queries.add(q2);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);
        Solution solution = new Solution();
        double[] doubles = solution.calcEquation(equations, values, queries);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    private Map<String, Set<Integer>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            map.putIfAbsent(equations.get(i).get(0), new HashSet<>());
            map.get(equations.get(i).get(0)).add(i);
            map.putIfAbsent(equations.get(i).get(1), new HashSet<>());
            map.get(equations.get(i).get(1)).add(i);
        }
        double[] ans = new double[queries.size()];
        Arrays.fill(ans,-1);
        boolean[] seen = new boolean[equations.size()];
        for (int i = 0; i < ans.length; i++) {
            if (!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1))) {
                ans[i] = -1;
                continue;
            }
            if(queries.get(i).get(0).equals(queries.get(i).get(1))){
                ans[i] = 1;
                continue;
            }
            String begin = queries.get(i).get(0);
            Set<Integer> integerSet = map.get(begin);
            for (Integer integer : integerSet) {
                seen[integer] = true;
                if (equations.get(integer).get(0).equals(begin)) {
                    double dfs = dfs(seen, equations, values, queries.get(i), equations.get(integer), values[integer]);
                    seen[integer] = false;
                    if (dfs != -1) {
                        ans[i] = dfs;
                        break;
                    }
                } else {
                    List<String> pre = new ArrayList<>();
                    pre.add(equations.get(integer).get(1));
                    pre.add(equations.get(integer).get(0));
                    double dfs = dfs(seen, equations, values, queries.get(i), pre, 1 / values[integer]);
                    seen[integer] = false;
                    if (dfs != -1) {
                        ans[i] = dfs;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    double dfs(boolean[] seen, List<List<String>> equations, double[] values, List<String> target, List<String> pre, double preValue) {
        if (pre.equals(target)) {
            return preValue;
        }
        // 表示上一表达式的分母
        String str = pre.get(1);
        Set<Integer> set = map.get(str);
        for (Integer integer : set) {
            // 如果这个表达式被使用过
            if (seen[integer]) {
                continue;
            }
            // 如果当前表达式的分子等于上一表达式的分子
            if (equations.get(integer).get(0).equals(str)) {
                seen[integer] = true;
                pre.set(1, equations.get(integer).get(1));
                double dfs = dfs(seen, equations, values, target, pre, preValue * values[integer]);
                pre.set(1, str);
                seen[integer] = false;
                if (dfs != -1) {
                    return dfs;
                }
            } else {
                seen[integer] = true;
                pre.set(1, equations.get(integer).get(0));
                double dfs = dfs(seen, equations, values, target, pre, preValue / values[integer]);
                pre.set(1, str);
                seen[integer] = false;
                if (dfs != -1) {
                    return dfs;
                }
            }
        }
        return -1;
    }

}