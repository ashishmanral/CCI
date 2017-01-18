package Chapter2_LinkedLists;

import Utilities.LLNode;

/**
 * Created by ashis on 1/8/2017.
 */
public class Partition {

    public LLNode partition(LLNode head, int x) {

        LLNode leftIter = null;
        LLNode rightIter = null;
        LLNode left = null;
        LLNode right = null;

        while(head != null) {
            LLNode nextNode = head.next;
            if(head.data < x) {
                if(left == null) {
                    left = head;
                    leftIter = head;
                } else {
                    leftIter.next = head;
                    leftIter = head;
                }
            } else {
                if(right == null) {
                    right = head;
                    rightIter = head;
                } else {
                    rightIter.next = head;
                    rightIter = head;
                }
            }
            head = nextNode;
        }

        if(rightIter != null) rightIter.next = null;
        if(leftIter != null) {
            leftIter.next = right;
        }

        return left != null ? left : right;
    }
}
