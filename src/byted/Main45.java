package byted;

/**
 *  41 缺失的第一个正数
 *
 *  修改bug 修的有点乱了，需要重新捋一下逻辑！
 */
public class Main45 {

    public static void main(String[] args) {
        Main45 main45 = new Main45();
        int k = main45.firstMissingPositive(new int[]{3,4,-1,1});
        System.out.println(k);

    }

    // [3,4,-1,1]
    public int firstMissingPositive(int[] nums) {
        if (nums==null || nums.length==0)
            return 1;
        int n= nums.length;
        int i=0;
        boolean hasN =false;
        while (i<nums.length){
            if (nums[i]<n && nums[i]>0 && i != nums[i]){
                if (nums[i]== nums[nums[i]]){
                    i++;
                    continue;
                }
                swap(nums, i, nums[i]);
            }else{
                if (nums[i]==n){
                    hasN = true;
                }
                i++;
            }
        }
        for (int j=1;j<nums.length;j++){
            if (j!=nums[j]){
                return j;
            }
        }
        return hasN?n+1:n;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
