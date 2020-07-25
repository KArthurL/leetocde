import java.util.HashMap;
import java.util.Random;

public class Skiplist {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    Node head;

    class Node{
        int val;
        Node bw; //后退指针
        Node[] fw; //前进指针

        public Node(int val){
            this.val = val;
            fw = new Node[randomLevel()];
        }

        public Node(int val, int size){
            this.val = val;
            fw = new Node[size+1];
        }

        private int randomLevel() {
            int level = 1;
            while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) level++;
            return level;
        }
    }

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
    }

    public boolean search(int num) {
        Node p = searchNode(num);
        return p.val == num;
    }

    public void add(int num) {
        Node p = searchNode(num);
        Node n = new Node(num);
        n.bw = p;
        for(int i=0;i<n.fw.length;i++){
            Node f = p;
            while(f.bw!=null && f.fw.length<i+1) f = f.bw;
            if(i==0 && f.fw[i]!=null) f.fw[i].bw = n;
            n.fw[i] = f.fw[i];
            f.fw[i] = n;
        }
    }

    public boolean erase(int num) {
        if(isEmpty()) return false;
        Node p = searchNode(num);
        if(p.val !=num) return false;
        for(int i=0;i<p.fw.length;i++){
            Node f = p.bw;
            while(f.bw!=null && f.fw.length<i+1) f = f.bw;
            if(i==0 && f.fw[i].fw[i]!=null) f.fw[i].fw[i].bw = f;
            f.fw[i] = f.fw[i].fw[i];
        }
        return true;
    }

    private Node searchNode(int target){
        if(isEmpty()) return head;
        Node p = head;
        for(int i=MAX_LEVEL;i>=0;i--) while(p.fw[i]!=null && p.fw[i].val<=target) p = p.fw[i];
        return p;
    }

    private boolean isEmpty(){
        return head.fw[0]==null;
    }
}

}
