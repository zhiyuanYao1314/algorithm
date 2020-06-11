package trie;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/28 18:35
 * 实现一个trie树，
 * 该树可以插入，元素可以重复；
 * 删除元素， 删除不存在的元素返回false；存在返回true
 * 还可以判断以某str开头的单词的数量；
 * pass; end;
 */
public class Trie2 {
    class Node{
        int pass;
        int end;
        Node[] children = new Node[26];
    }
    Node root;
    public Trie2(){
        root = new Node();
    }

    //插入
    void insert(String word){
        if (word==null || word.length()==0) return;
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if (cur.children[index]==null){
                cur.children[index]= new Node();
            }
            cur.children[index].pass +=1;
            cur = cur.children[index];
        }
        cur.end++;
    }
    // 删除
    boolean delete(String word){
        if (word==null || word.length()==0) return true;
        if (!contains(word)) return false;
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            cur.children[index].pass -=1;
            if (cur.children[index].pass==0){
                cur.children[index]=null;
                return true;
            }
            cur = cur.children[index];
        }
        cur.end--;
        return true;
    }

    // 是否存在
    boolean contains(String word){
        if (word==null || word.length()==0) return true;
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if (cur.children[index]==null){
                return false;
            }
            cur = cur.children[index];
        }
        return cur.end!=0;
    }

    // 包含前缀的单词数量
    int startWith(String word){
        if (word==null|| word.length()==0) return 0;
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if (cur.children[index]==null){
                return 0;
            }
            cur = cur.children[index];
        }
        return cur.pass;
    }
}
