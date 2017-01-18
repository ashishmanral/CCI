package Chapter3_StacksAndQueues;

import java.util.Stack;

/**
 * Created by ashis on 1/9/2017.
 */
public class SortStack extends Stack<Integer> {

    private Stack<Integer> sortedStack = new Stack<>();

    public Stack<Integer> sort() {
        while(!this.isEmpty()) {
            int temp = this.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek() < temp) {
                this.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        return sortedStack;
    }

    public static void display(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while(!stack.isEmpty()) {
            temp.push(stack.pop());
            System.out.print(temp.peek() + " ");
        }
        System.out.println();

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public void display() {
        display(this);
    }

}
