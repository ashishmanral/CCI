package Utilities;

/**
 * Created by ashis on 1/8/2017.
 */
public class LLNode {

    public int data;
    public LLNode next;

    public LLNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
