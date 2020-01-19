import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }

    public static boolean isIsomorphic(String s, String t) {
            if(s==null||t==null)
                return false;
            if(s.length()!=t.length())
                return false;
        Map<Character,Character> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1)!=t.charAt(i)){
                    return false;
                }else{
                    continue;
                }
            }else{
                if(map.containsValue(s.charAt(i))) {
                    return false;
                }
                    map.put(c1,t.charAt(i));
            }
        }
        return true;
    }
}
