import java.util.*;

public class SinglyLinkedListInsert {
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

    public static void main(String[] args) {
        SinglyLinkedListInsert sll = new SinglyLinkedListInsert();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        // Display the list before insertion
        System.out.println("Original list:");
        sll.display();

        // Insert a new element at the beginning
        sll.insertFirst(2);

        // Display the list after insertion
        System.out.println("List after inserting 2 at the beginning:");
        sll.display();
    }
}

