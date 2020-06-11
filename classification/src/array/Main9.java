package array;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class Main9 {
    public static void main(String[] args) {
        Main9 main9 = new Main9();
        int[] ints = {1, 2, 2, 2, 3,3,2,2, 4};
        System.out.println(main9.MoreThanHalfNum_Solution(ints));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0) return 0;
        if (array.length==1) return array[0];
        HashMap<Integer, Integer> map = new HashMap();
        int size = array.length;
        for (int i=0;i<array.length;i++){
            if (map.get(array[i])==null){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i])+1);
                if (map.get(array[i])>size/2){
                    return array[i];
                }
            }
        }
        return 0;
    }
}
