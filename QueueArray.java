import java.util.*;

class Queue {
    int size;
    int que[];
    int front;
    int rear;

    Queue(int size) {
        this.size = size;
        que = new int[size];
        front = -1;
        rear = -1;
    }

    void enque(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full...");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            que[rear] = data;
        } else {
            rear++;
            que[rear] = data;
        }
    }

    void deque() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }

        System.out.println(que[front]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
    }

    void Front() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }
        System.out.println(que[front]);
    }

    void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty...");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println(que[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        Queue q = new Queue(size);

        while (true) {
            int c = scan.nextInt();

            if (c == 1) {
                for (int i = 0; i < size; i++) {
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
