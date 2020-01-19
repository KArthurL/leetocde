import java.util.LinkedList;

public class 字符串解码 {


    public static void main(String[] args) {
        System.out.println(decodeString("abcabccdcdcdef"));
    }


    public static String decodeString(String s) {

        if(s==null||s.length()==0) {
            return s;
        }

        LinkedList<Integer> numStack=new LinkedList<>();
        LinkedList<String>  stringStack=new LinkedList<>();


        StringBuilder stringBuilder=new StringBuilder();
        int n=0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                n=n*10+Integer.valueOf(String.valueOf(s.charAt(i)));
            }else if(s.charAt(i)=='['){
                numStack.push(n);
                n=0;
                stringStack.push(stringBuilder.toString());
                stringBuilder.delete(0,stringBuilder.length());
            }else if(s.charAt(i)==']'){
                int temp=numStack.pop();
                StringBuilder temps=new StringBuilder(stringStack.pop());
                for(int j=0;j<temp;j++){
                    temps.append(stringBuilder);
                }

                stringBuilder=temps;
            }else{
                stringBuilder.append(s.charAt(i));
            }

        }

        return stringBuilder.toString();

    }
    public static String decodeString2(String s) {

        if(s==null||s.length()==0) {
            return s;
        }
        int n=0;
        int x=0;
        int start=0;
        int end=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<=9){
                n=n*10+s.charAt(i)-'0';

            }else if(s.charAt(i)=='['){
                x=i+1;
                while(s.charAt(end)!=']'){
                    end--;
                }
                break;
            }else{
                start++;
            }
        }
        String temp=decodeString2(s.substring(x,end));
        StringBuilder res=new StringBuilder();
        res.append(s.substring(0,start+1));
        for(int i=0;i<n;i++){
            res.append(temp);
        }
        res.append(s.substring(end));
       return res.toString();

    }

}
