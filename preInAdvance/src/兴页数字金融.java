import java.util.Scanner;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/7/12 13:03
 * Describe:
 * version:1.0
 *  单选：40*1；
 *  多选：15*2；
 *  问答：2*5；
 *  算法：20；
 * 算法：
 *  给定一个正整数n, 找出离他最近的对称数(如：5， 101，11).
 *  要求，如果输入不合法，返回ERROR,
 *  如果有多个，以逗号分割。
 *
 *  吸取教训:
 *  1. 刚开始就想到了，中间向两边扩展，思路是对的。
 *  但是，没有注意题目描述，即：输入不合法，和多个以逗号分割的问题，导致没有全部ac。
 */
public class 兴页数字金融 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            int n =0;
            try {
                n= new Integer(s);
            } catch (Exception e){
                System.out.println("ERROR");
                return;
            }
            if (n<=0){
                System.out.println("ERROR");
                return;
            }
            if (isCyc(n)){
                System.out.println(n);
                return;
            }
            int min = n-1;
            int more = n+1;

            while (min>=0 || more<=Integer.MAX_VALUE){
                if (min>=0 && isCyc(min)){
                    System.out.print(min);
                    if (more<=Integer.MAX_VALUE && isCyc(more)){
                        System.out.println(","+more);
                    }
                    return;
                }
                if (more<=Integer.MAX_VALUE && isCyc(more)){
                    System.out.println(more);
                    return;
                }
                if (min>=0)
                    min--;
                if (more<=Integer.MAX_VALUE)
                    more++;
            }

        }

        public static boolean isCyc(int n){
            String s = n+"";
            int left=0;
            int right=s.length()-1;
            while (left<right ){
                if (s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

