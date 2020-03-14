package 剑指offer;

import java.util.LinkedList;

public class 栈的压入弹出序列 {


    public static void main(String[] args) {
        int[] num1={1,2,3,4,5,5};
        int[] num2={5,4,5,3,2,1};
        System.out.println(IsPopOrder(num1,num2));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
       int p1=0;
       int p2=0;
        LinkedList<Integer> stack=new LinkedList<>();
        for(int i=0;i<=pushA.length;i++){

            if(stack.size()==0){
                stack.push(pushA[i]);
            }else{
                while(stack.size()>0){
                    int x=stack.pop();
                    if(x==popA[p2]) {
                        p2++;
                    }else{
                        stack.push(x);
                        break;
                    }
                }
                if(i<pushA.length) {
                    stack.push(pushA[i]);
                }
            }


        }

        return stack.size()==0;
    }

}
