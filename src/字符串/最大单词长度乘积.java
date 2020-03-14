package 字符串;

public class 最大单词长度乘积 {
    public int maxProduct(String[] words) {

        int[] vals=new int[words.length];
        for(int i=0;i<vals.length;i++){
            vals[i]=getbits(words[i]);
        }
        int res=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if((vals[i]&vals[j])==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
    private int getbits(String s){
        int val=0;
        for(int i=0;i<s.length();i++){
            val|=1<<(s.charAt(i)-'0');
        }
        return val;
    }
}
