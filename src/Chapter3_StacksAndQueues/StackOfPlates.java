package Chapter3_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.jar.Pack200;

/**
 * Created by ashis on 1/8/2017.
 */
public class StackOfPlates {

    private int top;
    private int threshold;
    private List<Stack<Integer>> listOfStacks = new ArrayList<>();

    public StackOfPlates(int threshold) {
        this.threshold = threshold;
    }

    public void push(int data) {
        if(top++ % threshold == 0) {
            listOfStacks.add(new Stack<>());
        }

        Stack currStack = listOfStacks.get(listOfStacks.size() - 1);
        currStack.push(data);
    }

    public int peek() {
        if(listOfStacks.isEmpty()) return -1;

        Stack<Integer> currStack = listOfStacks.get(listOfStacks.size() - 1);
        return currStack.peek();
    }

    public int pop() {
        if(listOfStacks.isEmpty()) return -1;

        int lastIndex = listOfStacks.size() - 1;

        Stack<Integer> currStack = listOfStacks.get(lastIndex);
        int data = currStack.pop();

        if(--top % threshold == 0) {
            listOfStacks.remove(lastIndex);
        }

        return data;
    }

    public int popAt(int stackNum) {
        if(listOfStacks.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        if(stackNum < 1 || stackNum > listOfStacks.size()) {
            System.out.println("Enter an index between 1 and " + listOfStacks.size());
            return -1;
        }

        if(stackNum == listOfStacks.size()) {
            return pop();
        }

        int stackIndex = stackNum - 1;

        Stack<Integer> currStack = listOfStacks.get(stackIndex);
        Stack<Integer> nextStack = listOfStacks.get(stackIndex + 1);

        int data = currStack.pop();
        int nextIndex = stackIndex + 1;

        while(nextStack != null) {
            Stack<Integer> tempBuffer = new Stack<>();

            while(!nextStack.isEmpty()) {
                tempBuffer.push(nextStack.pop());
            }

            currStack.push(tempBuffer.pop());

            while(!tempBuffer.isEmpty()) {
                nextStack.push(tempBuffer.pop());
            }

            if(listOfStacks.size() == (nextIndex + 1)) {
                break;
            }

            currStack = nextStack;
            nextStack = listOfStacks.get(++nextIndex);
        }

        --top;

        if(listOfStacks.get(listOfStacks.size() - 1).isEmpty()) {
            listOfStacks.remove(listOfStacks.size() - 1);
        }

        return data;
    }

    public int numStacks() {
        return listOfStacks.size();
    }
}
