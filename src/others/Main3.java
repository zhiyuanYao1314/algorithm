package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/7/12 15:23
 *  第一个丢失的整数
 */
public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        int i = main3.firstMissingPositive(new int[]{ 1, 1});
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums){
        if(nums==null || nums.length==0)
            return 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            // 1. 在1,(n-1)范围内的元素放到对应的下标处
            while (nums[i]>=1 && nums[i]<=n-1 && i !=nums[i] && nums[i] != nums[nums[i]]){
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        // 2. 遍历，看下标对应的哪个元素不存在
        for (int i=1;i<n;i++){
            if (i!=nums[i]){
                return i;
            }
        }
        return nums[0]==n?n+1:n;
    }
}
