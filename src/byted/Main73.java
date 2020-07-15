package byted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350 两个数组的交集
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 */
public class Main73 {
    public static void main(String[] args) {
        Main73 m = new Main73();
        int[] n1= new int[]{1,2,2,5,6,67};
        int[] n2 = new int[]{1,2,2,4,5,5};
        int[] ans = m.intersect2(n1, n2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2){
            int n = map.getOrDefault(num, 0)+1;
            map.put(num ,n);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num: nums1){
            if (map.containsKey(num)){
                ans.add(num);
                map.put(num, map.get(num)-1);
                if (map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        int[] ret = new int[ans.size()];
        int i=0;
        for (int a:ans){
            ret[i++] = a;
        }
        return ret;
    }

    // 两个数组排好序
    public int[] intersect2(int[] nums1, int[] nums2) {
        int s1 =0;
        int s2 =0;
        List<Integer> ans = new ArrayList<>();
        while (s1<=nums1.length && s2<nums2.length){
            if (nums1[s1]==nums2[s2]){
                ans.add(nums1[s1]);
                s1++;
                s2++;
            }else if(nums1[s1]<nums2[s2]){
                s1++;
            }else {
                s2++;
            }
        }
        int[] ret = new int[ans.size()];
        int i=0;
        for (int a:ans){
            ret[i++] = a;
        }
        return ret;
    }


}
