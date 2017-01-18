package Chapter3_StacksAndQueues;

/**
 * Created by ashis on 1/8/2017.
 */
public class ThreeInOne {

    int[] masterArr;
    int[] start = new int[3];
    int[] end = new int[3];
    int[] top = new int[3];

    public ThreeInOne(int size) {
        masterArr = new int[size];
        int step = size / 3;
        for(int i = 0; i < 3; ++i) {
            start[i] = i * step;
            top[i] = start[i] - 1;
            end[i] = ((i + 1) * step) - 1;
        }
    }

    public void push(int stackNum, int data) {
        if(stackNum < 1 || stackNum > 3) {
            System.out.println("Enter valid stack number between 1-3");
            return;
        }

        int stackIndex = stackNum - 1;

        if(top[stackIndex] == end[stackIndex]) {
            System.out.println("Stack " + stackNum + " is full!!!");
            return;
        }

        masterArr[++top[stackIndex]] = data;
    }

    public int peek(int stackNum) {
        if(stackNum < 1 || stackNum > 3) {
            System.out.println("Enter valid stack number between 1-3");
            return -1;
        }

        int stackIndex = stackNum - 1;

        if(top[stackIndex] < start[stackIndex]) {
            System.out.println("Stack " + stackNum + " is empty!!!");
            return -1;
        }

        return masterArr[top[stackIndex]];
    }

    public int pop(int stackNum) {
        if(stackNum < 1 || stackNum > 3) {
            System.out.println("Enter valid stack number between 1-3");
            return -1;
        }

        int stackIndex = stackNum - 1;

        if(top[stackIndex] < start[stackIndex]) {
            System.out.println("Stack " + stackNum + " is empty!!!");
            return -1;
        }

        return masterArr[top[stackIndex]--];
    }

}
