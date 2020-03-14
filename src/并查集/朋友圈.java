package 并查集;

public class 朋友圈 {

    class UF{
        private int count;
        private int[] parent;
        private int[] size;


        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count=n;
        }

            public void union(int i,int j){
                int p=find(i);
                int q=find(j);
                if(p==q){
                    return ;
                }
                if(size[p]>size[q]){
                    parent[p]=q;
                    size[q]+=size[p];
                }else{
                    parent[q]=p;
                    size[p]+=size[q];
                }
                count--;

            }
            public int find(int x){

                while(parent[x]!=x){
                    parent[x]=parent[parent[x]];
                    x=parent[x];
                }
                return x;
            }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {

        /*int res=0;
        int[] v=new int[M.length];
        for(int i=0;i<M.length;i++){
            if(v[i]==0){
                dfs(M,v,i);
                res++;
            }
        }
        return res;*/

        int n=M.length;
        UF uf=new UF(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(M[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.getCount();


    }
    public void dfs(int[][] M,int[] v,int j){

        for(int i=0;i<v.length;i++){
            if(M[j][i]==1&&v[i]==0){
                v[i]=1;
                dfs(M,v,i);
            }
        }

    }
}
