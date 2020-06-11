package array;

/**
 * 求数组的最大子序列和
 */
public class Main1 {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,-1,2,3,-5,1}));
    }

    /**
     *思路：
     * 遍历一遍数组，记录下max和current sum，
     * current sum一直累加，直到<0， 则从头计算。
     *
     * 最大子序列和。 只要不小于0，就可以持续累加。
     */
    public static int sum(int[] arr){
        int max =arr[0];
        int sum =0;
        for (int i =0;i<arr.length;i++){
            if (sum >=0){
                sum +=arr[i];
            }else sum =arr[i];
            if (sum >max)max = sum;
        }
        return max;
    }
}
