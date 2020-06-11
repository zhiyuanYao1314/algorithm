package tree;

import javax.lang.model.type.ReferenceType;
import javax.xml.ws.EndpointReference;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Main13 {
    public static void main(String[] args) {

    }

    // 后续遍历的特性，最后一个元素是root点，
    //
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0) return false;
        return verify(sequence, 0, sequence.length-1);
    }
    private boolean verify(int[] sequence, int s, int e) {
        // 退出条件
        if (e-s<=1) return true;
        // 找到右子树
        int rootValue = sequence[e];
        int first = s;
        while (first<e){
            if (sequence[first]<rootValue) first++;
            else break;
        }
        // 如果右子树有<rootValue，return false;
        for (int i=first;i<e;i++){
            if (sequence[i]<rootValue) return false;
        }
        // 递归
        return verify(sequence, s,first-1) && verify(sequence, first,e-1);
    }
}
