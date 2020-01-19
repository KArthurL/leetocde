package 字符串;

import java.util.LinkedList;

public class 字符串转换整数 {
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        String s=str.trim();
        if(s==null||s.length()==0)
            return 0;
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int res=0;
        int index=0;
        boolean flag=true;
        LinkedList<Character> stack=new LinkedList<>();
        if(s.charAt(0)=='-')
        {
            flag=false;
            index++;
        }
        if(s.charAt(0)=='+')
        {
            index++;
        }

        for(;index<s.length();index++)
        {
            if(s.charAt(index)>'9'||s.charAt(index)<'0')
            {
                if(stack.size()==0){
                    return 0;
                }
                break;
            }
            else{
                stack.offer(s.charAt(index));
            }
        }
        while(!stack.isEmpty()){
            if(res>max/10)
                return flag?max:min;
            if(res==max/10){
                if(flag&&stack.peek()>'7'){
                    return max;
                }else if(!flag&&stack.peek()>'8'){
                    return min;
                }
            }
            res=res*10+Integer.valueOf(stack.poll()-'0');
        }
        return flag?res:-res;
    }

}
