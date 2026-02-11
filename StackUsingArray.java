package DATA-STRUCTURES.DATA-STRUCTURES;
import java.util.*;
public class StackUsingArray {
    
    int size;
    int stack[];
    int top;
    void StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    
    public void push(int data) {
        if(top == size-1) {
            System.out.println("Stack OverFlow...");
        }else {
            stack[++top] = data;
        }
    }
    public void pop() {
        if(top == -1) {
            System.out.println("Stack UnderFlow...");
        }else {
            int temp = stack[top--];
            System.out.println(temp);
        }
    }
    public void peek() {
        if(top == -1) {
            System.out.println("Stack UnderFlow...");
        }else {
            int c = stack[top];
            System.out.println(c);
        }
    }
    public void display() {
        if(top == -1) {
            System.out.println("Stack UnderFlow...");
        }else {
            System.out.println("Start Displaying...");
            for(int i = top;i >= 0;i--) {
                System.out.println(stack[i]+ " ");                
            }
        }
    }
    void minimum() {
        int small = stack[top];
        for(int i = top;i >= 0;i--) {
            if(small >= stack[i]){
                small = stack[i];
            }
        }
        System.out.print(small);
    }
    
    void nextMax() {
        
    }
    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        
        int size = scan.nextInt();
        StackUsingArray one = new StackUsingArray();
        one.StackArray(size);
        
        while(true) {
            int c = scan.nextInt();
            if(c == 1) {
                int data = scan.nextInt();
                one.push(data);
            }else if(c == 2){
                one.pop();
            }else if(c == 3){
                one.peek();
            }else if(c == 4){
                one.display();
            }else if(c == 5){
                one.minimum();   
            }else{
                System.out.print("Exit...");
                break;
            }
        }
    }
}

