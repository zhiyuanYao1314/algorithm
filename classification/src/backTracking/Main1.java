package backTracking;

import java.util.ArrayList;

/**
 * 给定一个数组和一个数，从数组中选择一些数，使其和等于给定的数。
 * 没有返回[]
 */
public class Main1 {
    // public static void main(String[] args) {
    //     int[] arr = {1, 4, 4};
    //     sum(arr, 7,0);
    //     System.out.println(ans);
    // }
    //
    // // 1 3 4 ...7
    // static ArrayList<Integer> ans = new ArrayList<>();
    //
    // /**
    //  * 回溯法，
    //  * @param arr 数组，
    //  * @param target 目标
    //  * @param s 剩余可使用的数组子元素的起始点。
    //  * @return 是否达到目标值
    //  */
    // public static boolean sum(int[] arr, int target, int s){
    //     if (target==0) return true;
    //     if (s>arr.length) return false;
    //     for (int i=s;i<arr.length;i++){
    //         if (target>=arr[i]){
    //             ans.add(arr[i]);
    //             if (sum(arr, target-arr[i],s+1)){
    //                 return true;
    //             }else {
    //                 ans.remove((Integer) arr[i]);
    //             }
    //         }else continue;
    //     }
    //     return false;
    // }

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        boolean sum = main1.sum(new int[]{1, 3, 5}, -10);
        System.out.println(sum);
    }
    public boolean sum(int[] arr, int target){
        if (arr==null || arr.length==0)
            return false;
        return dfs(arr, target, 0, 0);
    }

    private boolean dfs(int[] arr, int target, int sum ,int s){
        if (sum== target)
            return true;
        if (s== arr.length+1)
            return false;
        for (int i=s;i<arr.length;i++){
            sum += arr[i];
            if (dfs(arr, target, sum ,i+1))
                return true;
            sum -= arr[i];
        }
        return false;
    }
}
