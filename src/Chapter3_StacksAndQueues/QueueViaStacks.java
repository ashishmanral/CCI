package Chapter3_StacksAndQueues;

import java.util.Stack;

/**
 * Created by ashis on 1/9/2017.
 */
public class QueueViaStacks {

    private Stack<Integer> masterStack = new Stack<>();
    private Stack<Integer> buffer = new Stack<>();

    public void enqueue(int data) {
        masterStack.push(data);
    }

    public int dequeue() {
        if(!buffer.isEmpty()) {
            return buffer.pop();
        } else if(masterStack.isEmpty()) {
            System.out.println("Queue is empty!!!");
            return -1;
        }

        while(!masterStack.isEmpty()) {
            buffer.push(masterStack.pop());
        }

        return buffer.pop();
    }
}
