package DFS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 小易的字典 {

    public static void main(String[] args){
        int n;int m;int k;
        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        k=scanner.nextInt();
        Dic dic=new Dic();
        dic.res(n,m,k);
    }


}
class Dic{

    public void res(int n,int m,int k){
        StringBuilder stringBuilder=new StringBuilder();
        dfs(n,m,k,stringBuilder);
    }

    private void dfs(int n,int m,int k,StringBuilder sb) {

        if (m == 0 && n == 0) {
            System.out.println(k == 1 ? sb.toString() : -1);
        } else {

            if (n == 0) {
                sb.append('z');
                dfs(n, m - 1, k, sb);
            } else if (m == 0) {
                sb.append('a');
                dfs(n - 1, m, k, sb);
            } else {

                long left = comb(n - 1, m + n - 1);
                if (left > 0 && k > left) {
                    sb.append('z');
                    dfs(n, m - 1, k - (int) left, sb);
                } else {
                    sb.append('a');
                    dfs(n - 1, m, k, sb);
                }
            }
        }
    }
    static Map<String,Long> map= new HashMap<>();
    private static long comb(int m,int n){
        if(m<n){
            return comb(n,m);
        }
        String key= m+","+n;
        if(n==0)
            return 1;
        if (n==1)
            return m;
        if(n>m/2)
            return comb(m,m-n);
        if(n>1){
            if(!map.containsKey(key)) {
                long num = comb(m - 1, n - 1) + comb(m - 1, n);
                map.put(key, num>1000000000?1000000000:num);
            }
            return map.get(key);
        }
        return -1;
    }
}
