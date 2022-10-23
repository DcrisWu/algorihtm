package BinarySearch;

import java.util.Arrays;
import java.util.Collections;

public class nineteen_2 {
    public static void main(String[] args) {
        int[] arr = {1000000000};
        nineteen_2 nineteen_2 = new nineteen_2();
        System.out.println(nineteen_2.maxProfit(arr, 1000000000));
    }

    public int maxProfit(int[] inventory, int orders) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(inventory);
        int len = inventory.length;
        long ans = 0;
        //getNum表示已经买了的球的数量,cnt表示现在有cnt种球的价格相同且都是最高价
        int getNum = 0, cnt = 1, lastPrice = inventory[len - 1];
        for (int i = len - 2; i >= 0 && getNum <= orders; i--) {
            if (inventory[i] == inventory[i + 1]) {
                cnt++;
                continue;
            }
            int diff = inventory[i + 1] - inventory[i];
            if (getNum + diff * cnt >= orders) {
                break;
            }
            getNum += diff * cnt;//已经买了的球的数量
            ans += (long) (inventory[i + 1] + inventory[i] + 1) * diff / 2 * cnt;//(首项 + 末项) * 项数 / 2 * 列数
            lastPrice = inventory[i];
            cnt++;
        }
        int restNum = orders - getNum;//还需要买的球的数量
        int n = restNum / cnt;//n表示还可以买的圈数
        ans += (lastPrice + lastPrice - n + 1L) * n / 2 * cnt;//(首项 + 末项) * 项数 / 2 * 列数
        ans += (long) (restNum % cnt) * (lastPrice - n);
        return (int) (ans % mod);

//        int mod = (int)1e9 + 7;
//        Arrays.sort(inventory);
//        int len = inventory.length;
//        long ans = 0, getnum = 0;
//        int cnt = 1, lastPrice = inventory[len - 1];
//        for (int i = len - 2; i >= 0 && getnum <= orders; --i) {
//            // 过滤重复值, 减少计算, 可能导致getnum最终小于orders
//            if (inventory[i] == inventory[i + 1]) {
//                cnt++;
//                continue;
//            }
//            long diff = inventory[i + 1] - inventory[i];
//            if (getnum + diff * cnt >= orders) break; // 超出时中断取
//            getnum += diff * cnt; // 得到的球的个数
//            lastPrice = inventory[i];
//            ans += (inventory[i + 1] + inventory[i] + 1) * diff / 2 * cnt;
//            cnt++; // 不同的球个数增加
//        }
//        // System.out.println(getnum + " " + lastPrice + " " + cnt + " " + ans);
//        long needNum = orders - getnum;
//        long n = needNum / cnt; // 还得取n圈
//        ans += (lastPrice + lastPrice - n + 1L) * n / 2 * cnt;
//        // System.out.println(ans + " " + n + " " + needNum);
//        ans += (needNum % cnt) * (lastPrice - n);
//        return (int)(ans % mod);
    }
}
