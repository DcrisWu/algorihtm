package meeting.sxf.code_3;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        new Main().solution();
    }

    private Map<String, Integer> ips;
    private List<String[]> range;
    private List<String[]> mask;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ips = new HashMap<>();
        range = new ArrayList<>();
        mask = new ArrayList<>();
        while (n > 0) {
            String line = sc.nextLine();
            if (line.charAt(0) == '1') {
                String key = line.split(" ")[1];
                ips.put(key, ips.getOrDefault(key, 0) + 1);
            } else if (line.charAt(0) == '2') {
                String[] split = line.split(" ");
                range.add(new String[]{split[1], split[2]});
            } else {
                String[] split = line.substring(2).split("/");
                mask.add(new String[]{split[1], split[2]});
            }
            n--;
        }
        while (m > 0) {
            String s = sc.next();
            System.out.println(check(s));
        }
    }

    public int check(String s) {
        int count = 0;
        count += ips.getOrDefault(s, 0);
        count += matchRange(s);
        count += matchMask(s);
        return count;
    }

    public int matchRange(String s) {
        int count = 0;
        for (String[] strings : range) {
            String[] first = strings[0].split("\\.");
            String[] second = strings[1].split("\\.");
            String[] target = s.split("\\.");
            boolean judge = true;
            for (int i = 0; i < 4; i++) {
                if (target[i].compareTo(first[i]) < 0 || target[i].compareTo(second[i]) > 0) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                count++;
            }
        }
        return count;
    }

    public int matchMask(String s) {
        int count = 0;
        for (String[] m : mask) {
            String[] ip = m[0].split("\\.");
            int mas = Integer.parseInt(m[1]);
            for (int i = 0; i < 4; i++) {
                int num = Integer.parseInt(ip[i]);
                ip[i] = Integer.toBinaryString(num);
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++){
                    if (ip[i].charAt(j) == '1'){
                        mas--;
                    }else {
                        break;
                    }
                }
            }
            if (mas == 0){
                count++;
            }
        }
        return count;
    }
}
