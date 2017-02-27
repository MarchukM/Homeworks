package homework1;

public class QueueWithTwoStacks {
    private static final int SIZE = 100;
    private SimpleStack stack1;
    private SimpleStack stack2;
    private boolean flag;

    public QueueWithTwoStacks() {
        this.stack1 = new SimpleStack(SIZE);
        this.stack2 = new SimpleStack(SIZE);
        flag = true;
    }

    public void offer(char c) {
        if (flag) {
            stack1.push(c);
        } else {
            while (stack2.getSize() != 0) {
                stack1.push(stack2.pop());
            }
            stack1.push(c);
            flag = true;
        }
    }

    public char poll() {
        char ch;
        if (flag) {
            while (stack1.getSize() != 1) {
                stack2.push(stack1.pop());
            }
            ch = stack1.pop();
            flag = false;
        } else {
            ch = stack2.pop();
        }
        return ch;
    }

    public int getSize() {
        if (flag) {
            return stack1.getSize();
        } else {
            return stack2.getSize();
        }
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.offer('a');
        queue.offer('b');
        queue.offer('c');
        queue.offer('d');
        queue.offer('e');
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer('f');
        queue.offer('g');
        queue.offer('h');

        int size = queue.getSize();

        for (int i = 0; i < size; i++) {
            System.out.println(queue.poll());
        }
    }
}