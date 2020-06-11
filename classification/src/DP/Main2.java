package DP;

import com.sun.xml.internal.ws.message.stream.StreamAttachment;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/**
 *
 * 给定S, A, B, P, 初始arr[0] = S, 接下来arr[i+1] = (arr[i] * A + B) % P,
 * 并且arr数组里的每个数字最多出现两次，当某个数字出现3次时，终止序列生成。
 * 给定两组S, A, B, P分别生成两个序列，求两个序列的最长公共子序列
 *  S A B P
 *  S A B P
 */
public class Main2 {
    public static void main(String[] args) {

    }

    // 1357 1547
    public static ArrayList<Integer> gene(int S, int A, int B, int P){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(S);
        return null;

    }

}
