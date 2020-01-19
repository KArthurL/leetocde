import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);    // 该操作会使得密钥 2 作废// 返回 -1 (未找到)
        cache.put(4, 3);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(2);       // 返回  3


    }
    private Map<Integer,Node> map;
    private int c;
    private Node head;
    private Node last;
    class Node{
        int val;
        int key;
        Node next;
        Node pre;
    }

    public LRUCache(int capacity) {
        map=new HashMap<>();
        c=capacity;
        head=new Node();
        last=new Node();
        head.next=last;
        last.pre=head;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node=map.get(key);
            remove(node);
            addFirst(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node=new Node();
        node.val=value;
        node.key=key;
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        map.put(key,node);
        addFirst(node);
        if(map.size()>c){
            removeLast();
        }

    }
    public void addFirst(Node node){
        Node temp=head.next;
        head.next=node;
        node.pre=head;
        node.next=temp;
        temp.pre=node;
    }
    public void remove(Node node){
        node.next.pre=node.pre;
        node.pre.next=node.next;

    }
    public void removeLast(){
        int key=last.pre.key;
        remove(last.pre);
        map.remove(key);
    }


}
