package byted;



import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) {
        int k = arraykMax(new int[]{1,5,4,2,7}, 3); //
        System.out.print(k);
    }

    public static int arraykMax(int[] arr, int k){
        if (arr==null || arr.length==0)
            return -1;
        // 看题目如何定义
        if (arr.length<k){
            return -1;
        }
        // 最小堆
        PriorityQueue<Integer> q = new PriorityQueue();
        int size=0;
        for (int i=0;i<k;i++){
            q.add(arr[i]);
        }
        for (int i=k;i<arr.length;i++){
            int min = q.peek();
            if (arr[i]>min){
                q.remove();
                q.add(arr[i]);
            }
        }
        return q.remove();
    }
}
