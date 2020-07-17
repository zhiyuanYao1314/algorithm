package byted;

/**
 * 1299 将每个元素替换成右侧最大元素
 *
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 * 示例：
 *
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 */
public class main70 {

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] max = new int[n];
        max[n-1] = -1;
        for (int i=n-2;i>=0;i--){
            max[i] = Math.max(max[i+1], arr[i+1]);
        }
        return max;
    }
}
