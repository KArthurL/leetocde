import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 根据身高重建队列 {


    public static void main(String[] args) {
        int[][] nums={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(nums);
    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,((o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]));

        List<int[]> list=new LinkedList<>();
        for(int[] o:people){
            list.add(o[1],o);
        }
        return list.toArray(new int[list.size()][2]);

    }

}
