package 剑指offer;

public class 构建乘积数组 {

    public int[] multiply(int[] A) {



       int[] res=new int[A.length];


       if(A.length==0){
           return res;
       }
       int temp=1;
       int[] right=new int[A.length];
       right[A.length-1]=1;

       for(int i=A.length-2;i>=0;i--){

           right[i]=right[i+1]*A[i+1];
       }

       for(int i=0;i<A.length;i++){

           res[i]=right[i]*temp;
           temp*=A[i];
       }

        return res;
    }
}
