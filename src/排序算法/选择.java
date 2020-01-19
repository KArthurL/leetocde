package 排序算法;

public class 选择 {



    public void selectionSort(int[] data){

        for(int i=0;i<data.length-1;i++){

            int min=i;
            for(int j=i+1;j<data.length;j++){
                if(data[min]>data[j]){
                    min=j;
                }
            }
            int temp=data[min];
            data[min]=data[i];
            data[i]=temp;
        }

    }
}
