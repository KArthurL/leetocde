package DFS;

import java.util.ArrayList;
import java.util.List;

public class 连接词 {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode node = new TrieNode();
    public void insert(String s) {
        TrieNode cur = node;
        for(int i = 0; i < s.length(); i++)
        {
            int pos = s.charAt(i) - 'a';
            if(cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }

    List<String> res = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length == 0)
            return res;

        for(String word: words)
        {
            if(word.length() != 0)
                insert(word);
        }

        for(String word: words)
        {
            if(dfs(word, node, 0, 0))
                res.add(word);
        }
        return res;
    }

    public boolean dfs(String word, TrieNode cur, int count, int index) {
        for(int i = index; i < word.length(); i++)
        {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null)
                return false;
            cur = cur.children[pos];
            if(cur.isWord && dfs(word, node, count + 1, i + 1))
                return true;
        }
        return count > 0 && cur.isWord;
    }

}
