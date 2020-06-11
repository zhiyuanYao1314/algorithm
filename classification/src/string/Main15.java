package string;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.logging.Level;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 12:06
 * leetcode 451 根据字符出现频率排序
 */
public class Main15 {

    /**
     * 1. 统计词频 n， s的长度
     * 2. 根据词频构建大顶堆 mlogM, m是最大256
     * 3. 依次弹出，取出答案 mlogM;
     */
    public String frequencySort(String s){
        if (s==null || s.length()==0) return "";
        PriorityQueue<Letter> maxheap = new PriorityQueue<>();
        int[] counts = new int[256];
        for (Character c:s.toCharArray()){
            counts[c]++;
        }
        for (int i=0;i<counts.length;i++){
            if (counts[i]==0) continue;
            maxheap.add(new Letter((char)i, counts[i]));
        }
        StringBuffer ans = new StringBuffer();
        while (!maxheap.isEmpty()){
            Letter cur = maxheap.poll();
            int len = cur.count;
            while (len-->0){
                ans.append(cur.c);
            }

        }
        return ans.toString();
    }
    class Letter implements Comparable{
        char c;
        int count;
        Letter(char c, int count){
            this.c = c;
            this.count = count;
        }
        @Override
        public int compareTo(Object o) {
            return ((Letter)o).count-this.count;
        }
    }

}
