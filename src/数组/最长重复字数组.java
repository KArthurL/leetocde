package 数组;

public class 最长重复字数组 {

    public int findLength(int[] A, int[] B) {
        int res=0;
        if(A.length<B.length){
            int[] temp=A;
            A=B;
            B=temp;
        }
        for(int i=0;i<A.length;i++){
            int max=0;
            for(int j=0;j<B.length;j++){
                if(i+j==A.length){
                    max=0;
                }
                if(A[i+j>=A.length?i+j-A.length:i+j]==B[j]){
                    max++;
                    if(max>res){
                        res=max;
                    }
                }else{
                    max=0;
                }
            }

        }
        return res;

    }
}
