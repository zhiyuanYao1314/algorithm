package others;

import java.util.HashMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 20:40
 * Describe:
 * version:1.0
 */
public class ArraySum {

    public static void main(String[] args) {
        ArraySum as = new ArraySum();
        int[] a= new int[]{1,2,3,4};
        int[] b= new int[]{2,1,4,5};
        System.out.println(as.countLR2(a,b));

        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println(map.getOrDefault(2,5));
        map.put(2,3);
        System.out.println(map.get(2));

    }

    /**
     *  len^3
     * @param a
     * @param b
     * @return
     */
    public int countLR (int[] a, int[] b) {
        // write code here
        int len = a.length;
        int count=0;
        for (int i=0;i<len;i++){
            for (int j=i;j<len;j++){
                int sum1=0;
                for (int k=i;k<=j;k++){
                    sum1 +=a[k];
                }
                int sum2 = b[i]+b[j];
                if (sum1 == sum2) count++;
            }
        }
        return count;
    }

    /**
     * time: len^2,
     * space:
     * @param a
     * @param b
     * @return
     */
    public int countLR2 (int[] a, int[] b) {
        int count=0;
        int len = a.length;
        for (int k=0;k<len;k++){
            int sum =0;
            for (int i=k;i<len;i++){
                sum += a[i];
                if (sum == b[k]+b[i]) count++;
            }
        }
        return count;
    }


    public  int countLR3 (int[] a, int[] b){

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,3);
        System.out.println(map.getOrDefault(1,5));

        return 0;
    }
}
