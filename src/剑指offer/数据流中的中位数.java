package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {

    PriorityQueue<Integer> min=new PriorityQueue<>();
    PriorityQueue<Integer> max=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });


    public void Insert(Integer num) {
        if(min.size()>=max.size()){
            max.offer(num);
            if(min.size()>0){
                Integer temp=max.poll();
                Integer m=min.poll();
                if(temp>m){
                    min.offer(temp);
                    max.offer(m);
                }
                else{
                    min.offer(m);
                    max.offer(temp);
                }
            }

        }else{
            min.offer(num);
            if(max.size()>0){
                Integer temp=min.poll();
                Integer m=max.poll();
                if(temp<m){
                    max.offer(temp);
                    min.offer(m);
                }else{
                    max.offer(m);
                    min.offer(temp);
                }
            }

        }

    }
    public Double GetMedian() {
        if(min.size()==max.size()){
            return ((double)(min.peek()+max.peek()))/2;
        }
        return min.size()>max.size()?(double)min.peek():(double)max.peek();
    }

}
