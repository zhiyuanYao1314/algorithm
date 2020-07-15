package byted;

/**
 * 503 下一个更大元素II
 */
public class Main61 {

    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] ret = new int[n];
        for (int i=0;i<n;i++){
            int index = next(i, n);
            int cur = nums[i];
            while (nums[index]<=cur){ // 4
                index = next(index, n);
                if (index==i){
                    ret[i] = -1;
                    break;
                }
            }
            if (index!=i)
                ret[i] = nums[next(index, n)];
        }
        return ret;
    }
    public int next(int i, int n){ //++i=4, 3
        if (++i==n){
            return 0;
        }
        return i;
    }

}
