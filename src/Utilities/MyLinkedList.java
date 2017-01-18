package Utilities;

/**
 * Created by ashis on 1/8/2017.
 */
public class MyLinkedList {

    public LLNode head;

    public void addLast(int data) {
        LLNode newNode = new LLNode(data);

        if(head == null) {
            head = newNode;
        } else {
            LLNode iter = head;
            while(iter.next != null) {
                iter = iter.next;
            }
            iter.next = newNode;
        }
    }

    public void addFirst(int data) {
        LLNode newNode = new LLNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void display() {
        if(head == null) {
            System.out.println("LinkedList is empty!!!");
        } else {
            LLNode iter = head;
            while(iter.next != null) {
                System.out.print(iter.data + " -> ");
                iter = iter.next;
            }
            System.out.print(iter.data);
            System.out.println();
        }
    }

    public static void display(LLNode start) {
        if(start == null) {
            System.out.println("Node is empty!!!");
        } else {
            LLNode iter = start;
            while(iter.next != null) {
                System.out.print(iter.data + " -> ");
                iter = iter.next;
            }
            System.out.print(iter.data);
            System.out.println();
        }
    }

}
