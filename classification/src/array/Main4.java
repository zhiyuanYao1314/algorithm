package array;

/**
 * 查找数组中的重复元素(数组中的)
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Main4 {
    //
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        // 0, 1, 2, 3, 2, 5, 3
        System.out.println(duplicate(arr));
    }

    /**
     * 一遍遍历，
     * 交换当前位置的值到以它作为下标的位置的值。
     * 交换前判断以该值作为下标的值是否和本身相同，如果相同，就重复了。
     */
    public static int duplicate(int[] arr){
        for (int i=0;i<arr.length;i++){
            if (i != arr[i] && arr[(arr[i])]== arr[i]){
                return arr[i];
            }
            while (arr[i] != i){
                int tmp= arr[i];  // 3
                arr[i] = arr[arr[i]]; //a0= 0
                arr[tmp] = tmp; // a3 = 3
            }
        }
        return -1;
    }
}
