class QueueUsingOneStack {

    int[] stack;
    int top;
    int size;

    QueueUsingOneStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // push (stack operation)
    void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = x;
    }

    // pop (stack operation)
    int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return stack[top--];
    }

    // enqueue = push
    void enqueue(int x) {
        push(x);
    }

    // dequeue using recursion
    int dequeue() {
        if(top == -1) {
            System.out.println("que is empty...");
            return -1;
        }
        int x = pop();
        if(top == -1) {
            return x;
        }
        int front = dequeue();
        push(x);
        return front;
    }

    public static void main(String[] args) {
        QueueUsingOneStack q = new QueueUsingOneStack(10);

        q.enqueue(5);
        q.enqueue(15);
        q.enqueue(25);

        System.out.println(q.dequeue()); // 5
        System.out.println(q.dequeue()); // 15
    }
}

