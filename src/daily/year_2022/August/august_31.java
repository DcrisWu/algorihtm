package daily.year_2022.August;

import java.util.Stack;

public class august_31 {
    public static void main(String[] args) {
        //[1,2,3,4,5]
        //[4,5,3,2,1]
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        System.out.println(validateStackSequences(pushed, popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        //i表示pushed[]的下标,j表示popped[]的下标
        int i = 1, j = 0;
        stack.push(pushed[0]);
        while (i < pushed.length || j < popped.length) {
            if(stack.empty() && i < pushed.length){
                stack.push(pushed[i++]);
            }else{
                int peek = stack.peek();
                if (peek == popped[j] && j < popped.length) {
                    stack.pop();
                    j++;
                } else if (i < pushed.length) {
                    stack.push(pushed[i++]);
                }else {
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
