package 剑指offer;

public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array) {
        int k=0;
        for(int i=0;i<array.length;i++){

            if((array[i]&1)==1){
                int j=i;
                while(j>k){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    j--;

                }
                k++;


            }


        }
    }

}
