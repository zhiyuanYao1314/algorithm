package kuaishou;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/9 16:20
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1-5,，4-6和7-8.
 *
 * 算法到底考的是什么?
 * 各种解题技巧 与 题型的对应关系；
 * 常见细节的处理 等！
 * 如：看到连续 第一反应 双指针； 第二反应 dp；
 * 然后还有定义好 每一个变量的含义！
 *
 */
public class Main6 {
    public static void main(String[] args) {
    }

    /**
     * 思路: 双指针
     * s, e
     */
    public List<List<Integer>> getAllIns(int tar){
        int s =1;
        int e =2;
        int sum = s+e;
        List<List<Integer>> ans = new ArrayList<>();
        while (e<tar){
            // sum +=e;
            if (tar==sum){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(s);
                tmp.add(e);
                ans.add(tmp);
                s++;
                e++;
                sum -=s;
                sum +=e;
            }else if (sum<tar){
                e++;
                sum +=e;
            }else {
                s++;
                sum -=s;
            }
        }
        return ans;
    }
}
