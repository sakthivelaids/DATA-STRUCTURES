package DATA-STRUCTURES.DATA-STRUCTURES;

import java.util.Scanner;


class node { 
    int data;
    node next;
    node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    node top;
    public void push(int data) {
        node newnode = new node(data);

        if(top == null) {
            top = newnode;
        }else {
            newnode.next = top;
            top = newnode;
        }
    }    

    public void pop() {
        if(top == null) {
            System.out.println(" Stack UnderFlow...");
        }
        else {
            System.out.println("Pop element is: ");
            System.out.println(top.data);
             top = top.next;
        }
    }

    public void peek () {
        if(top == null ){
            System.out.println("Stack UnderFlow...");
        }else {
            System.out.println("peek element is: ");
            System.out.println(top.data);
        }
    }

    public void display() {
        // node temp = top;
        while(top != null ){
            System.out.print(top.data+ " ");
            top = top.next;
        }
    }
    
    void max() {
        int max= top.data;
        // node temp = top;
        while(top == null) {
            if(top.data >= max) {
                max = top.data;
            }
            top =top.next;
        }
        System.out.print(max);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();
        while(true) {
            int data = scan.nextInt();
            if(data == -1){
                break;
            }
            stack.push(data);
        }
        stack.pop();
        stack.peek();
        stack.display();
        scan.close();
    }
}
