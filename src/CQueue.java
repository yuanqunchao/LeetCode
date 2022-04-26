import java.util.Stack;

/*
剑指Offer09.用两个栈实现队列
 */
public class CQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return -1;
        } else if (!outStack.empty()) {
            return outStack.pop();
        } else {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }
}
