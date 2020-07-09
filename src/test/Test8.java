package test;

import org.omg.CORBA.INTERNAL;

import javax.xml.bind.annotation.XmlInlineBinaryData;

/**
 *
 */
public class Test8 {

    /**
     * & n&(n-1) 去除最右边的1剩余的数字
     *   n&（-n）得到数字最右边的1
     * ｜
     *  ~
     *  ^ 相同为0
     *  >> 算数位移， 保留符号；
     *  >>> 无符号右移，不保留符号；
     *
     *
     */
//    public static void main(String[] args) {
//        int n =9;
//        Integer.bitCount(n);
//        Integer.highestOneBit(n);
//        Integer.toBinaryString(n);
//
//    }

    // 1. 两个二进制表示有多少位不同
    public  int hammingDistance(int x, int y){
        int c = x^y;
        int count =0;
        while (c!=0){
            ++ count;
            c = c&(c-1); // 每次去除一个1；
        }
        return  count;
    }
    // 2.数组中唯一不重复的数字
    public int singleNum(int[] nums){
        int ret=0;
        for (int i:nums) ret ^=i;
        return ret;
    }

    // 3. 数组中的两个不重复的数字



    // 4. 唯一不重复三次的数字
    public int singleOfThree(int[] nums){
        // int  是 4*8 =32；
        int ret=0;
        for (int i=0;i<32;i++){
            int count=0;
            for (int j=0;j<nums.length;j++){
                count += (nums[j] &1);
                nums[j] >>>= 1;
            }
            //
            if (count %3==0){
                ret |=(1<<i);
            }else
                ret |=0;
//            ret<<=1;
        }
        return ret;
    }

    // 5. 找出数组中缺失的那个数；

    // 6。 反转比特位；
    public int reverseBit(int n ){
        int ret=0;
        for (int i=0;i<32;i++){
            ret<<=1;
            ret |= (n & 1);
            n>>>=1;
        }
        return ret;
    }
    public static void swith(){
        int[] arr =  new int[]{1};
        arr[0] = arr[0]^arr[0];
        arr[0] = arr[0]^arr[0];
        arr[0] = arr[0]^arr[0];
//        Integer a =arr[0];
//        Integer b = arr[0]; //
//        a = a^b;
//        b = a^b;
//        a = a^b;
        System.out.println(arr[0]+"-"+arr[0]);
    }

    public static void main(String[] args) {
        swith();
    }




}
