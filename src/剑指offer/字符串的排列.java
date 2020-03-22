package 剑指offer;

import java.util.*;

public class 字符串的排列 {
    public static String[] permutation(String s) {
        Set<String> res=new HashSet<>();
        StringBuilder stringBuilder=new StringBuilder();
        boolean[] flags=new boolean[s.length()];
        char[] cs=s.toCharArray();
        Arrays.sort(cs);
        help(stringBuilder,flags,cs,res);
        return res.toArray(new String[res.size()]);
    }

    public static void help(StringBuilder sb, boolean[] flags, char[] cs, Set<String> res){
        if(sb.length()==cs.length){
            res.add(sb.toString());
        }else{
            for(int i=0;i<cs.length;i++){
                if(!flags[i]){
                    sb.append(cs[i]);
                    flags[i]=true;
                    help(sb,flags,cs,res);
                    flags[i]=false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        for(String s:permutation("aab")){
            System.out.println(s);
        }
    }
}
