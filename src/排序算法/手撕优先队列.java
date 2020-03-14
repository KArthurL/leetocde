package 排序算法;

import java.util.concurrent.CountDownLatch;

public class 手撕优先队列 {


    private int[] table=new int[10];
    private int size=0;

    //上浮
    private void siftUp(int index,int num){
        while(index>0){

            int parent=(index-1)>>1;
            if(table[parent]>num){
                break;
            }
            table[index]=table[parent];
            index=parent;

        }
        table[index]=num;
    }


    private void siftDown(int index,int num){

        int k=(size-2)>>1;
        while(index<=k){
            int left=index*2+1;
            int rignt=left+1;
            int best=table[left]>table[rignt]?left:rignt;
            if(num>table[best]){
                break;
            }
            table[index]=table[best];
            index=best;
        }
        table[index]=num;
    }

    public  int remove(int index){

        if(size==0||index>=size){
            return 0;
        }
        int ans=table[index];
        if (index!=size-1){
            int n=table[size-1];
            siftDown(index,n);
            if(table[index]==n){
                siftUp(index,n);
            }

        }
        size--;
        return ans;


    }

    public void offer(int n){
        if(size==0){
            table[0]=n;
        }else {
            siftUp(size,n);
        }
        size++;
    }

    public int poll(){
        if(size>0) {
            return remove(0);
        }else{
            return 0;
        }
    }



}
