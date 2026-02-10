package DATA-STRUCTURES;


class Node {
    int data;
    Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
}
public class CircularLinkedList {


    class LinkedList {
        Node head = null;
        Node temp = null;

        LinkedList(int n) {
            for (int i = 0; i < n; i++) {
                Node newNode = new Node(i);

                if (head == null) {
                    head = newNode;
                    temp = newNode;
                } else {
                    temp.next = newNode;
                    temp = newNode;
                }
            }
            temp.next = head;
        }

        void display() {
        if (head == null) return;

        temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

            if (temp == head) break; 
        }
    }
    }
    public static void main(String[] args) {
        int n = 10;
        LinkedList l = new LinkedList(n);
        l.display();
    }
}