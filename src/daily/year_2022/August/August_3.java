package daily.year_2022.August;

import java.util.Arrays;

public class August_3 {
    public static String orderlyQueue(String s, int k) {
        int n = s.length();
        if (k == 1) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s;
                StringBuilder sb = new StringBuilder(s.substring(1));
                sb.append(s.charAt(0));
                s = sb.toString();
            }
            String min = arr[0];
            for (int i = 1; i < n; i++) {
                if (min.compareTo(arr[i]) > 0) {
                    min = arr[i];
                }
            }
            return min;
        } else {
            char[] arr = new char[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.charAt(i);
            }
            Arrays.sort(arr);
            StringBuilder ans = new StringBuilder("");
            for (char c : arr) {
                ans.append(c);
            }
            return ans.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("abmxcdg", 2));
        System.out.println("abcdg".compareTo("abcdg"));
    }
}
