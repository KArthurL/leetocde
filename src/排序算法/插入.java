package 排序算法;

public class 插入 {

    public static void main(String[] args) {
        int [] nums={3,2,5,7,1,5,6,9,5};
      insertionSort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

    public static void insertionSort(int[] data){

        for(int i=1;i<data.length;i++){

            int min=data[i];
            int j=i;
            while(j>0&&data[j-1]>min){
                data[j]=data[j-1];
                j--;
            }
            data[j]=min;

        }
    }
}
