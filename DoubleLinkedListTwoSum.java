package DATA-STRUCTURES;

import java.util.*;

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

public class DoubleLinkedListTwoSum {
    public static void main(String[] args) {
        // Your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        node head = null;
        node temp = null;
        for(int i = 1;i <= n;i++){
            int data = scan.nextInt();
            node newnode = new node(data);

            if(head == null) {
                head = newnode;
                temp = newnode;
            }else{
                temp.next = newnode;
                newnode.prev = temp;
                temp = newnode;
            }
        }
        int x = scan.nextInt();
        Pairs(head,x);
    }
    static void Pairs(node head,int x) {
        node first = head;
        node second = head;
        
        while(second.next != null) {
            second = second.next;
        }

        boolean bool = false;

        while(first != null && second != null && first != second && first.prev != second) {
            int sum = first.data + second.data;

            if(sum == x) {
                System.out.println(first.data+ " "+ second.data);
                bool = true;
                first = first.next;
                second = second.prev;
                
            }else if(sum < x) {
                first = first.next;
            }else{
                second = second.prev;
            }
        }
        if(!bool) System.out.println("No pairs found");
    }
}


























