package csig;

import java.util.*;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/9/6 13:53
 *
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 *
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 *
 *
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 *
 *
 * 6
 * 5 3 8 3 2 5
 *
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");


        int[] nums  = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = new Integer(strs[i]);
        }
        int[] res = count(nums);
        StringBuffer show =new StringBuffer();
        for (int i=0;i<n;i++){
            show.append(res[i]+" ");
        }
        System.out.println(show.substring(0,show.length()-1));
    }

    static int[] count(int[] nums){
        int n = nums.length;
        int[] left = countVisible(nums);
        // System.out.println(Arrays.toString(left));
        int[] rev = new int[n];
        for (int i=0;i<n;i++){
            rev[i] = nums[n-i-1];
        }
        int[] right = countVisible(rev);

        int[] res = new int[n];
        for (int i=0;i<n;i++){
            res[i] = left[i]+right[n-1-i]+1;
        }
        return res;
    }

    // 单调递增
    static int[] countVisible(int[] nums){
        Deque<Integer> stack = new ArrayDeque();
        int n = nums.length;
        int[] res= new int[n];
        int s =1;
        for (int i=0;i<n;i++){
            if (stack.isEmpty()){
                stack.addLast(nums[i]);
            }else if (stack.peekLast()>nums[i]){
                stack.addLast(nums[i]);
            }else {
                while (!stack.isEmpty() && stack.peekLast()<=nums[i]){
                    stack.pollLast();
                }
                stack.addLast(nums[i]);
            }
            res[s] =stack.size();
            if (++s>=n){
                break;
            }
        }
        return res;
    }




}
