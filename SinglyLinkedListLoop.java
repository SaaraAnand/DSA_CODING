import java.util.*;

public class SinglyLinkedListLoop {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedListLoop sll = new SinglyLinkedListLoop();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        // Display the list before loop creation
        System.out.println("Original list:");
        sll.display();

        // Check for loop (should be false)
        System.out.println("Contains loop: " + sll.containsLoop());

        // Create a loop for testing
        fourth.next = second;

        // Check for loop (should be true)
        System.out.println("Contains loop after creating a loop: " + sll.containsLoop());
    }
}


