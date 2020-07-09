import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 回溯算法
 * 套路：
 *  参数：记录当前的位置，核实结束，当前位置的可选值；
 *  1. 字符串的全排列;
 *  2. 数组的全排列；
 *  3. 数组的全排列（去重）
 *  4. 数组的所有子序列
 *  5. N皇后等。。
 */
public class Test7 {

    public static void main(String[] args) {

    }

    // s 当前的str的层数，
    // 1. 字符串的全排列
    List<String> ret1 = new ArrayList<>();
    void dfs1(String str, int s, String path, Set<Integer> used){
        if (s== str.length()){
            ret1.add(path);
            return;
        }
        for (int i=0;i<str.length();i++){

            if (used.contains(i))
                continue;
            String cur =path + str.charAt(i);
            used.add(i);
            dfs1(str, s+1, cur, used);
            used.remove(i);
        }
    }

    // 2. 数组的全排列
    List<String> ret2 = new ArrayList<>();
    void dfs2(int[] arr, int s, String path, Set<Integer> used){

    }

    // 3. 数组的全排列（去重！）
    // 每一层里面记录一个set， 保证该层只使用一个数字

    // 4. 数组的所有子序列
    // 每一层都添加

    /**
     * 调用 dfs3(arr, 0, "", new Set());
     * @param arr 数组
     * @param index 下标
     * @param path 添加的路径
     * @param used 已经使用的下标
     */
    List<String> ret3 = new ArrayList<>();
    void dfs3(String str, int index, String path, Set<Integer> used){
        if (index==str.length())
            return;
        ret3.add(path);
        // 遍历
        for (int i=0;i<str.length();i++){
            if (used.contains(i))
                continue;
            String cur =path + str.charAt(i);
            used.add(i);
            dfs1(str, index+1, cur, used);
            used.remove(i);
        }
    }
}
