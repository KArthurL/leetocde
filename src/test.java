import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class test {

    //请用java实现以下shell脚本的功能
//uniq -c 记录重复次数
//cat /home/admin/logs/biz.log | grep "Login" | uniq -c | sort -nr
//
//假设biz.log内容如下：
//User11 Login
//User22 Login
//User11 Login
//User11 22 LogOff
//
//则输出：
//User11 Login：2
//User22 Login：1
//
//
//题目链接仅2个小时的有效期，建议复制题目到本地。面试官后续会提供一个新的链接。



    private static void help(List<String> list){

        HashMap<String, Integer> map=new HashMap<>();
        PriorityQueue<String> queue=new PriorityQueue<>((((o1, o2) -> map.get(o2)-map.get(o1))));
        for(String s:list){
            if(s.contains("Login")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for(String s:map.keySet()){
            queue.offer(s);
        }

        while(queue.size()>0){
            String key=queue.poll();
            System.out.println(key+": "+map.get(key));
        }
    }
    private static void uniqAndSort(String path) throws IOException {

        List<String> list=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new FileReader(path));
        String line;
        while((line=bufferedReader.readLine())!=null){
            if(line.contains("Login")){
                list.add(line);
            }
        }
        help(list);
    }

    public static void main(String[] args) throws IOException {
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
    }

}
