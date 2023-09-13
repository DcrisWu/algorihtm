package meeting.webank.code_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(arr[i])) {
                list.add(0, arr[i]);
                set.add(arr[i]);
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}
