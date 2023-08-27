package meeting.jd.code_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
        System.out.print("A");
    }

    String[] id;
    int[] energy;
    int[][] meet;

    String[][] tell;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        id = new String[n];
        energy = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = sc.next();
            energy[i] = sc.nextInt();
        }
        meet = new int[m][2];
        tell = new String[m][2];
        for (int i = 0; i < m; i++) {
            meet[i][0] = sc.nextInt();
            meet[i][1] = sc.nextInt();
            tell[i][0] = sc.next();
            tell[i][1] = sc.next();
        }
        // false表示存活，true表示死了
        boolean[] dead = new boolean[n];
        for (int i = 0; i < m; i++) {
            // 两人相遇
            int u = meet[i][0] - 1;
            int v = meet[i][1] - 1;
            // 死了或者势力相同，就continue
            if (dead[u] || dead[v] || id[u].equals(id[v])) {
                continue;
            }
            int human = id[u].equals("human") ? u : v;
            int monster = human == u ? v : u;
            boolean humanTell = false;
            boolean monsterTell = false;
            if (human == u) {
                humanTell = tell[i][0].equals("Y");
            } else {
                humanTell = tell[i][1].equals("Y");
            }
            if (monster == u) {
                monsterTell = tell[i][0].equals("Y");
            } else {
                monsterTell = tell[i][1].equals("Y");
            }
            boolean[] attack = attack(humanTell, monsterTell, energy[human], energy[monster]);
            dead[human] = attack[0];
            dead[monster] = attack[1];
        }
        for (int i = 0; i < n; i++) {
            if (dead[i]) {
                System.out.print("N");
            } else {
                System.out.print("Y");
            }
        }
    }

    // arr[0]表示human死了，arr[1]表示monster死了
    public boolean[] attack(boolean humanTell, boolean monsterTell, int h, int m) {
        // 人类说了，monster一定攻击
        if (humanTell) {
            if (h == m) {
                return new boolean[]{true, true};
            } else if (h > m) {
                return new boolean[]{false, true};
            } else {
                return new boolean[]{true, false};
            }
        } else {
            // 人类不说，就看monster说不说
            // monster说了
            if (monsterTell) {
                // h > m 攻击
                if (h > m) {
                    return new boolean[]{false, true};
                } else {
                    return new boolean[]{false, false};
                }
            } else {
                // monster也不说
                return new boolean[]{false, false};
            }
        }
    }
}