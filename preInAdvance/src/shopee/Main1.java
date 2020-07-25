package shopee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 数组组成数字；
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        int n = new Integer(ss);
        Integer[] nums = new Integer[n];
        String str = sc.nextLine();
        String[] strs = str.split(",");
        for (int i=0;i<n;i++){
            nums[i] = new Integer(strs[i]);
        }
        // System.out.println(Arrays.toString(nums));
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ((int)o2+""+(int)o1).compareTo((int)o1+""+(int)o2);
            }
        });
        // System.out.println("-------");
        // System.out.println(Arrays.toString(nums));
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<n;i++){
            sb.append(nums[i]);
        }
        System.out.println(sb.toString());
    }

}
