package byted;

/**
 *  41 缺失的第一个正数
 */
public class Main45 {

    public static void main(String[] args) {
        Main45 main45 = new Main45();
        int k = main45.firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(k);

    }
    // 0---n-1,  1--n-1
    // 都在 就返回n；
    public int firstMissingPositive(int[] nums){
        if (nums==null || nums.length==0){
            return 1;
        }
        int n= nums.length;
        //1. 每个元素交换到自己对应的下标的位置上
        for (int i=0;i<n;i++){
            while (nums[i]>=1 && nums[i]<=n-1 && nums[i] != nums[nums[i]]){
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        // 2. 遍历查看哪个元素丢失了
        for (int i=1;i<n;i++){
            if (i !=nums[i]){
                return i;
            }
        }
        return nums[0] == n?n+1:n;
    }

}
