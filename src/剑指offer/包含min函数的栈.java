package 剑指offer;

import java.util.LinkedList;

public class 包含min函数的栈 {

    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public void push(int node) {
        if(stack==null){
            stack=new LinkedList<>();

        }
        if(minStack==null){
            minStack=new LinkedList<>();
        }

        if(stack.size()==0){
            stack.push(node);
            minStack.push(node);
        }else{
            int n=minStack.pop();
            int min=Math.min(n,node);
            minStack.push(n);
            minStack.push(min);
            stack.push(node);
        }
    }

    public void pop() {
            minStack.pop();
            stack.pop();
    }

    public int top() {
        int x=stack.pop();
        stack.push(x);
        return x;
    }

    public int min() {
        int x=minStack.pop();
        minStack.push(x);
        return x;
    }
}
