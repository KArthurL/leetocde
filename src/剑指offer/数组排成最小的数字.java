package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

public class 数组排成最小的数字 {

    public String PrintMinNumber(int [] numbers) {

        String[] s=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            s[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               String m=o1+o2;
               String n=o2+o1;
                return Integer.valueOf(m)-Integer.valueOf(n);
            }

        });
        StringBuilder SB=new StringBuilder();
        for(String ss:s){
            SB.append(ss);
        }
        return SB.toString();

    }

}
