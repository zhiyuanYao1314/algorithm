package others;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 *
 * 给定一个数组arr，和一个整数num，求在arr中，累加和等于num的最长 子数组的长度
 * 例子：
 * arr = {7,3,2,1,1,7,7,7}
 * num = 7 其中有很多的子数组累加和等于7，但是最长的子数组是{3,2,1,1}，所 以返回其长度4
 * 字数组要求连续
 *
 * 可以存储所有元素的累加和及其下标；
 */
public class Main7 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,4,3,2,1,1,7,1,7,7};
        int i = zzzi_sumisit(arr, 7);
        System.out.println(i);
    }
    public static int zzzi_sumisit(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hashMap.containsKey(sum - k)) {
                len = Math.max(i - hashMap.get(sum - k), len);
            }
            // 3   5   6   7
            // 3,0;5,1;6,2;7,3;
            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }
        return len;
    }
}
