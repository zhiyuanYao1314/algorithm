package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Time:2020/4/22 13:46
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Main7 {
     /**
     * 利用hashmap放入，以sum-array[i]作为key， array[i]作为value放入
     * 每次放入前，先通过get(array[i])看是否存在，
     * 如果存在，就return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (array==null || array.length<2) return ans; //没有 返回空ans
        for (int i=0;i<array.length;i++){
            if (map.get(array[i])==null){
                map.put(sum- array[i],array[i]);
            }else {
                ans = new ArrayList<>();
                ans.add(sum-array[i]);
                ans.add( array[i]);
            }
        }
        return ans;
    }
}