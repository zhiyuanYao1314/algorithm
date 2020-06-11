package stack;

import com.sun.org.apache.bcel.internal.generic.PushInstruction;
import sort.Test;

import javax.swing.text.html.HTMLWriter;
import java.util.HashMap;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        System.out.println(main1.IsPopOrder(new int[]{1,2,3,4,5},new int[]{3,5,4,1,2}));
    }


    // 方法2：使用一个栈模拟放入弹出操作，
    // 如果符合， 就是 ，否则不是
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int pushIdex = 0, popIndex = 0; pushIdex<pushA.length;pushIdex++){
            // 依次放入元素
            stack.push(pushA[pushIdex]);
            // 如果和弹出元素相同，说明该元素被弹出。
            while (!stack.isEmpty() &&
                    popIndex<popA.length &&
                    stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    // 12345
    // 54321，45 321，3(54)(45)21...
    // 53 421, 升降。。
    // 注意判断，popA中的元素，pushA中不存在；
    // 该方法缺点： pushA的元素不相同！
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length==0) return false;
        if (pushA.length==1 && pushA[0]==popA[0]) return true;
        if (pushA.length==1 && pushA[0]!=popA[0]) return false;
        // 降； 升； 升降； 降升 错;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<pushA.length;i++){
            map.put(pushA[i],i); // 每个元素对应的放入位置
        }
        boolean up =false;
        if (map.get(popA[0] )== null|| map.get(popA[1] )== null) return false;
        if (map.get(popA[0])<map.get(popA[1])) up=true;
        for (int i=1;i<popA.length-1;i++){
            if (map.get(popA[i] )== null|| map.get(popA[i+1] )== null) return false;
            if (up){
                if (map.get(popA[i])>map.get(popA[i+1])){
                    up = false;
                }
            }else {
                if (map.get(popA[i])<map.get(popA[i+1])){
                    return false;
                }
            }
        }
        return true;
    }
}

