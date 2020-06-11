package A7TreeBFS;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/20 14:03
 * LC 752打开转盘锁
 */
public class A7 {
    public static void main(String[] args) {
        String[] de = new String[]{"0201","0101","0102","1212","2002"};
        String tar = "0202";
        A7 a7 = new A7();
        int i = a7.openLock(de, tar);
        System.out.println(i);
    }

    public int openLock(String[] deadends, String target){
        Deque<String> q = new ArrayDeque(); //队列
        q.addLast("0000"); // 起始点
        Set<String> visited = new HashSet(); // 记录访问过的点
        // deadends可以理解为已经访问过的，不能再访问了
        for (String dead: deadends){
            visited.add(dead);
        }
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                String cur = q.removeFirst();
                if (target.equals(cur)) return step;
                for (int j=0;j<4;j++){
                    String up = upDail(cur,j);
                    if (!visited.contains(up)){
                        q.addLast(up);
                        visited.add(up);
                    }
                    String down = downDail(cur,j);
                    if (!visited.contains(down)){
                        q.addLast(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private String upDail(String cur,int i){
        char[] arr= cur.toCharArray();
        if (arr[i]=='9'){
            arr[i]='0';
        }else arr[i]+=1;
        return new String(arr);
    }
    private String downDail(String cur,int i){
        char[] arr= cur.toCharArray();
        if (arr[i]=='0'){
            arr[i]='9';
        }else arr[i]-=1;
        return new String(arr);
    }
}