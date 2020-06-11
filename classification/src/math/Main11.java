package math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 21:59
 * 根据数字二进制下 1 的数目排序
 *
 */
public class Main11 {
    /**
     * 直接调用快排，改写一下排序的规则
     * 数学点在与 计算1的数量
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        if (arr==null || arr.length==0) return new int[0];
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int diff = numOf1((Integer) o1) - numOf1((Integer) o2);
                if (diff == 0) return (Integer) o1 - (Integer) o2;
                return diff;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmp[i];
        }
        return arr;
    }

    public int numOf1(int n){
        int count =0;
        while (n!=0){
            n &=n-1;
            count++;
        }
        return count;
    }
}
