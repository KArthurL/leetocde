package 贪心;

public class 加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index=0;
        int num=gas.length;
        int sum=0;
        int gases=0;
        int costs=0;
        for(int x:gas)
            gases+=x;
        for(int y:cost)
            costs+=y;
        if(gases<costs)
            return -1;
        for(int i=0;i<num;i++)
        {
            sum+=gas[i]-cost[i];
            if(sum<0)
            {
                sum=0;
                index=i+1;
            }

        }
        return index;


    }
}
