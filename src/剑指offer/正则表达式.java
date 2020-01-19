package 剑指offer;

public class 正则表达式 {

    public boolean isMatch(String s, String p) {
        boolean[][] res=new boolean[s.length()+1][p.length()+1];
        res[0][0]=true;

        for(int i=0;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(i>0&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')){
                    res[i][j]=res[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    if(i>0&&(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.')){

                        res[i][j]=res[i][j-2]||res[i-1][j]||res[i][j-1];

                    }else{
                        res[i][j]=res[i][j-2];
                    }
                }
            }
        }

        return res[s.length()][p.length()];
    }
}
