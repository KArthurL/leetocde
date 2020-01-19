package 剑指offer;

public class 字符串转成整数 {

    public int StrToInt(String str) {
        int res=0;
        int max=Integer.MAX_VALUE/10;
        boolean flag=true;

        for(int i=0;i<str.length();i++){

            if(res>max){
                return 0;
            }

            char c= str.charAt(i);

            if(i==0){
                if(c=='-'){
                    flag=false;
                    continue;
                }else if(c=='+'){
                    continue;
                }
            }
            if(c<'0'||c>'9'){
                return 0;
            }

            int temp=c-'0';
            if(res==max&&temp>7&&flag){
                return 0;
            }
            if(res==max&&temp>8&&!flag){
                return 0;
            }
            res=res*10+temp;

        }

        return flag?res:-res;

    }
}
