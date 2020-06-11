package A12TopkElements;

import javafx.concurrent.Worker;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/24 2:02
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class A1 {

    static class WordTimes{
        String word;
        Integer times;
        WordTimes(String word, Integer value){
            this.word = word;
            this.times = value;
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"i","a","a","c","b","b","a"};
        List<String> strings = topKFrequent(strs, 2);// a b i
        System.out.println(strings);
    }
    /**
     * 1. 统计词频
     * 2. 构建最小堆
     * 3. 弹出答案
     */
    public static List<String> topKFrequent(String[] words, int k) {
        // 1. 构建词频
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        // 2. 构建最小堆
        PriorityQueue<String> minHeap = new PriorityQueue((o1, o2) ->
                (map.get(o1)-map.get(o2)==0?((String)o2).compareTo(((String)o1)):map.get(o1)-map.get(o2)));
        for (String word :map.keySet()){
            minHeap.add(word);
            if (minHeap.size()>k) minHeap.poll();
        }
        // 3. 弹出答案
        List<String> ans = new ArrayList<>();
        while (!minHeap.isEmpty()){
            ans.add(minHeap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
