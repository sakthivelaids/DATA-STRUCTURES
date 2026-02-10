package DATA-STRUCTURES;

public class SinglyLinkedList {
    
}

// Online Java Compiler
// Use this editor to write, compile and run your Java code online


class node{
    int data;
    node next;
    node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    node head = null;
    node temp = null;
    LinkedList(int n) {
        for(int i = 1;i <= n;i++){
            node newnode = new node(i);
            
            if(head == null) {
                head = newnode;
                temp = newnode;
            } else {
                temp.next = newnode;
                temp = newnode;
            }
        }

    }
    void display() {
        temp = head;
        while(temp != null) {
            System.out.println( temp.data+ " ");
            temp = temp.next;
        }
    }
    void insertFront(int s) {
        node newnode = new node(s);
        newnode.next = head;
        head = newnode;
    }
    void insertEnd(int s) {
        node newnode = new node(s);
        node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = newnode;
    }
    void insertMiddle(int data,int pos) {
        node newnode = new node(data);
        if(pos == 1){
            insertFront(data);
            return;
        }
        
        node temp = head;
        for(int i= 1;i <= pos- 1;i++) {
            if(temp == null) {
                return;
            }
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    void deleteFront() {
        temp = head;
        
        if(head == null) {
            return;
        }else {
            temp = null;
            head = head.next;
        }
    }
    void deleteEnd(){
        temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    public void deletePos(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        current.next = current.next.next;
    }

}
class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        LinkedList list = new LinkedList(n);
        LinkedList list1 = new LinkedList(m);
        
        // merge(list,list1);
        // sort(list,n,m);
        // list.insertFront(0);
        // list.insertEnd(0);
        // list.insertMiddle(10,2);
        // list.deleteFront();
        // list.deleteEnd();
        // list.deletePos(2);
        list.display();
    }
    static void merge(LinkedList list1,LinkedList list2) {
        node temp = list1.head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = list2.head;
        
        
        
        
    }
    static void sort(LinkedList list,int n ,int m) {
        
        for(int i = 1;i <= m+n;i++) {
            node first  = list.head;
        node second = list.head.next;
            for(int j = 1;j <= m+n - i - 1;j++){
                if(first.data > second.data) {
                int temp = first.data;
                first.data = second.data;
                second.data = temp;
                }
                first = first.next;
                second = second.next;
            }
        }
    }
}

























