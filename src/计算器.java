import java.util.LinkedList;

public class 计算器 {

    //链表是头插
    public static void main(String[] args) {
        System.out.println(calculate(
                "0-2147483647"));
    }
    private static int calculate(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        s=s.trim();
        LinkedList<Long> num=new LinkedList<>();
        LinkedList<Character> sign=new LinkedList<>();
        String[] s1=s.split("[\\+\\-\\*\\/]");
        String[] s2=s.split("\\d+");
        num.push(Long.valueOf(s1[0].trim()));
        for(int i=1;i<s2.length;i++){
            String c=s2[i].trim();
            if(c.equals("+")){
                num.push(Long.valueOf(s1[i].trim()));
                sign.push('+');
            }else if(c.equals("-")){
                num.push(Long.valueOf(s1[i].trim()));
                sign.push('-');
            }else if(c.equals("*")){
                long n=num.pop();
                num.push(n*Long.valueOf(s1[i].trim()));
            }else{
                long n=num.pop();
                num.push(n/Long.valueOf(s1[i].trim()));
            }
        }

         long res=num.get(num.size()-1);
        for(int i=num.size()-2;i>=0;i--){
            char c=sign.get(i);
            if(c=='+'){
                res+=num.get(i);
            }else{
                res-=num.get(i);
            }

        }

        return (int)res;
    }
}
