package others;

import java.util.*;

/**
 * 给n个数，最多是m位，m小于20印象中，然后a&b=b，表示数a能包含数b，
 * 然后把这些数分堆，每堆只能有一个底座（也就是a&b=b的a），
 * 求这些数最少有几个这样的a就能把所有数都放在底座上（只要满足关系就行。。
 *
 * 思路：
 * b1, b2, b3...循环一遍：
 * 如果b1 | b2 == b1:
 *     直接抛弃b2; break；
 * 如果b1 | b2 == b2:
 *     删除b1, 插入b2, 继续循环；
 * 否则：
 *     继续
 * 所有的都没有相等：
 *      加入 b2;
 */
public class Main9 {

    public static void main(String[] args) {
        int[] bs1 = new int[]{0,2,4,8,16};
        int[] bs2 = new int[]{0,1,3,7};
        int ans1 = minum(bs1);
        int ans2 = minum(bs2);
        System.out.println(ans1); // 1;
        System.out.println(ans2); // 1;
    }

    static int minum(int[] bs){
        Set<Integer> ans = new HashSet<>();
        ans.add(bs[0]);
        for (int i=1;i<bs.length;i++){
            // 这里得用iterator
            Iterator<Integer> iterator = ans.iterator();
            while (iterator.hasNext()){
                Integer cur = iterator.next();
                if ((bs[i]|cur) ==bs[i] && (bs[i]!=cur)){
                    ans.remove(cur);
                    ans.add(bs[i]);
                }else if ((bs[i]|cur) ==cur){
                    break;
                }
//                else { // 1.不相交 或者 2.只有自己
//                }
            }
            ans.add(bs[i]);
        }
        return ans.size();
    }
}