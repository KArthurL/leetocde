package 剑指offer;

import java.util.ArrayList;

public class 两个只出现一次的数字 {


    public int[] singleNumber(int[] nums) {
        int[] res=new int[2];
        int xor=0;
        for(int n:nums)
        {
            xor=xor^n;
        }
        int mask=xor&(-xor);
        for(int n:nums)
        {
            if((n&mask)==0)
            {
                res[0]^=n;
            }
            else
                res[1]^=n;
        }
        return res;
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int x=0;
        int index=0;
        for(int n:array)
            x^=n;
        while((x&1)!=1)
        {
            index++;
            x=x>>1;
        }
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int n:array)
        {
            int m=n>>index;
            if((m&1)==1)
                list1.add(n);
            else
                list2.add(n);
        }
        int s1=0;
        int s2=0;
        for(int p:list1)
        {
            s1=s1^p;
        }
        for(int p:list2)
        {
            s2=s2^p;
        }
        num1[0]=s1;
        num2[0]=s2;
    }

}
