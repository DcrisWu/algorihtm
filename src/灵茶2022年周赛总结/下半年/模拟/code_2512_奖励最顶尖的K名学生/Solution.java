package 灵茶2022年周赛总结.下半年.模拟.code_2512_奖励最顶尖的K名学生;

import java.util.*;

/**
 * completion time = 2023.5.22
 */
class Solution {
    public static void main(String[] args) {
        String[] positive_feedback = {"smart", "brilliant", "studious"}, negative_feedback = {"not"}, report = {"this student is not studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        PriorityQueue<int[]> scores = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o2[1] - o1[1];
                });
        int n = report.length;
        for (int i = 0; i < n; i++) {
            int score = 0;
            for (String s : report[i].split(" ")) {
                if (positive.contains(s)) {
                    score += 3;
                }
                if (negative.contains(s)) {
                    score -= 1;
                }
            }
            scores.add(new int[]{student_id[i], score});
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            int[] ints = scores.poll();
            ans.add(ints[0]);
        }
        return ans;
    }
}
