package 图;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {


    public static void main(String[] args) {

    }

    public static void kruskal(){
        PriorityQueue<Edge> queue=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int count=scanner.nextInt();
        boolean[] flags=new boolean[m];
        for(int i=0;i<count;i++){
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            int weight=scanner.nextInt();
            Edge edge=new Edge(start,end,weight);
            queue.offer(edge);
        }
        int sum=0;
        int n=0;
        while(!queue.isEmpty()){
            Edge edge=queue.poll();
            if(flags[edge.end]&&flags[edge.start]){
                continue;
            }
            flags[edge.end]=true;
            flags[edge.start]=true;
            sum+=edge.weight;
            if(++n==m){
                break;
            }

        }
        System.out.println(sum);


    }


}

class Edge{
    int start;
    int end;
    int weight;
    public Edge(int start,int end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}
