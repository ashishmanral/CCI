package Chapter2_LinkedLists;

import Utilities.LLNode;
import Utilities.MyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by ashis on 1/8/2017.
 */
public class Tester {

    private boolean testRemoveDups;
    private boolean testKthToLast;
    private boolean testDeleteMiddleNode;
    private boolean testPartition;
    private boolean testSumLists;
    private boolean testPalindrome;
    private boolean testIntersection;
    private boolean testLoopDetection;

    private Tester removeDups() {
        testRemoveDups = true;
        return this;
    }

    private Tester kthToLast() {
        testKthToLast = true;
        return this;
    }

    private Tester deleteMiddleNode() {
        testDeleteMiddleNode = true;
        return this;
    }

    private Tester partition() {
        testPartition = true;
        return this;
    }

    private Tester sumLists() {
        testSumLists = true;
        return this;
    }

    private Tester palindrome() {
        testPalindrome = true;
        return this;
    }

    private Tester intersection() {
        testIntersection = true;
        return this;
    }

    private Tester loopDetection() {
        testLoopDetection = true;
        return this;
    }

    private void beginTest() {
        if(testRemoveDups) runRemoveDups();
        if(testKthToLast) runKthToLast();
        if(testDeleteMiddleNode) runDeleteMiddleNode();
        if(testPartition) runPartition();
        if(testSumLists) runSumLists();
        if(testPalindrome) runPalindrome();
        if(testIntersection) runIntersection();
        if(testLoopDetection) runLoopDetection();
    }

    private void runRemoveDups() {
        System.out.println("Testing RemoveDups");
        RemoveDups testClass = new RemoveDups();
        int length = 10;
        int range = 5;
        for(int i = 0; i < 5; ++i) {
            MyLinkedList testLL = createDuplicatedLL(length, range);
            System.out.println("Input LL : ");
            testLL.display();
            System.out.println("Output LL with storage : ");
            LLNode outputHead1 = testClass.removeDuplicate(testLL.head);
            MyLinkedList.display(outputHead1);
            System.out.println("Output LL without storage : ");
            LLNode outputHead2 = testClass.removeDuplicateWithoutStorage(testLL.head);
            MyLinkedList.display(outputHead2);
        }
        System.out.println();
    }

    private void runKthToLast() {
        System.out.println("Testing KthToLast");
        KthToLast testClass = new KthToLast();
        int length = 10;
        for(int i = 0; i < 5; ++i) {
            int k = (int) (Math.random() * length);
            MyLinkedList testLL = createUniqueLL(length);
            System.out.println("Input LL : ");
            testLL.display();
            System.out.println(k + "th to last element is : " + testClass.kthToLast(testLL.head, k));
        }
        System.out.println();
    }

    private void runDeleteMiddleNode() {
        System.out.println("Testing DeleteMiddleNode");
        DeleteMiddleNode testClass = new DeleteMiddleNode();
        int length = 10;
        for(int i = 0; i < 5; ++i) {
            MyLinkedList testLL = createUniqueLL(length);
            LLNode testNode = getLLNode(testLL.head, (int) (Math.random() * (length - 2)) + 1);
            System.out.println("Input LL : ");
            testLL.display();
            System.out.println("LL after removing " + testNode.data + " is : ");
            testClass.deleteMiddleNode(testNode);
            testLL.display();
        }
        System.out.println();
    }

    private void runPartition() {
        System.out.println("Testing Partition");
        Partition testClass = new Partition();
        int length = 20;
        int range = 10;
        for(int i = 0; i < 5; ++i) {
            MyLinkedList testLL = createDuplicatedLL(length, range);
            int x = (int)(Math.random() * range) + 1;
            System.out.println("Input LL : ");
            testLL.display();
            System.out.println("LL after partitioning on " + x + " is : ");
            LLNode newHead = testClass.partition(testLL.head, x);
            MyLinkedList.display(newHead);
        }
        System.out.println();
    }

    private void runSumLists() {
        System.out.println("Testing SumLists");
        SumLists testClass = new SumLists();
        int maxLength = 10;
        int range = 9;
        for(int i = 0; i < 5; ++i) {
            int length1 = (int) (Math.random() * (maxLength + 1));
            int length2 = (int) (Math.random() * (maxLength + 1));
            MyLinkedList testLL1 = createDuplicatedLL(length1, range);
            MyLinkedList testLL2 = createDuplicatedLL(length2, range);
            System.out.println("Calculating sum for reversed LL :");
            LLNode newHeadReverse = testClass.sumListsReverse(testLL1.head, testLL2.head);
            printSum(testLL1, testLL2, newHeadReverse);
            System.out.println("Calculating sum for forward LL :");
            LLNode newHeadForward = testClass.sumListsForward(testLL1.head, testLL2.head);
            printSum(testLL1, testLL2, newHeadForward);
        }
        System.out.println();
    }

    private void runPalindrome() {
        System.out.println("Testing Palindrome");
        Palindrome testClass = new Palindrome();
        int length = 10;
        int range = 9;
        for(int i = 0; i < 10; ++i) {
            int random = (int)(Math.random() * 2);
            MyLinkedList testLL = random == 0 ? generatePalindromeLL(length, range) : createDuplicatedLL(length, range);
            System.out.println("Input LL :");
            testLL.display();
            System.out.println("Recursion says LL is " + (testClass.palindromeRecursion(testLL.head) ? "" : "not ") + "a palindrome");
            System.out.println("Iteration says LL is " + (testClass.palindromeStack(testLL.head) ? "" : "not ") + "a palindrome");
        }
        System.out.println();
    }

    private void runIntersection() {
        System.out.println("Testing Intersection");
        Intersection testClass = new Intersection();
        int length = 15;
        for(int i = 0; i < 10; ++i) {
            int random = (int)(Math.random() * 2);
            MyLinkedList testLL1 = createUniqueLL(length);
            System.out.print("LL1 is : ");
            testLL1.display();
            MyLinkedList testLL2 = (random == 0 ? createUniqueLL(length) : createIntersectingList(testLL1, length));
            System.out.print("LL2 is : ");
            testLL2.display();
            System.out.println("Intersecting Node is " + testClass.intersection(testLL1.head, testLL2.head));
        }
        System.out.println();
    }

    private void runLoopDetection() {
        System.out.println("Testing LoopDetection");
        LoopDetection testClass = new LoopDetection();
        int length = 10;
        for(int i = 0; i < 10; ++i) {
            MyLinkedList testLL = createCircularLL(length);
            System.out.println("Circular Node is " + testClass.loopDetection(testLL.head).data);
        }
        System.out.println();
    }

    private MyLinkedList generatePalindromeLL(int length, int range) {

        boolean isEven = length % 2 == 0;
        int middle = length / 2;

        Stack<Integer> stack = new Stack<>();
        MyLinkedList myLL = new MyLinkedList();

        for(int i = 0; i < middle; ++i) {
            int random = (int)((Math.random() * range) + 1);
            stack.push(random);
            myLL.addLast(random);
        }

        if(!isEven) {
            myLL.addLast((int)((Math.random() * range) + 1));
        }

        while(!stack.isEmpty()) {
            myLL.addLast(stack.pop());
        }

        return myLL;
    }

    private MyLinkedList createDuplicatedLL(int length, int range) {
        MyLinkedList myLL = new MyLinkedList();
        for(int i = 0; i < length; ++i) {
            myLL.addLast((int)(Math.random() * range) + 1);
        }

        return myLL;
    }

    private MyLinkedList createUniqueLL(int length) {
        List<Integer> uniqNums = new ArrayList<>();

        for(int i = 1; i <= length; ++i) {
            uniqNums.add(i);
        }

        Collections.shuffle(uniqNums);

        MyLinkedList myLL = new MyLinkedList();
        for(int num : uniqNums) {
            myLL.addLast(num);
        }

        return myLL;
    }

    private MyLinkedList createCircularLL(int length) {
        MyLinkedList uniqueLL = createUniqueLL(length);
        int random = (int)(Math.random() * (length - 2));

        LLNode circularNode = uniqueLL.head;
        for(int i = 0; i < random; ++i) {
            circularNode = circularNode.next;
        }

        System.out.print("Circular Node is set to " + circularNode.data + " in input LL : ");
        uniqueLL.display();

        LLNode lastNode = uniqueLL.head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = circularNode;

        return uniqueLL;
    }

    private MyLinkedList createIntersectingList(MyLinkedList myLL, int length) {
        int prefixLength = (int)(Math.random() * length) + 1;
        int intersectDis = (int)(Math.random() * length);

        MyLinkedList myNewLL = new MyLinkedList();

        for(int i = 0; i < prefixLength; ++i) {
            myNewLL.addLast(100+i);
        }

        LLNode newIter = myNewLL.head;
        while(newIter.next != null) {
            newIter = newIter.next;
        }

        LLNode oldIter = myLL.head;
        for(int i = 0; i < intersectDis; ++i) {
            oldIter = oldIter.next;
        }

        newIter.next = oldIter;

        return myNewLL;
    }

    private LLNode getLLNode(LLNode head, int pos) {
        for(int i = 0; i < pos; ++i) {
            head = head.next;
        }
        return head;
    }

    private void printSum(MyLinkedList list1, MyLinkedList list2, LLNode result) {
        System.out.print("One : ");
        list1.display();
        System.out.print("Two : ");
        list2.display();
        System.out.print("Sum : ");
        MyLinkedList.display(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean quit;

        do {
            System.out.println("Chapter 2 - Linked Lists");
            System.out.println("1. RemoveDups");
            System.out.println("2. KthToLast");
            System.out.println("3. DeleteMiddleNode");
            System.out.println("4. Partition");
            System.out.println("5. SumLists");
            System.out.println("6. Palindrome");
            System.out.println("7. Intersection");
            System.out.println("8. LoopDetection");
            System.out.println("9. ALL");
            System.out.print("Enter Number : ");
            int num = Integer.parseInt(br.readLine());
            System.out.println();

            switch(num) {
                case 1 : new Chapter2_LinkedLists.Tester().removeDups().beginTest();
                    break;
                case 2 : new Chapter2_LinkedLists.Tester().kthToLast().beginTest();
                    break;
                case 3 : new Chapter2_LinkedLists.Tester().deleteMiddleNode().beginTest();
                    break;
                case 4 : new Chapter2_LinkedLists.Tester().partition().beginTest();
                    break;
                case 5 : new Chapter2_LinkedLists.Tester().sumLists().beginTest();
                    break;
                case 6 : new Chapter2_LinkedLists.Tester().palindrome().beginTest();
                    break;
                case 7 : new Chapter2_LinkedLists.Tester().intersection().beginTest();
                    break;
                case 8 : new Chapter2_LinkedLists.Tester().loopDetection().beginTest();
                    break;
                case 9 : new Chapter2_LinkedLists.Tester().removeDups().kthToLast().deleteMiddleNode().partition().sumLists().palindrome().intersection().loopDetection().beginTest();
                    break;
                default : System.out.println("You have to enter between 1-5");
            }
            System.out.print("Main Menu? (y/n) ");
            String answer = br.readLine();
            System.out.println();
            quit = !"y".equals(answer);
        } while(!quit);

    }

}
