package daily.year_2022.August;

public class August_1 {
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                ans.append('a');
            }
            ans.append('b');

        } else {
            for (int i = 0; i < n; i++) {
                ans.append('a');
            }
        }
        return ans.toString();
    }
}
