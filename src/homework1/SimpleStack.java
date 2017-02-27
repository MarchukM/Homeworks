package homework1;

public class SimpleStack {
    private int size;
    private int top;
    private char[] stackArr;

    public SimpleStack(int size) {
        this.top = -1;
        this.size = size;
        this.stackArr = new char[size];
    }

    public void push(char c) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        stackArr[++top] = c;
    }

    public char pop() {
        return stackArr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize(){
        return top + 1;
    }
}