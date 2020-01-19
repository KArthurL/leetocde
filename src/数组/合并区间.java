package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        List<int[]> list=new ArrayList<>();
        if(length<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int index=0;
        list.add(intervals[0]);
        for(int i=1;i<length;i++){
            int[] temp=list.get(index);
            if(temp[1]<intervals[i][0]){
                list.add(intervals[i]);
                index++;
            }else if(temp[1]<intervals[i][1]){
                temp[1]=intervals[i][1];
            }else
                continue;
        }
        int[][] res=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

}
