package 字符串;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        int res=0;
        int i=0;
        int j=0;
        Set<Character> set=new HashSet<>();
        while(i<s.length()&&j<s.length()){
            char c=s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                j++;
                res= Math.max(res,set.size());
            }else{
                while(i<j){
                    set.remove(s.charAt(i));
                    if(s.charAt(i++)==c){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
