import java.util.Scanner;

public class CircularQueueArray {
    int size;
    int que[];
    int front;
    int rear;

    CircularQueueArray(int size) {
        this.size = size;
        que = new int[size];
        front = -1;
        rear = -1;
    }

    void enque(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue Full...");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            que[rear] = data;
        } else {
            rear = (rear + 1) % size;
            que[rear] = data;
        }
    }

    void deque() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }

        System.out.println("Deque element: " + que[front]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void Front() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }
        System.out.println("Front element: " + que[front]);
    }

    void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }

        // int i = front;
        while (true) {
            System.out.println(que[front]);
            if (front == rear)
                break;
            front = (front + 1) % size;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        CircularQueueArray q = new CircularQueueArray(size);

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
                System.out.println("EXIT...");
                break;
            }
        }
    }
}
