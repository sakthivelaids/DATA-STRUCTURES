
class node{
        int data;
        node next;
        node(int data){
                this.data=data;
                this.next=null;
        }
}

class stack{
        node top;
        public void push(int data){
            node nn=new node(data);
            if(top==null){
                top=nn;
            }else{
                nn.next=top;
                top=nn;
            }
        }
        int pop(){
            if(top==null){
                return -1;
            }
            int val=top.data;
            top=top.next;
            return val;
        }
        void peek(){
                System.out.println(top.data);
        }
        boolean isEmpty(){
            return top==null;
        }
        
        // void display(){
        //         node temp=top;
        //         while(temp!=null){
        //                 System.out.print(temp.data+" ");
        //                 temp=temp.next;
        //         }
        //         System.out.println();
        // }

}
public class QueUsingTwoStack {
    stack s1=new stack();
    stack s2=new stack();

    void enque(int data){
        s1.push(data);
    }

    int deque(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        if(s2.isEmpty()){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

        }
        return s2.pop();
    }
    void displays2(){
        node temp=s2.top;
        while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
        }
        System.out.println();
    }
    


    public static void main(String[] args) {
        QueUsingTwoStack obj=new QueUsingTwoStack();
        obj.enque(10);
        obj.enque(20);
        obj.enque(30);
        System.out.println(obj.deque());
        obj.displays2();
        obj.enque(40);
        System.out.println(obj.deque());
        obj.displays2();
        obj.enque(50);
        System.out.println(obj.deque());
        obj.displays2();
        System.out.println(obj.deque());
        obj.displays2();
        

    }

}