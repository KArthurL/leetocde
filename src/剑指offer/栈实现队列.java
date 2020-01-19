package 剑指offer;

import java.util.Stack;

public class 栈实现队列 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while(stack1.size()>0)
        {
            stack2.push(stack1.pop());
        }
        stack2.push(node);
        while(stack2.size()>0)
        {
            stack1.push(stack2.pop());

        }
    }

    public int pop() {
        return stack1.pop();
    }
}
