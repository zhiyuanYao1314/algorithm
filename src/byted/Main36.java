package byted;

/**
 * 108 将有序数组转换为二叉搜索树
 *
 * 先序遍历
 */
/**
 * 108 将有序数组转换为二叉搜索树
 * 先序pre遍历
 */

/**
 *
 [0,-10,5,null,-3,null,9]
 */
public class Main36 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null)
            return null;
        return help(nums, 0, nums.length-1);
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left>right)
            return null;
        int mid = left + ((right-left)>>1);
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = help(nums, left, mid-1);
        cur.right = help(nums, mid+1, right);
        return cur;
    }
}