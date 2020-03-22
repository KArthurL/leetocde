package 阿里;

import java.util.Arrays;
import java.util.Comparator;

public class 最长旋律 {


    public static void main(String[] args) {
        String[] str={"abm",
                "hpq",
                "qrt",
                "jklmnopqr",
                "jklmnopqr"};
        help(str);
    }

    public static void help(String[] strs){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(o1.length()-1)==o2.charAt(o2.length()-1)){
                    return o1.charAt(0)-o2.charAt(0);
                }else{
                    return o1.charAt(o1.length()-1)-o2.charAt(o2.length()-1);
                }

            }
        });

        int[] dp=new int[26];
        for(String s:strs){
            int l=s.charAt(0)-'a';
            int r=s.charAt(s.length()-1)-'a';
            for(int i=l;i>=0;i--){
                dp[r]=Math.max(dp[r],dp[i]+s.length());
            }
        }
        int num=0;
        for(int d:dp){
            num=Math.max(num,d);
        }
        System.out.println(num);
    }
}
