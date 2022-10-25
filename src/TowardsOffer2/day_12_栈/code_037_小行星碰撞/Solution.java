package TowardsOffer2.day_12_栈.code_037_小行星碰撞;

import java.util.Stack;

/**
 * completion time = 2022.10.23
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
//        stack.add(asteroids[0]);
        for (int i = 0; i < asteroids.length; i++) {
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            Integer peek = stack.peek();
            if((peek*asteroids[i] > 0) || (peek < 0 && asteroids[i] > 0)){
                stack.push(asteroids[i]);
            }else {
                boolean judge = false;
                while (peek > 0){
                    if(peek < asteroids[i]*(-1)){
                        stack.pop();
                        if(!stack.isEmpty()){
                            peek = stack.peek();
                        }else {
                            stack.push(asteroids[i]);
                            judge = true;
                            break;
                        }
                    }else if(peek == asteroids[i]*(-1)){
                        stack.pop();
                        judge = true;
                        break;
                    }else {
                        judge = true;
                        break;
                    }
                }
                if(!judge){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-2,1,-2};
        Solution solution = new Solution();
        int[] ints = solution.asteroidCollision(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
