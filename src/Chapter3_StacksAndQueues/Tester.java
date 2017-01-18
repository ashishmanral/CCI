package Chapter3_StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by ashis on 1/8/2017.
 */
public class Tester {

    private boolean testThreeInOne;
    private boolean testStackMin;
    private boolean testStackOfPlates;
    private boolean testQueueViaStacks;
    private boolean testSortStack;
    private boolean testAnimalShelter;

    private Tester threeInOne() {
        testThreeInOne = true;
        return this;
    }

    private Tester stackMin() {
        testStackMin = true;
        return this;
    }

    private Tester stackOfPlates() {
        testStackOfPlates = true;
        return this;
    }

    private Tester queueViaStacks() {
        testQueueViaStacks = true;
        return this;
    }

    private Tester sortStack() {
        testSortStack = true;
        return this;
    }

    private Tester animalShelter() {
        testAnimalShelter = true;
        return this;
    }

    private void beginTest() {
        if(testThreeInOne) runThreeInOne();
        if(testStackMin) runStackMin();
        if(testStackOfPlates) runStackOfPlates();
        if(testQueueViaStacks) runQueueViaStacks();
        if(testSortStack) runSortStack();
        if(testAnimalShelter) runAnimalShelter();
    }

    private void runThreeInOne() {
        System.out.println("Testing ThreeInOne");
        ThreeInOne testClass = new ThreeInOne(30);
        for(int i = 0; i < 50; ++i) {
            int random = (int)(Math.random() * 10);
            if(random < 6) {
                int r = (int)(Math.random() * 10) + 1;
                int s = (int)(Math.random() * 3) + 1;
                System.out.println("Pushing " +  r + " to stack " + s);
                testClass.push(s, r);
            } else if(random < 8) {
                int s = (int)(Math.random() * 3) + 1;
                System.out.println("Peeking from stack " + s + " : " + testClass.peek(s));
            } else {
                int s = (int)(Math.random() * 3) + 1;
                System.out.println("Popping from stack " + s + " : " + testClass.pop(s));
            }
        }
        System.out.println();
    }

    private void runStackMin() {
        System.out.println("Testing StackMin");
        StackMin testClass = new StackMin();
        for(int i = 0; i < 50; ++i) {
            int random = (int)(Math.random() * 10);
            if(random < 6) {
                int r = (int)(Math.random() * 10) + 1;
                System.out.println("Pushing " +  r + " to stack ");
                testClass.push(r);
            } else if(random < 8) {
                System.out.println("Min from stack : " + testClass.min());
            } else {
                System.out.println("Popping from stack : " + testClass.pop());
            }
        }
        System.out.println();
    }

    private void runStackOfPlates() {
        System.out.println("Testing StackOfPlates");
        StackOfPlates testClass = new StackOfPlates(3);
        for(int i = 0; i < 50; ++i) {
            int random = (int)(Math.random() * 10);
            if(random < 4) {
                int r = (int)(Math.random() * 10) + 1;
                System.out.println("Pushing " +  r + " to stack ");
                testClass.push(r);
            } else if(random < 6) {
                System.out.println("Peeking from stack : " + testClass.peek());
            } else {
                int s = (int)(Math.random() * testClass.numStacks()) + 1;
                System.out.println("Popping from stack " + s + " : " + testClass.popAt(s));
            }
        }
        System.out.println();
    }

    private void runQueueViaStacks() {
        System.out.println("Testing QueueViaStacks");
        QueueViaStacks testClass = new QueueViaStacks();
        for(int i = 0; i < 50; ++i) {
            int random = (int)(Math.random() * 10);
            if(random < 5) {
                int r = (int)(Math.random() * 10) + 1;
                System.out.println("Enquing " +  r);
                testClass.enqueue(r);
            } else {
                System.out.println("Dequing  : " + testClass.dequeue());
            }
        }
        System.out.println();
    }

    private void runSortStack() {
        System.out.println("Testing SortStack");
        SortStack testClass = new SortStack();
        int range = 10;
        int numElements = 20;
        for(int i = 0; i < numElements; ++i) {
            int random = (int)(Math.random() * range);
            testClass.push(random);
        }
        System.out.println("Elements in the stack : ");
        testClass.display();
        System.out.println("Sorted stack : ");
        Stack<Integer> sorted = testClass.sort();
        SortStack.display(sorted);
        System.out.println();
    }

    private void runAnimalShelter() {
        System.out.println("Testing AnimalShelter");
        AnimalShelter testClass = new AnimalShelter();
        String catPre = "Cat";
        int catCount = 0;
        String dogPre = "Dog";
        int dogCount = 0;
        for(int i = 0; i < 20; ++i) {
            int random = (int)(Math.random() * 2);
            Animal a = random == 0 ? new Cat(catPre + (++catCount)) : new Dog(dogPre + (++dogCount));
            System.out.println("Enquing " + a);
            testClass.enqueue(a);
        }
        for(int i = 0; i < 20; ++i) {
            int random = (int)(Math.random() * 3);
            if(random == 0) {
                System.out.println("Dequing Cat " + testClass.dequeueCat());
            } else if(random == 1) {
                System.out.println("Dequing Dog " + testClass.dequeueDog());
            } else {
                System.out.println("Dequing Any " + testClass.dequeueAny());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit;

        do {
            System.out.println("Chapter 3 - Stacks and Queues");
            System.out.println("1. ThreeInOne");
            System.out.println("2. StackMin");
            System.out.println("3. StackOfPlates");
            System.out.println("4. QueueViaStacks");
            System.out.println("5. SortStack");
            System.out.println("6. AnimalShelter");
            System.out.println("7. ALL");
            System.out.print("Enter Number : ");
            int num = Integer.parseInt(br.readLine());
            System.out.println();

            switch(num) {
                case 1 : new Tester().threeInOne().beginTest();
                    break;
                case 2 : new Tester().stackMin().beginTest();
                    break;
                case 3 : new Tester().stackOfPlates().beginTest();
                    break;
                case 4 : new Tester().queueViaStacks().beginTest();
                    break;
                case 5 : new Tester().sortStack().beginTest();
                    break;
                case 6 : new Tester().animalShelter().beginTest();
                    break;
                case 7 : new Tester().threeInOne().stackMin().stackOfPlates().queueViaStacks().sortStack().animalShelter().beginTest();
                    break;
                default : System.out.println("You have to enter between 1-7");
            }
            System.out.print("Main Menu? (y/n) ");
            String answer = br.readLine();
            System.out.println();
            quit = !"y".equals(answer);
        } while(!quit);

    }
}
