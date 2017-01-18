package Chapter2_LinkedLists;

import Utilities.LLNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashis on 1/8/2017.
 */
public class RemoveDups {

    public LLNode removeDuplicate(LLNode head) {
        if(head == null || head.next == null) return head;

        Set<Integer> lookup = new HashSet<>();
        lookup.add(head.data);

        LLNode prev = head;
        LLNode curr = head.next;
        while(curr != null) {
            if(lookup.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                lookup.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

    public LLNode removeDuplicateWithoutStorage(LLNode head) {
        if(head == null || head.next == null) return head;

        LLNode iter = head;

        while(iter.next != null) {
            int search = iter.data;
            LLNode prev = iter;
            LLNode curr = iter.next;

            while(curr != null) {
                if(curr.data == search) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }

            iter = iter.next;
        }

        return head;
    }
}
