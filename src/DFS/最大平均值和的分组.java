package DFS;

import java.util.HashMap;
import java.util.Map;

public class 最大平均值和的分组 {
    Map<Integer,Double> map = new HashMap<>();
    //从start开始，分为k组的最大分数
    public double dfs(int[] A,int start,int k){
        if(k == 0)
            return 0;
        //由于题目中说明 1 <= A.length <= 100且1 <= K <= A.length
        //所以可以用start * 100 + k 表示当前状态
        if(map.containsKey(start * 100 + k)){
            return map.get(start * 100 + k);
        }
        double res = 0;
        int sum = 0;
        //针对最后一组，只能把剩下的全部数字划入组内
        if(k == 1){
            for(int i = start; i < A.length; i++){
                sum += A[i];
            }
            res = (double)sum / (A.length - start);

        }else{
            for(int i = start; i <= A.length - k; i++){
                sum += A[i];
                //后面所有情况的平均值最大值
                double after = dfs(A,i + 1,k - 1);
                //本次平均值
                double avg = (double)sum / (i - start + 1);
                if(after + avg > res){
                    res = after + avg;
                }
            }
        }
        //记忆
        map.put(start * 100 + k,res);
        return res;
    }

    public double largestSumOfAverages(int[] A, int K) {
        return dfs(A,0,K);
    }
}
