package Chapter3_StacksAndQueues;

import java.util.Stack;

/**
 * Created by ashis on 1/8/2017.
 */
public class StackMin {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> masterStack = new Stack<>();

    public void push(int data) {
        if(data <= min()) {
            minStack.push(data);
        }
        masterStack.push(data);
    }

    public int pop() {
        if(masterStack.isEmpty()) {
            return -1;
        }

        int data = masterStack.pop();
        if(data == minStack.peek()) {
            minStack.pop();
        }

        return data;
    }

    public int peek() {
        if(masterStack.isEmpty()) {
            return -1;
        }

        return masterStack.peek();
    }

    public int min() {
        if(minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }
}
