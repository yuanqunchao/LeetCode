import java.util.Stack;

/*
232.用栈实现地队列
 */
public class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (!outStack.empty()) {
            return outStack.pop();
        }
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if (!outStack.empty()) {
            return outStack.peek();
        }
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();

    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
