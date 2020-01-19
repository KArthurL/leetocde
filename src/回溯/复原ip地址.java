package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 复原ip地址 {


    public static void main(String[] args) {
        复原ip地址 x=new 复原ip地址();
        System.out.println(x.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> list=new ArrayList<>();

        help(list,0,0,s,new StringBuilder());
        return list;
    }
    private void help(List<String> list,int num,int index,String s,StringBuilder sb){
        if(index>s.length()||num>4){
            return;
        }
        if(index==s.length()){
            if(num==4) {
                list.add(sb.substring(0,sb.length()-1));
            }
            return;
        }
        for(int i=index;i<index+3&&i<s.length();i++){
            String temp=s.substring(index,i+1);
            if(compare(temp)){
                sb.append(temp).append('.');
                help(list,num+1,i+1,s,sb);
                sb.delete(sb.length()-temp.length()-1,sb.length());
            }else{
                break;
            }
        }
    }
    private boolean compare(String s){

        if(s.length()>1&&s.startsWith("0")){
            return false;
        }

        int x=Integer.valueOf(s);
            return x<=255;
    }
}
