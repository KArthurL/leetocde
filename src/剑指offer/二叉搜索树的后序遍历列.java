package 剑指offer;

public class 二叉搜索树的后序遍历列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0)
            return false;
        return help(sequence,0,sequence.length-1);
    }
    private boolean help(int[] sequence,int start,int end){

        if(start>=end){
            return true;
        }
        int right=end;
        int x=sequence[end];
        for(int i=0;i<end;i++){

            if(sequence[i]>x){
                right=i;
                break;
            }
        }
        for(int i=right;i<end;i++){
            if(sequence[i]<x){
                return false;
            }
        }
        return help(sequence,start,right-1)&&help(sequence,right,end-1);


    }



}
