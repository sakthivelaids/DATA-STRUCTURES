import java.util.*;

public class ValidParenthesisArray {
    int size;
    char stack[];
    int top;

    ValidParenthesisArray(int size) {
        this.size = size;
        stack = new char[size];
        top = -1;
    }

    public void push(char data) {
        if (top == size - 1) {
            // Overflow shouldn't happen in this problem
            return;
        }
        stack[++top] = data;
    }

    public char pop() {
        if (top == -1) {
            return '.'; // Return dummy char if empty
        }
        return stack[top--];
    }

    public boolean isValidParenthesis(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                push(c);
            } else {
                char popped = pop();
                if ((c == ')' && popped != '(') ||
                    (c == ']' && popped != '[') ||
                    (c == '}' && popped != '{')) {
                    return false;
                }
            }
        }
        return top == -1; 
    }

    public String toPostfix(String infix) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                push(c);
            } else if (c == ')') {
                while (!isEmpty() && peek() != '(') {
                    result.append(pop());
                }
                pop(); // remove '('
            } else { // operator
                while (!isEmpty() && precedence(peek()) >= precedence(c)) {
                    result.append(pop());
                }
                push(c);
            }
        }

        while (!isEmpty()) {
            result.append(pop());
        }

        return result.toString();
    }
    public int precedence(char c) {
        switch (c) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public char peek() {
        if (top == -1) {
            return '.'; 
        }
        return stack[top];
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        ValidParenthesisArray one = new ValidParenthesisArray(str.length());

        System.out.println(one.isValidParenthesis(str));
        scan.close();
    }
}
