import java.util.Scanner;

public class DoubleEndedQueue {
    int size;
    int[] queue;
    int front, rear;

    public DoubleEndedQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueueRear(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = data;
        } else {
            rear = (rear + 1) % size;
            queue[rear] = data;
        }
    }

    public void enqueueFront(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[front] = data;
        } else {
            front = (front - 1 + size) % size;
            queue[front] = data;
        }
    }

    public void dequeueFront() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println("The deleted element: " + queue[front]);
            front = rear = -1;
        } else {
            System.out.println("The deleted element: " + queue[front]);
            front = (front + 1) % size;
        }
    }

    public void dequeueRear() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println("The deleted element: " + queue[rear]);
            front = rear = -1;
        } else {
            System.out.println("The deleted element: " + queue[rear]);
            rear = (rear - 1 + size) % size;
        }
    }

    public void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        int temp = front;
       System.out.print("The queue elements are: ");
        while (temp != rear) {
            System.out.print(queue[temp] + " ");
            temp = (temp + 1) % size;
        }
        System.out.println(queue[temp]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //  System.out.print("Enter the size: ");
        int s = sc.nextInt();
        DoubleEndedQueue obj = new DoubleEndedQueue(s);

        while (true) {
           // System.out.println("\n1. Enqueue Rear\n2. Enqueue Front\n3. Dequeue Front\n4. Dequeue Rear\n5. Display\n6. Exit");
         //   System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                 //   System.out.print("Enter the data: ");
                    obj.enqueueRear(sc.nextInt());
                    break;
                case 2:
                   // System.out.print("Enter the data: ");
                    obj.enqueueFront(sc.nextInt());
                    break;
                case 3:
                    obj.dequeueFront();
                    break;
                case 4:
                    obj.dequeueRear();
                    break;
                case 5:
                    obj.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
