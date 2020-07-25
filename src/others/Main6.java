package others;

import sun.text.normalizer.Trie;
import trie.Trie2;

/**
 * 字典树（前缀树）的实现
 * 【题目】
 * 字典树又称为前缀树或Trie树，是处理字符串常见的数据结构。
 * 假设组成所有单词的字符仅是“
 * a
 * ”~“
 * z
 * ”
 * ，请实现字典树结构，
 * 并包含以下四个主要功能。
 * void insert(String word)：添加word，可重复添加。
 * void delete(String word)：删除word，如果word添
 * 加过多次，仅删除一个。
 * boolean search(String word)：查询word是否在字典
 * 树中。
 * int prefixNumber(String pre)：返回以字符串pre为
 * 前缀的单词数量。
 *
 *
 */
public class Main6 {
    public static void main(String[] args) {

    }
    class TrieNode{
        char c;
        int pass;
        int end;
        // 26个儿子;
        TrieNode[] children = new TrieNode[26];
        TrieNode(char c){
            this.c = c;
            pass = 0;
            end=0;
        }
    }
    TrieNode root = new TrieNode('0');
    /**
     * 添加word
     */
    void insert(String word){
        int i=0;
        int len = word.length();
        TrieNode cur = root;
        while (i<len){
            TrieNode c =cur.children[i-'a'];
            if (c==null){
                cur.children[i-'a']=new TrieNode(word.charAt(i));
            }else{
                c.pass++;
            }
            cur = cur.children[i-'a'];
            i++;
        }
        cur.end++;
    }

    /**
     * 需要将pass 也给删除！
     * @param word
     */
    void delete(String word){
        TrieNode cur = find(word);
        if (cur==null){
            return;
        }
        cur.end--;
    }

    private TrieNode find(String word){
        int i=0;
        int len = word.length();
        TrieNode cur = root;
        while (i<len){
            cur = cur.children[word.charAt(i)-'a'];
            i++;
            if (cur==null){
                return null;
            }
        }
        if (cur.end>0){
            return cur;
        }
        return null;
    }

    /**
     * 查找word是否在字典树中
     */
    boolean search(String word){
        return find(word)==null?false:true;
    }

    /**
     * 返回以字符串pre为前缀的单词数量；
     */
    int prefixNumber(String pre){
        TrieNode cur;
        return (cur = find(pre))==null?0:cur.pass;
    }
}
