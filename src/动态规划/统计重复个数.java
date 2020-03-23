package 动态规划;

public class 统计重复个数 {


    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int p1=0;
        int p2=0;
        int sum=1;
        while(p2<s2.length()){
            if(c1[p1]==c2[p2]){
                p2++;
            }
            if(p2==s2.length()){
                break;
            }
            if(++p1==c1.length){
                sum++;
                p1=0;
            }
        }
        return n1/(n2*sum);
    }

}
