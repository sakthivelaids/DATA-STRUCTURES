
import java.util.*;


class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularQueueLinkedList {
    
    node front = null;
    node rear = null;

    void enque(int data) {
        node newnode = new node(data);

        if (front == null) {
            front = newnode;
            rear = newnode;
            rear.next = front;
        } else {
            rear.next = newnode;
            rear = newnode;
            rear.next = front;
        }
    }

    void deque() {
        if (front == null) {
            System.out.println("Queue is empty...");
            return;
        }

        System.out.println("Dequeued element: " + front.data);
        front = front.next;

        // if queue becomes empty
        if (front == rear) {
            front = null;
            rear = null;
        }else{
            front = front.next;
            rear.next = front;
        }
    }

    void Front() {
        if (front == null) {
            System.out.println("Queue is empty...");
            return;
        }
        System.out.println("Front element: " + front.data);
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty...");
            return;
        }

        node temp = front;
        while (temp.next != front) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CircularQueueLinkedList q = new CircularQueueLinkedList();

        while (true) {
            int c = scan.nextInt();

            if (c == 1) {
                while (true) {
                    int data = scan.nextInt();
                    if (data == -1) break;
                    q.enque(data);
                }
            } else if (c == 2) {
                q.deque();
            } else if (c == 3) {
                q.Front();
            } else if (c == 4) {
                q.display();
            } else {
                break;
            }
        }
    }
}

