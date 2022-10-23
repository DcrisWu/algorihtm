package daily;

import java.util.*;

public class july_6 {

    public static void main(String[] args) {
        String a = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        july_6 july_6 = new july_6();
//        System.out.println(july_6.evaluate(a));
    }

    Map<String, Deque<Integer>> scope = new HashMap<>();
    int start = 0;

    public String parseVar(String expression) {
        int n = expression.length();
        StringBuffer buf = new StringBuffer();
        while (start < n && Character.isLowerCase(expression.charAt(start))) {
            buf.append(expression.charAt(start));
            start++;
        }
        return buf.toString();
    }

    public int parseInt(String expression) {
        int n = expression.length();
        int res = 0;
        int sign = 1;
        if (expression.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        while (start < n && Character.isDigit(expression.charAt(start))) {
            res = res * 10 + (expression.charAt(start) - '0');
        }
        return res * sign;
    }

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    public int innerEvaluate(String expression) {
        if (expression.charAt(start) != '(') { //这不是一个表达式，可能是变量或者数值
            if (Character.isLowerCase(expression.charAt(start))) {
                String var = parseVar(expression);//这是一个变量
                return scope.get(var).peek();//返回变量x存储的最新一个变量
            } else {
                return parseInt(expression);
            }
        }
        //如果是一个表达式
        int ans;
        start++;//去除(
        if (expression.charAt(start) == 'l') {// let表达式
            start += 4;
            List<String> vars = new ArrayList<>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(start))) {
                    ans = innerEvaluate(expression); //let表达式的最后一个expr表达式的值
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(start) == ')') {
                    ans = scope.get(var).peek(); //let表达式的最后一个expr表达式的值
                    break;
                }
                vars.add(var);
                start++;//移除空格
                int e = innerEvaluate(expression);
                scope.putIfAbsent(var, new ArrayDeque<>());
                scope.get(var).push(e);
                start++;//移除空格
            }
            for (String var : vars) {
                scope.get(var).pop();//清楚当前作用域的变量
            }
        } else if (expression.charAt(start) == 'a') { // add表达式
            start += 4;//跳过add
            int e1 = innerEvaluate(expression);
            start++;
            int e2 = innerEvaluate(expression);
            ans = e1 + e2;
        } else {
            start += 5;//移除mult
            int e1 = innerEvaluate(expression);
            start++;
            int e2 = innerEvaluate(expression);
            ans = e1 * e2;
        }
        start++;
        return ans;
    }

    /*Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();
    int start = 0;

    public int evaluate(String expression) {
        return innerEvaluate(expression);
    }

    public int innerEvaluate(String expression) {
        if (expression.charAt(start) != '(') { // 非表达式，可能为：整数或变量
            if (Character.isLowerCase(expression.charAt(start))) {
                String var = parseVar(expression); // 变量
                return scope.get(var).peek();
            } else { // 整数
                return parseInt(expression);
            }
        }
        int ret;
        start++; // 移除左括号
        if (expression.charAt(start) == 'l') { // "let" 表达式
            start += 4; // 移除 "let "
            List<String> vars = new ArrayList<String>();
            while (true) {
                if (!Character.isLowerCase(expression.charAt(start))) {
                    ret = innerEvaluate(expression); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                String var = parseVar(expression);
                if (expression.charAt(start) == ')') {
                    ret = scope.get(var).peek(); // let 表达式的最后一个 expr 表达式的值
                    break;
                }
                vars.add(var);
                start++; // 移除空格
                int e = innerEvaluate(expression);
                scope.putIfAbsent(var, new ArrayDeque<Integer>());
                scope.get(var).push(e);
                start++; // 移除空格
            }
            for (String var : vars) {
                scope.get(var).pop(); // 清除当前作用域的变量
            }
        } else if (expression.charAt(start) == 'a') { // "add" 表达式
            start += 4; // 移除 "add "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 + e2;
        } else { // "mult" 表达式
            start += 5; // 移除 "mult "
            int e1 = innerEvaluate(expression);
            start++; // 移除空格
            int e2 = innerEvaluate(expression);
            ret = e1 * e2;
        }
        start++; // 移除右括号
        return ret;
    }

    public int parseInt(String expression) { // 解析整数
        int n = expression.length();
        int ret = 0, sign = 1;
        if (expression.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        while (start < n && Character.isDigit(expression.charAt(start))) {
            ret = ret * 10 + (expression.charAt(start) - '0');
            start++;
        }
        return sign * ret;
    }

    public String parseVar(String expression) { // 解析变量
        int n = expression.length();
        StringBuffer ret = new StringBuffer();
        while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
            ret.append(expression.charAt(start));
            start++;
        }
        return ret.toString();
    }*/

}
