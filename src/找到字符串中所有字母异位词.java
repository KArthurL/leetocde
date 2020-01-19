import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if(s.length()<p.length())
            return list;

        int start=0;
        int[] pc=new int[26];
        for(char x:p.toCharArray())
        {
            pc[x-'a']++;
        }
        int[] sc=new int[26];
        for(int i=0;i<p.length()-1;i++)
        {
            sc[s.charAt(i)-'a']++;
        }
        for(int j=p.length()-1;j<s.length();j++)
        {

            sc[s.charAt(j)-'a']++;
            if(Arrays.equals(sc,pc))
                list.add(start);
            sc[s.charAt(start++)-'a']--;

        }
        return list;
    }
}
