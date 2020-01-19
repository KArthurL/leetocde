public class 每日温度 {


    public static void main(String[] args) {

        int[] s={73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(s);

    }

    public static  int[] dailyTemperatures(int[] T) {
        int[] res=new int[T.length];
        for(int i=T.length-1;i>=0;i--){
            int j=i+1;
            while(j<T.length){
                if(T[i]<T[j]){
                    res[i]=j-i;
                    break;
                }else if(res[j]==0){
                    break;
                }else{
                    j+=res[j];
                }
            }

        }
        return res;
    }

}
