package BasicCoding.day_18.code_155;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }

    public void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
