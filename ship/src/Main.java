//题目1:编程题目
// 请编写一个红包随机算法。需求为：给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额。
//         比如100元的红包，10个人抢，每人分得一些金额。
//         约束条件为，最佳手气金额不能超过最大金额的90%。请给出java实现。谢谢。



// 1.红包随机算法

import java.util.Arrays;

public class Main{

    public static void main(String[] args){
        Math.random();
        double[] men = divide(100,10);
        System.out.println(Arrays.toString(men));
        double sum =0;
        for (double k:men){
            sum +=k;
        }
        System.out.println(sum );
    }

    /**
     * total 总的金钱数，n 人数
     * 返回值double[] 每个人收到的金钱数
     **/
    public static double[] divide(double total, int n){
        double[] man = new double[n];
        double sum =0;
        for (int i=0;i<n;i++){
            double random = Math.random(); //[0,1)
            man[i] = random;
            sum +=man[i];
        }

        for(int i=0;i<n;i++){
            // 控制每个人红包占比不超过90%
            double percent = man[i]/sum;
            while(percent>0.9){
                double tmp = Math.random();
                sum = sum + tmp - man[i];
                man[i] = tmp;
                percent = man[i]/sum;
            }
        }
        double sub=0;
        for(int i=0;i<n-1;i++){
            man[i] = (man[i]/sum) *total;
            sub +=man[i];
        }
        System.out.println(Arrays.toString(man));
        man[n-1] = total-sub;
        return man;
    }


}