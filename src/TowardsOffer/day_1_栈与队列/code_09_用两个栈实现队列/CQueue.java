package TowardsOffer.day_1_栈与队列.code_09_用两个栈实现队列;

import java.util.*;

/**
 * completion time = 2022.11.21
 */
class CQueue {
    private Deque<Integer> input;
    private Deque<Integer> output;

    public CQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        input.push(value);
    }

    public int deleteHead() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                return -1;
            }
            move2output();
        }
        return output.pop();
    }

    void move2output() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }
}