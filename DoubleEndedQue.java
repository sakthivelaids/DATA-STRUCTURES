import java.util.*;    

public class DoubleEndedQue {
    int size;
    int que[];
    int front;
    int rear;

    DoubleEndedQue(int size) {
        this.size = size;
        que = new int[size];
        front = -1;
        rear = -1;
    }
    void enqueFront(int data) {
        
        if(front == -1) {
            front = 0;
            rear = 0;
            que[front] = data;
        }else if(front == 0) {
            front = size-1;
            que[front] = data;
        }else{
            front--;
            que[front] = data;
        }
    }
    void enqueRear(int data) {
        if(rear == -1) {
            front = 0;
            rear = 0;
            que[rear] = data;
        }else if(rear == size -1) {
            rear = 0;
            que[rear] = data;
        }else{
            rear++;
            que[rear] = data;
        }
    }

    void deleteFront(){
        if(front == -1) {
            System.out.println("que is Empty...");
        }
        if(front == rear) {
            front = -1;
            rear = -1;
        }else if(front == size -1) {
            front = 0;
        }else{
            front++;
        }
    }
    void deleteRear() {
        if(rear == -1) {
            System.out.println("que is empty...");
        }
        if(front == rear) {
            front = -1;
            rear = -1;
        }else if(rear == 0) {
            rear = size - 1;
        }else{
            rear--;
        }
    }
    void getFront() {
        System.out.println(que[front]);
    }
    void getRear() {
        System.out.println(que[rear]);
    }
    void display() {
        if(front == -1) {
            System.out.println("que is empty...");
            return;
        }
            
        int i = front;
        while(true) {
            System.out.println(que[i]);
            if(i == rear) {
                break;
            }
            i = (i+1)%size;
                
        }
    }
    
    public static void main(String[] args) {
        DoubleEndedQue dq = new DoubleEndedQue(5);

        dq.enqueFront(10);
        dq.enqueFront(5);
        dq.enqueFront(20);

        dq.enqueRear(30);
        dq.enqueRear(50);

        dq.display();
    }
}
