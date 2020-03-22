package 数组;

import java.util.PriorityQueue;
import java.util.Random;

public class 数组中第k个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();


    }
    private int help(int[] num,int left,int right,int k){
        if(left==right){
            return num[left];
        }
        int index=partition(num,left,right);
        if(index==k){
            return num[k];
        }else if(index<k){
            return help(num,index+1,right,k);
        }else{
            return help(num,left,index-1,k);
        }

    }
    public static int partition(int[] data,int left,int right){

        int index=left+new Random().nextInt(right-left);
        int temp=data[left];
        data[left]=data[index];
        data[index]=temp;
        int k=data[left];
        while(left<right){
            while(left<right&&data[right]>=k){
                right--;
            }
            data[left]=data[right];
            while(left<right&&data[left]<=k){
                left++;
            }
            data[right]=data[left];
        }
        data[left]=k;
        return left;
    }

}
