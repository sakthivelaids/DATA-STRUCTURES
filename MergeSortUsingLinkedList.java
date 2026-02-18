
import java.util.*;
class node{
    int data;
    node next;
    node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    node head = null;
    node temp = null;

    void push (int data) {
        node newnode = new node(data);

        if(head == null && temp == null) {
            head = newnode;
            temp = newnode;
        }else{
            temp.next = newnode;
            temp = newnode;
        }
    } 

    void display() {
        temp = head;
        while(temp.next != null) {
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }System.out.println(temp.data);
    }
    node sortList(node head){
        if(head == null || head.next == null) return head;
        node mid = getMid(head);
        node nextmid = mid.next;
        mid.next = null;

        node left = sortList(head);
        node right = sortList(nextmid);

        return merge(left,right);
    }
    node getMid(node head) {
        node slow = head;
        node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    node merge(node left,node right) {
        node dummy = new node(0);
        node current = dummy;
        while(left != null && right != null) {
            if(left.data <= right.data) {
                current.next = left;
                left = left.next;
            }else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left : right;
        return dummy.next;
    }
}
public class MergeSortUsingLinkedList {

    public static void main(String[] args) {
        // Your code here
        Scanner scan = new Scanner(System.in);
        String str = "4 -> 2 -> 1 -> 3";
        LinkedList list = new LinkedList();
        for(char c : str.toCharArray()) {
            if(c >= '0' && c<= '9') {
                list.push(c -'0');
            }
        }
        // list.push(4);
        // list.push(2);
        // list.push(1);
        // list.push(3);
        System.out.print("Original: ");
        list.display();
        list.head = list.sortList(list.head);
        System.out.print("Sorted: ");
        list.display();
    }
}

























