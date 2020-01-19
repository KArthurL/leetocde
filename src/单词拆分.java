import java.util.HashSet;
import java.util.List;

public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dic = new HashSet(wordDict);
        boolean[] d = new boolean[s.length()];

        for (int i = 1; i < d.length + 1; i++) {
            if (dic.contains(s.substring(0, i))) {
                d[i - 1] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {

                if (d[j] && dic.contains(s.substring(j + 1, i))) {
                    d[i - 1] = true;
                    break;
                }
            }

        }

        return d[d.length - 1];
    }


}
