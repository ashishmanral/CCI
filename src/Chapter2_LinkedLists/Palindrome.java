package Chapter2_LinkedLists;

import Utilities.LLNode;

import java.util.Stack;

/**
 * Created by ashis on 1/8/2017.
 */
public class Palindrome {

    public boolean palindromeRecursion(LLNode head) {
        if(head == null) return false;
        return palindromeHelper(head, head).result;
    }

    public boolean palindromeStack(LLNode head) {
        if(head == null) return false;
        LLNode slow = head;
        LLNode fast = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if(slow.data != stack.pop()) return false;
            slow = slow.next;
        }

        return true;
    }

    private class PalindromeWrapper {
        boolean result;
        LLNode compareWith;

        private PalindromeWrapper(boolean result, LLNode compareWith) {
            this.result = result;
            this.compareWith = compareWith;
        }
    }

    private PalindromeWrapper palindromeHelper(LLNode slow, LLNode fast) {
        if(fast == null) return new PalindromeWrapper(true, slow);
        if(fast.next == null) return new PalindromeWrapper(true, slow.next);

        PalindromeWrapper wrapper = palindromeHelper(slow.next, fast.next.next);
        return new PalindromeWrapper(wrapper.result && wrapper.compareWith.data == slow.data, wrapper.compareWith.next);
    }
}
