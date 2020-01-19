package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> res=new ArrayList<>();
        if(size==0||num.length==0){
            return res;
        }
        LinkedList<Integer> queue=new LinkedList<>();


        for(int i=0;i<num.length;i++){

            while(!queue.isEmpty()&&num[queue.peekLast()]<num[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(queue.peek()==i-size){
                queue.poll();
            }
            if(i-size>=-1){
                res.add(num[queue.peek()]);
            }

        }

        return res;



    }
}
