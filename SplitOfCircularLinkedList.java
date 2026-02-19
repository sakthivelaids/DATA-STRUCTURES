import java.util.*;
class node{
    int data;
    node next;
    node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SplitOfCircularLinkedList {
    public static void main(String[] args) {
        // Your code here
        Scanner scan = new Scanner(System.in);
        int size =scan.nextInt();

        node head = null;
        node temp = null;
        for(int i = 1;i <= size;i++) {
            int data = scan.nextInt();
            node newnode = new node(data);

            if(head == null) {
                head = newnode;
                temp = newnode;
            }else{
                temp.next = newnode;
                temp = newnode;
            }
        }
        temp.next = head;

        display(head);
        // node slow = head;;
        // node fast = head;
        // do{
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // while(fast != head && fast.next != null);
    }
    static void display(node head) {
        node slow = head;
        node fast = head;
        if(head == null) return;
        if(head.next == head) {
            System.out.println(head.data); 
            return;
        }
        while(fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node head2;
        if(fast.next.next == head) {
            head2 = slow.next;
            fast.next.next = slow.next;
        }else{
            head2 = slow.next;
            fast.next = slow.next;
        }
        slow.next = head;

       node current = head;
       do {
        System.out.print(current.data+ " ");
        current = current.next;
       }while(current != head);
       System.out.println();

       current = head2;
       node temp = head2;
       if(temp != null) {
        do{
            System.out.print(current.data+ " ");
            current = current.next;
        }while(current != head2);
       }
        // do{
        //     System.out.print(temp.data+ " ");
        //     temp = temp.next;
        // } while(temp != head); 
        // for(int i = n;i < m;i++) {
        //     System.out.print(temp.data+ " ");
        //     temp = temp.next;
        // }
    }

}
