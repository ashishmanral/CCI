package Chapter2_LinkedLists;

import Utilities.LLNode;

/**
 * Created by ashis on 1/8/2017.
 */
public class LoopDetection {

    public LLNode loopDetection(LLNode head) {
        LLNode slow = head;
        LLNode fast = slow;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
