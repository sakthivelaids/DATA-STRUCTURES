package DATA-STRUCTURES;

class node {
    int data;
    node next;
    node prev;

    node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    node head = null;
    node tail = null;

    LinkedList(int n) {
        for (int i = 1; i <= n; i++) {
            node newnode = new node(i);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
            }
        }
    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("=======");
        // temp = tail;
        // while (temp != null) {
        //     System.out.print(temp.data + " ");
        //     temp = temp.prev;
        // }
        // System.out.println();
    }

    void insertAtFront(int data) {
        node newnode = new node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    void insertAtEnd(int data) {
        node newnode = new node(data);
        if (tail == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    void insertAtMid(int pos, int data) {
        if (pos <= 0) {
            insertAtFront(data);
            return;
        }

        node newnode = new node(data);
        node temp = head;
        int count = 0;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertAtEnd(data);
        } else {
            newnode.next = temp.next;
            newnode.prev = temp;
            temp.next.prev = newnode;
            temp.next = newnode;
        }
    }   
    void deleteFront() {
        if (head == tail) { 
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteAtEnd() {
        if(head == tail) {
            head = null;
            tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    void deleteAtMid(int pos) {
        node temp = head;
        for(int i = 1;i < pos;i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next = temp.prev;
    }

}

public class DoublyLinkedList {
    public static void main(String[] args) {
        
        LinkedList l = new LinkedList(5);
        l.display();

        // System.out.println("\nInsert at front:");
        // l.insertAtFront(99);
        // l.display();

        // System.out.println("\nInsert at end:");
        // l.insertAtEnd(77);
        // l.display();

        // System.out.println("\nInsert at mid:");
        // l.insertAtMid(3, 55);
        // l.display();
        System.out.println("--------");
        // l.deleteFront();
        // l.deleteAtEnd();
        l.deleteAtMid(3);
        l.display();
    }
}