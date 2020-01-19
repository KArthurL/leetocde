package 剑指offer;

public class 整数中1出现的次数 {


    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)
            return 0;
        if(n<10)
            return 1;
        String s1=n+"";
        char c=s1.charAt(0);
        String s2=s1.substring(1,s1.length());
        int v=Integer.parseInt(s2);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s2.length();i++)
        {
            sb.append('9');
        }
        int u=Integer.parseInt(sb.toString());
        if(c<'2')
            return v+1+NumberOf1Between1AndN_Solution(u)+NumberOf1Between1AndN_Solution(v);
        else
        {
            int i=1;
            for(int x=0;x<s2.length();x++)
            {
                i=i*10;
            }
            int j=Integer.parseInt(String.valueOf(c));
            return i+j*NumberOf1Between1AndN_Solution(u)+NumberOf1Between1AndN_Solution(v);
        }
    }
}
