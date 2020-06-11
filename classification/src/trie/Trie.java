package trie;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/28 18:15
 * Describe:
 * version:1.0
 */
class Trie {
    static class Node{
        boolean end;
        Node[] children = new Node[26];
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word==null || word.length()==0) return;
        Node cur = root;
        char[] chars = word.toCharArray();
        int index=0;
        for (int i=0;i<chars.length;i++){
             index= chars[i]-'a';
            if (cur.children[index]==null){
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.end=true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word==null || word.length()==0)return false;
        char[] chars = word.toCharArray();
        Node cur = root;
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if (cur.children[index]==null){
                return false;
            }
            cur = cur.children[index];
        }
        return cur.end==true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // 有任何单词依次开头！
        if (prefix==null || prefix.length()==0)return true;
        char[] chars = prefix.toCharArray();
        Node cur = root;
        for (int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if (cur.children[index]==null){
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }
}