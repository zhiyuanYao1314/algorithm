package greed;

import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/30 13:16
 * LC 179 最大数
 *  将数组里面的元素拼接成一个最大数字
 */
public class A4 {

    public static void main(String[] args) {
        A4 a4 = new A4();
        String s = a4.largestNumber(new int[]{0,0,0});
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        if (nums==null || nums.length==0) return "";
        String[] strs = new String[nums.length];
        int j=0;
        for (int i:nums){
            strs[j++] =i+""; //  String.valueOf(i);
        }
        Arrays.sort(strs, (o1,o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        StringBuffer ret=new StringBuffer();
        if (strs[0].equals("0"))
            return "0";
        for (int i=0;i<strs.length;i++){
            ret.append(strs[i]);
        }
        return ret.toString();
    }

}
