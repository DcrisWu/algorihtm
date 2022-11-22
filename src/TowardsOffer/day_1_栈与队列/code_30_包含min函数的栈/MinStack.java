package TowardsOffer.day_1_栈与队列.code_30_包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * completion time = 2022.11.21
 */
class MinStack {

    private Deque<Integer> stack;
    private PriorityQueue<Integer> queue;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return queue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}
