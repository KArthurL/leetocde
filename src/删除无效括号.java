import java.util.ArrayList;
import java.util.List;

public class 删除无效括号 {

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(")("));
    }

    public static List<String> removeInvalidParentheses(String s) {

        List<String> res=new ArrayList<>();
        int right=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                if(left>0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(res,left,right,s,0);

        return res;
    }
    public static void dfs(List<String> res,int left,int right,String s,int start){

        if(left==0&&right==0){
            if(help(s))
            {
                res.add(s);
            }
        }else{
            for(int i=start;i<s.length();i++){
                if(i!=start&&s.charAt(i)==s.charAt(i-1))
                {
                    continue;
                }
                if(s.charAt(i)=='('&&left>0){
                    dfs(res,left-1,right,s.substring(0,i)+s.substring(i+1),i);
                }
                if(s.charAt(i)==')'&&right>0){
                    dfs(res,left,right-1,s.substring(0,i)+s.substring(i+1),i);
                }
            }
        }

    }

    private static  boolean help(String s){
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count += 1;
            }
            if (c == ')') {
                count -= 1;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;

    }

}
