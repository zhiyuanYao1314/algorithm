package array;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/22 0:14
 * 数字在排序数组中出现的次数
 */
public class Main13 {
    public static void main(String[] args) {
        int i = GetNumberOfK(new int[]{2, 2, 3, 4}, 1);
        System.out.println(i);
    }

    public static int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length==0) return 0;
        int s=0;
        int e = array.length-1;
        int mid = (s+e)/2;
        while (s<=e){
            if (array[mid]<k){
                s = mid+1;
            }else if (array[mid]>k){
                e = mid-1;
            }else{
                int llen = 0;
                while (mid-llen>=0 && array[mid-llen]==k){
                    llen++;
                }
                int rlen = 0;
                while (mid+rlen< array.length && array[mid+rlen]==k){
                    rlen++;
                }
                return 1+llen-1+rlen-1;
            }
            mid = (s+e)/2;
        }
        return 0;
    }
}
