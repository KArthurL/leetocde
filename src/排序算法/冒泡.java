package 排序算法;

public class 冒泡 {


    public void bubbleSort(int[] data){

        for(int i=data.length-1;i>0;i--){
            boolean flag=false;
            for(int j=0;j<i;j++){
                if(data[j]>data[j+1]){
                    int temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }


    }

}
