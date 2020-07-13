package backTracking;


/**
 * 回溯算法：一层一层的处理所有的数据；
 *
 * 1.path 记录答案路径；k 记录当前已经处理到的数据，往往为数组的下标；
 * 2. 结束条件， ；
 * 3. 可选解空间
 *
 * time： 解空间* 层数
 * space：解空间* 层数
 */
public class Main0 {
    public static void main(String[] args) {
        /**
         *  easy   1. 给定一个数组和一个数，从数组中选择一些数，使其和等于给定的数。
         *              1.path当前放入的值，2.结束n==nums.length sum(ans)==k, 3.解空间，不再path中的下一个元素
         *  middle 2. 在一个矩阵中是否包含某字符串所有字符的路径。 开始找到一个相同的起点  1.n 当前遍历到的第几个元素    2.n==target.length true  3.同1 4.约束条件，当前已经走过的路不能再走  boolean[][]
         *  middle 3. 机器人能走多远。 1.path 当前的位置，boolean 已经访问过的点 2. 3. 解空间+check。 不算回溯，因为所有点不会往回走
         * easy    4. 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 1. path 2.path长度 3.给定的
         * middle  5. 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。--> 从10个led灯中选k个，找出所有满足条件的组合。 1.哪些led选择了 2. 已选择==k 3. 小时 分钟数满足条件
         * middle  6. 数独   注意：一排一排的放或者一列一列的放 1.原数组arr 2.所有数字放完，i=8 && j=9 所有放完 3. 满足条件，横竖小9
         * middle  7. N皇后问题。 一行一行的放 1.是否需要返回所有的位置  2.n=N+1  3. 横竖对角线不等于Q . 可以压缩空间为1维。
         * easy   8. 给定数组的全排列 1. path 2.n =N   3. 没用过的
         * easy  9. 囚犯重新排位置 不能相邻   一个位置一个位置的放 1. 2. 放完 3.要求新放入的元素不能和之前的元素存在和相邻
         * middle 10. 火柴成正方形。 分成4份，遍历所有元素放入。
         * middle 10.1. 数组分成n份相等。 同上。
         * middle 11 leetcode 三角形最小路径和
         * 12 全排列 没有重复的元素
         * 13 全排列，有重复的元素，最后结果需要去重
         * 14 组合， 可选解空间不一样
         * 15 第K个排列
         * 16 下一个排列
         */
    }
}