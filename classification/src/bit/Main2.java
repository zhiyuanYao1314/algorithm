package bit;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 14:50
 */
/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 14:44
 * 返回一个整数转化为二进制后1的个数；
 */
public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int i = main2.hammingWeight(-3);
        System.out.println(i);
    }
    // n ^n-1
    public int hammingWeight(int n) {
        int count =0;
        while (n!=0){
            ++count;
            n &=(n-1);
        }
        return count;
    }

}