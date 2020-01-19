public class 字典序的第K小数字 {



    class Node {

        public String val;
        public boolean isRoot;
        public boolean isEnd;
        public int num=0;
        public Node[] nodes = new Node[10];


        public void put(int index, String s) {

            if (isRoot) {
                char c = s.charAt(0);
                if (nodes[c - '0'] == null) {
                    nodes[c - '0'] = new Node();
                }
                nodes[c - '0'].put(index, s);
            } else {
                num++;
                if (index == s.length() - 1) {
                    isEnd = true;
                    val = s;
                } else {

                    if (nodes[s.charAt(index+1) - '0'] == null) {
                        nodes[s.charAt(index+1) - '0'] = new Node();
                    }
                    Node temp = nodes[s.charAt(index+1) - '0'];
                    temp.put(index + 1, s);
                }
            }
        }
    }
    public int findKthNumber(int n, int k) {

        Node root=new Node();
        root.isRoot=true;
        for(int i=1;i<=n;i++){
            root.put(0,String.valueOf(i));
        }
        return help(root,k);

    }

    private int help(Node root,int k){

        if(root==null){
            return 0;
        }
        if(root.isEnd){
            if(k==1){
            return Integer.valueOf(root.val);
            }
            k--;

        }
        int res=0;
        for(int i=0;i<10;i++){
            if(root.nodes[i]==null){
                continue;
            }
           if(res+root.nodes[i].num>=k){
              return help(root.nodes[i],k-res);
           }else{
               res+=root.nodes[i].num;
           }
        }
        return 0;
    }

    public static void main(String[] args) {
        字典序的第K小数字 test=new 字典序的第K小数字();
        System.out.println(test.findKthNumber(13,3));
    }

}
