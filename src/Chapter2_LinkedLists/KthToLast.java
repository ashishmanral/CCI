package Chapter2_LinkedLists;

import Utilities.LLNode;

/**
 * Created by ashis on 1/8/2017.
 */
public class KthToLast {

    public Integer kthToLast(LLNode head, int k) {
        if(head == null) return null;

        LLNode slow = head;
        LLNode fast = head;

        for(int i = 0; i < k; ++i) {
            if(fast == null) return null;
            fast = fast.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }
}
