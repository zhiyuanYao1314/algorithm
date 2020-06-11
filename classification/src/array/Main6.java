package array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口内的最大值
 */
public class Main6 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 2, 6, 2, 5, 1};
        Main6 main6 = new Main6();
        System.out.println(main6.maxInWindows(ints, 3));
    }

    /**
     *  使用一个大小为size的优先队列，
     *  然后遍历的时候，删除最前面的值和添加最新的值，
     *  然后将最大值加入到list中。
     *  num*log size
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if (size==0) return new ArrayList<>();
        int len = num.length;
        if (len < size) return new ArrayList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(heap.peek());

        for (int i = size; i < len; i++) {
            heap.remove(num[i - size]);
            heap.add(num[i]);
            System.out.println(heap.size());
            ans.add(heap.peek());
        }
        return ans;
    }
}
