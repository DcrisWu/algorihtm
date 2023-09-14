package meeting.webank.code_2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        while (!q.isEmpty()){
            Integer first = q.poll();
            System.out.print(first);
            if (!q.isEmpty()) {
                System.out.print(" ");
                Integer second = q.poll();
                q.add(second);
            }
        }
    }
}
