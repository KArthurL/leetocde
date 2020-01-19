import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {

    public static void main(String[] args) {
            String s="aa";
            String t="aa";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        int start=0;
        int end=0;
        int right=0;
        int left=0;
        int len=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int num=t.length();
        for(char c:t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        while(right<s.length()){
            char c=s.charAt(right);
            if(!map.containsKey(c)){
                right++;
            }else{
                int x=map.get(c);
                if(x>0){
                    num--;
                }
                map.put(c,x-1);
                if(num==0){
                    while(left<=right){
                        char temp=s.charAt(left);
                        if(t.indexOf(temp)!=-1){
                            if(right-left+1<=len){
                                len=right-left+1;
                                start=left;
                                end=right;
                            }
                            if(map.get(temp)>=0)
                            {
                            break;}else{
                                map.put(temp,map.get(temp)+1);
                            }
                        }
                        left++;
                    }
                }
                right++;
            }

        }
        return num==0?s.substring(start,end+1):"";
    }
}
