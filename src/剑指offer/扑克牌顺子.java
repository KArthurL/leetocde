package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class 扑克牌顺子 {

    public boolean isContinuous(int [] numbers) {

        if(numbers.length<1){
            return false;
        }

        Arrays.sort(numbers);
        int p1=0;
        int p2=numbers.length-1;
        while(p1<p2){

            if(numbers[p2-1]==0){
                return true;
            }
            if(numbers[p2-1]==numbers[p2]-1){
                p2--;
            }else{
                int n=numbers[p2]-numbers[p2-1]-1;
                if(n<0)
                    return false;
                for(int i=0;i<n;i++)
                {
                    if(numbers[p1]!=0)
                        return false;
                    else
                        p1++;
                }
                p2--;
            }



        }
        return true;



    }
}
