package xiecheng;

import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 11:51
 * Describe:
 * version:1.0
 */
public class XieCheng {

    /**
     * 1.负数的二进制表示是正数取反加1，这样的话，二进制可以直接加减运算
     * 2. 正数的最大值+1变成最小值，负数的最小值减一是最大值
     * 3. 正数的最大值是01111111,127;负数的最小值是10000000, -128 (取反加1就是128)
     *    11111111表示-1 （因为取反+1表示1）
     *
     * 4. 位运算：
     *   &与 |或 ^异或 相同为0，不同为1；~取反；<<左移；>>右移
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int cnt =0;
        while (n != 0){
            cnt ++;
            n= n&(n-1);
        }
        System.out.println(cnt);
    }
}
