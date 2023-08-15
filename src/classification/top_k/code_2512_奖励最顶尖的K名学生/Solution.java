package classification.top_k.code_2512_奖励最顶尖的K名学生;

import java.util.*;

/**
 * completion time = 2023.8.15
 */
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> p = new HashSet<>();
        Set<String> n = new HashSet<>();
        Collections.addAll(p, positive_feedback);
        Collections.addAll(n, negative_feedback);
        Map<Integer, Integer> m = new HashMap<>();
        int len = report.length;
        for (int i = 0; i < len; i++) {
            String[] s = report[i].split(" ");
            int count = 0;
            for (String word : s) {
                if (p.contains(word)) {
                    count += 3;
                } else if (n.contains(word)) {
                    count -= 1;
                }
            }
            m.put(i, count);
        }
        TreeSet<Integer> s = new TreeSet<>((i, j) -> {
            if (!m.get(i).equals(m.get(j))) {
                return m.get(j) - m.get(i);
            }
            return student_id[i] - student_id[j];
        });
        s.addAll(m.keySet());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(student_id[s.pollFirst()]);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] p = {"smart", "brilliant", "studious"};
        String[] n = {"not"};
        String[] reports = {"this student is not studious", "the student is smart"};
        int[] ids = {1, 2};
        System.out.println(new Solution().topStudents(p, n, reports, ids, 2));
    }
}
