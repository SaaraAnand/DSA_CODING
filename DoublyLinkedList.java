import java.util.*;

public class DoublyLinkedList {
    private ListNode head;

    public static class ListNode {
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.previous = null;
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

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        dll.head.next = second;
        second.previous = dll.head;
        second.next = third;
        third.previous = second;
        third.next = fourth;
        fourth.previous = third;

        // Display the list
        System.out.println("Original list:");
        dll.display();
    }
}
