public class InfixToPostfix {
    node top = null;

    void push(char data) {
        node newnode = new node(data);

        if(top == null) {
            top = newnode;
        }
        else{
            newnode.next = top;
            top = newnode;
        }
    }

    char pop() {
        if(top == null) {
            System.out.println("STack is Empty...");
            return 0;
        }
       char c = top.data;
        top = top.next;
        return c;
    }

    char peek(){
        if(top == null) {
            System.out.println("STack is Empty...");
            return 0;
        }
        return top.data;
    }
    void display() {
        node temp = top;

        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    boolean isEmpty() {
        return top == null ;   
    }
    
    int precedence(char c) {
        if(c == '+' || c == '-') {
            return 1;
        }else if(c == '*' || c == '/') {
            return 2;
        }else if (c == '^'){
            return 3;
        }
        return -1;
    }
    String infToPos(String str) {
        String result = "";
        for (char  c : str.toCharArray()) {
            if(Character.isLetterOrDigit(c) ) {
                result += c;
            }else if(c == '(') {
                push(c);
            }else if(c == ')') {
                while(!isEmpty() && peek() != '(') {
                    result += pop();
                }
                if(!isEmpty() && peek() == '(') pop();
            }
            else {
                while(!isEmpty() && precedence(c) <= precedence(peek())) {
                    result += pop();
                }
                push(c);
            }
        }
        while(!isEmpty()) {
            result += pop();
        }
        return result;
    }

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        InfixToPostfix in = new InfixToPostfix();

        String str = "(a+b)*c";
        System.out.println(in.infToPos(str));
        // while(true) {
        //     int data = scan.nextInt();
        //     if(data == -1) break;
        //     in.push(data);
        // }
        // while (true) {
        //     int choice = scan.nextInt();
        //     if (choice == 1){
        //         int data = scan.nextInt();
        //         in.push(data);
        //     } else if(choice == 2){
        //         in.pop();
        //     } 
        //     else if(choice == 3) {
        //         in.display();
        //     }
        //     else {
        //         System.out.println("invalid");
        //         break;
        //     }
        // }
    }
}
class node {
    char data;
    node next;
    node(char data) {
        this.data = data;
        this.next = null;
    }
}

