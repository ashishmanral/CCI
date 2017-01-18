package Chapter2_LinkedLists;

import Utilities.LLNode;

/**
 * Created by ashis on 1/8/2017.
 */
public class DeleteMiddleNode {

    public void deleteMiddleNode(LLNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
