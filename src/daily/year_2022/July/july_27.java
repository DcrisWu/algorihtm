package daily.year_2022.July;

import java.util.Vector;

public class july_27 {
    public static String fractionAddition(String expression) {
        //表示分子
        Vector<Integer> mole = new Vector<>();
        //表示分母
        Vector<Integer> deno = new Vector<>();

        int index = 0;
        while (index < expression.length()) {
            //sign == false表示这是一个符号，默认正好
            boolean sign = true;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? false : true;
                index += 1;
            }
            int zi = expression.charAt(index) - '0';
            while (index + 1 < expression.length() && expression.charAt(index + 1) >= '0' && expression.charAt(index + 1) <= '9') {
                index += 1;
                zi = zi * 10 + expression.charAt(index) - '0';
            }
            //将分子加入到向量中
            if (sign) {
                mole.add(zi);
            } else {
                mole.add(-zi);
            }
            //右移两位，跳过分号，到达分母
            index += 2;
            int mu = expression.charAt(index) - '0';
            while (index + 1 < expression.length() && expression.charAt(index + 1) >= '0' && expression.charAt(index + 1) <= '9') {
                index += 1;
                mu = mu * 10 + expression.charAt(index) - '0';
            }
            //将分母加入到分母的向量
            deno.add(mu);
            index++;
        }
        for (Integer integer : deno) {
            System.out.println(integer);
        }
        for (Integer integer : mole) {
            System.out.println(integer);
        }
        if (mole.size() == 1) {
            return expression;
        }
        //求出头两个元素的最小公倍数
        //表示通分后的分母
        int temp_deno = deno.get(0) * deno.get(1) / gcd(deno.get(0), deno.get(1));
        for (int i = 2; i < deno.size(); i++) {
            temp_deno = deno.get(i) * temp_deno / gcd(deno.get(i), temp_deno);
        }
        //表示通分后的分子
        int temp_mole = 0;
        for (int i = 0; i < mole.size(); i++) {
            temp_mole += mole.get(i) * (temp_deno / deno.get(i));
        }
        if (temp_mole == 0) {
            return "0/1";
        } else {
            int a = gcd(Math.abs(temp_deno), Math.abs(temp_mole));
            return String.valueOf(temp_mole / a) + "/" + String.valueOf(temp_deno / a);
        }
    }

    public static int gcd(int a, int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        int a = -2;
        int b = 12;
//        System.out.println(gcd(a, b));
        System.out.println(fractionAddition("-4/7-3/4+2/3"));
    }
}
