package 字符串;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) {
            return s;
        }
        int start=0;
        int end=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            int j=1;
            while(i-j>=0&&i+j<s.length()&&s.charAt(i-j)==s.charAt(i+j)){
                if(j>res){
                    res=j;
                    start=i-j;
                    end=i+j;
                }
                j++;
            }
        }
        for(int i=0;i<s.length();i++){
            int j=1;
            while(i-j+1>=0&&i+j<s.length()&&s.charAt(i-j+1)==s.charAt(i+j)){
                if(j>res){
                    res=j;
                    start=i-j+1;
                    end=i+j;
                }
                j++;
            }
        }
        return s.substring(start,end+1);
    }

}
