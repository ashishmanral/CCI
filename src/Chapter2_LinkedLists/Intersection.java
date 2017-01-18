package Chapter2_LinkedLists;

import Utilities.LLNode;

/**
 * Created by ashis on 1/8/2017.
 */
public class Intersection {

    public LLNode intersection(LLNode head1, LLNode head2) {
        int length1 = 1;
        int length2 = 1;

        LLNode iter1 = head1;
        LLNode iter2 = head2;

        while(iter1.next != null) {
            iter1 = iter1.next;
            ++length1;
        }

        while(iter2.next != null) {
            iter2 = iter2.next;
            ++length2;
        }

        if(iter1 != iter2) return null;

        int diff = Math.abs(length1 - length2);

        iter1 = head1;
        iter2 = head2;
        if(diff > 0) {
            LLNode longerIter = length1 > length2 ? head1 : head2;
            while(diff > 0) {
                longerIter = longerIter.next;
                --diff;
            }
            iter1 = longerIter;
            iter2 = length1 > length2 ? head2 : head1;
        }

        while(iter1 != iter2) {
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        return iter1;
    }
}
