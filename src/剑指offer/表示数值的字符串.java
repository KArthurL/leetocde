package 剑指offer;

public class 表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        String s=new String(str).toLowerCase();
        int start=s.indexOf("e");
        int end=s.lastIndexOf("e");
        if(start!=end)
            return false;
        else{
            String[] strs=s.split("e");
            if(strs.length==1)
                return help(s);
            else
                return help(strs[0])&&help2(strs[1]);
        }
    }
    private boolean help(String s)
    {
        if(s.endsWith("."))
            return false;
        if(s==null||s.equals(""))
            return true;
        else{
            int i=0;
            int point=0;
            if(s.startsWith("+")||s.startsWith("-"))
                i=1;
            for(;i<s.length();i++)
            {
                if(s.charAt(i)=='.')
                {
                    point++;
                    if(point>1)
                        return false;
                }else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                {
                    continue;
                }
                else
                    return false;
            }
            return true;
        }
    }
    private boolean help2(String s){
        if(s.endsWith("."))
            return false;
        if(s==null||s.equals(""))
            return true;
        else{
            int i=0;
            int point=0;
            if(s.startsWith("+")||s.startsWith("-"))
                i=1;
            for(;i<s.length();i++)
            {
                if(s.charAt(i)=='.')
                {

                    return false;
                }else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
                {
                    continue;
                }
                else
                    return false;
            }
            return true;
        }
    }
}
