package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 17:58
 * Describe:
 * version:1.0
 */
public class IncreasingArray {

    public static void main(String[] args) {
        IncreasingArray i = new IncreasingArray();
        int[] ints = { 4, 6, 3, 2, 1}; // 4 2 2=8
        System.out.println(i.increasingArray(ints));
    }

    /**
     * 注意细节。
     * @param array
     * @return
     */
    public long increasingArray (int[] array) {
        // write code here
        // 3 2 4 5 2  2 4
        //2+2
        long max =0;
        for (int i=0;i<array.length-1;i++){
            if (array[i+1]< array[i]){
                max += array[i]-array[i+1]+1;
            }
        }
        return max;
    }
}
