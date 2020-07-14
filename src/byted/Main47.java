package byted;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 179 最大数
 * 将数组中的数组成最大数；
 * 直接两个数相加， 小的放前面；
 */
public class Main47 {
    public static void main(String[] args) {
        String s = largestNumber(new int[]{45,456,32});
        System.out.println(s);
    }

    /**
     * 3412 > 1234
     * 从大到小
     */
    public static String largestNumber(int[] nums) {
        int n= nums.length;
        Integer[] ns = new Integer[n];
        int i=0;
        for (Integer in: nums){
            ns[i++] = in;
        }
        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { // 45456 45645
                return (o2+""+o1).compareTo(o1+""+o2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int k : ns){
            sb.append(k);
        }
        return sb.toString();
    }

}
