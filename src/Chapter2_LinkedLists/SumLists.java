package Chapter2_LinkedLists;

import Utilities.LLNode;
import Utilities.MyLinkedList;

/**
 * Created by ashis on 1/8/2017.
 */
public class SumLists {

    public LLNode sumListsReverse(LLNode head1, LLNode head2) {
        LLNode newHead = null;
        LLNode newIter = null;
        int carry = 0;

        while(head1 != null || head2 != null || carry > 0) {
            int data1 = head1 == null ? 0 : head1.data;
            int data2 = head2 == null ? 0 : head2.data;

            int sum = data1 + data2 + carry;
            LLNode newNode = new LLNode(sum % 10);
            if(newHead == null) {
                newHead = newNode;
                newIter = newHead;
            } else {
                newIter.next = newNode;
                newIter = newNode;
            }
            carry = sum / 10;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }

        return newHead;
    }

    private class SumWrapper {
        private LLNode node;
        private int carry;

        private SumWrapper(LLNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }

    public LLNode sumListsForward(LLNode head1, LLNode head2) {

        int length1 = getLengthOfLL(head1);
        int length2 = getLengthOfLL(head2);

        if(length1 != length2) {
            LLNode smallerLLHead = length1 < length2 ? head1 : head2;
            int diff = Math.abs(length1 - length2);
            LLNode diffHead = new LLNode(0);
            LLNode diffIter = diffHead;
            while(diff != 1) {
                diffIter.next = new LLNode(0);
                diffIter = diffIter.next;
                --diff;
            }
            diffIter.next = smallerLLHead;
            head1 = (smallerLLHead == head1 ? diffHead : head1);
            head2 = (smallerLLHead == head2 ? diffHead : head2);
        }

        SumWrapper result = sumListsForwardHelper(head1, head2);
        if(result.carry > 0) {
            LLNode newHead = new LLNode(result.carry);
            newHead.next = result.node;
            return newHead;
        }

        return result.node;
    }

    private int getLengthOfLL(LLNode head) {
        int length = 0;
        while(head != null) {
            ++length;
            head = head.next;
        }

        return length;
    }

    private SumWrapper sumListsForwardHelper(LLNode iter1, LLNode iter2) {
        if(iter1 == null && iter2 == null) {
            return new SumWrapper(null, 0);
        }

        SumWrapper nextNode = sumListsForwardHelper(iter1.next, iter2.next);
        int sum = iter1.data + iter2.data + nextNode.carry;
        LLNode currNode = new LLNode(sum % 10);
        currNode.next = nextNode.node;
        return new SumWrapper(currNode, sum / 10);
    }


}
