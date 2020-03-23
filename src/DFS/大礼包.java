package DFS;

import java.util.ArrayList;
import java.util.List;

public class 大礼包 {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int sum=Integer.MAX_VALUE;
            boolean flag=false;
            for(List<Integer> list:special){
                List<Integer> temp=new ArrayList<>();
                boolean f=true;
                int x=0;
                for(int i=0;i<price.size();i++){
                    if(list.get(i)>needs.get(i)){
                        f=false;
                        break;
                    }
                    x+=list.get(i)*price.get(i);
                    temp.add(needs.get(i)-list.get(i));
                }
                if(f&&x>list.get(list.size()-1)){
                    flag=true;
                    sum=Math.min(sum,shoppingOffers(price,special,temp)+list.get(list.size()-1));
                }
            }
            if(!flag){
                sum=0;
                for(int i=0;i<needs.size();i++){
                    sum+=needs.get(i)*price.get(i);
                }
            }
            return sum;
    }
}
