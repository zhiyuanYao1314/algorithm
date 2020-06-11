package A18Threads.A2ThreadPool;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/9 15:08
 * 任务： 判断一个list俩面元素是否为质素
 */
public class A6ParallelStreamAPI {

    static ArrayList<Integer> list = new ArrayList<>(10000);
    static Random r = new Random();
    static {
        for (int i=0;i<list.size();i++){
            list.add(10000+r.nextInt());
        }
    }
    public static void main(String[] args) {
        // 第一种方式
        long start = System.currentTimeMillis();
        list.forEach(v-> isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        // 第二种方式
        start = System.currentTimeMillis();
        list.parallelStream().forEach(A6ParallelStreamAPI::isPrime);
        end = System.currentTimeMillis();
        System.out.println(end-start);

    }
    public static boolean isPrime(int num){
        for (int i=2;i<num/2;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
