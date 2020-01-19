public class 回文子串 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {

        if(s==null||s.length()==0){
            return 0;
        }

        int res=0;

        for(int i=0;i<s.length();i++){
            res++;
            int j=1;
            while(i-j>=0&&i+j<s.length()&&s.charAt(i-j)==s.charAt(i+j)){
                j++;
                res++;
            }
        }

        for(int i=0;i<s.length();i++){
            int j=1;
            while(i-j+1>=0&&i+j<s.length()&&s.charAt(i-j+1)==s.charAt(i+j)){
                j++;
                res++;
            }
        }


        return res;
    }

}
