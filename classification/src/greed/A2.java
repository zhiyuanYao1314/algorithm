package greed;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/18 17:13
 * LC45 跳跃游戏2
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class A2 {
    /**
     * 解法1：动态规划，复杂度太高，使用贪心算法，从最后一步起，向前推！
     *
     * 如果nums[i] 和nums[j]都能达到最后一个位置，i<j, 那么从0到i的步数<=从0到j的步数
     *
     * 总是从前往后看 哪个位置可以直接一步到达？
     * 因为前面一步能到达的总是最好的。
     *
     */
    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int position = nums.length-1;
        int step =0;
        // 退出条件，走到了开头的位置
        while (position!=0){
            for (int i=0;i<position;i++){ // 当前的可选解
                if(i+nums[i]>=position){ // 局部最优
                    position=i; // 更新状态
                    ++step;
                }
            }
        }
        return step;
    }
}
