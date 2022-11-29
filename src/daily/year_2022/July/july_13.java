package daily.year_2022.July;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class july_13 {
    public static int[] asteroidCollision(int[] asteroids) {
        //如果没有行星直接返回空数组
        if (asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> ans = new Stack<>();
        //使用栈存储数组里第一个行星
        ans.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            //如果该行星与ans的的头行星符号相同，表示是同一方向的，则直接压栈
            if (ans.empty() || (asteroids[i] > 0 && ans.peek() > 0) || (asteroids[i] < 0 && ans.peek() < 0)) {
                ans.push(asteroids[i]);
                continue;
            }
            //boom表示当前行星是否已经爆炸了
            boolean boom = false;
            //如果ans的行星不为空 && 该行星与栈顶的行星方向不一样，则发生碰撞，直到所有行星的方向都相同
            while (!ans.empty() && asteroids[i] <= ans.peek() && asteroids[i]*ans.peek() < 0) {
                //如果该行星的质量大于ans里的第一个行星
                if (Math.abs(asteroids[i]) > Math.abs(ans.peek())) {
                    //ans里的行星将被摧毁
                    ans.pop();
                } else if(Math.abs(asteroids[i]) == Math.abs(ans.peek())){
                    //ans里的行星将被摧毁
                    ans.pop();
                    boom = true;
                    break;
                }else {
                    //如果该行星的质量小于ans里的第一个行星，则该行星直接爆炸
                    boom = true;
                    break;
                }
            }
            //如果这个行星没有爆炸，则它就是剩下的唯一行星
            if (!boom) {
                ans.push(asteroids[i]);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = ans.size() - 1; i >= 0; i--) {
            res[i] = ans.pop();
        }
        return res;
    }

    public static int[] asteroidCollision2(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-2, -1, 1, 2};
        for (int i : asteroidCollision(arr)) {
            System.out.println(i);
        }
    }
}
