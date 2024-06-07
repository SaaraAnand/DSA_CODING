import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // Polling elements from the queue
        System.out.println("Polled: " + queue.poll()); // Outputs 10
        System.out.println("Polled: " + queue.poll()); // Outputs 20

        // Peeking at the front element
        System.out.println("Peek: " + queue.peek()); // Outputs 30 (does not remove it)

        // Checking if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Outputs false

        // Polling the last element
        System.out.println("Polled: " + queue.poll()); // Outputs 30
        System.out.println("Is queue empty? " + queue.isEmpty()); // Outputs true
    }
}
