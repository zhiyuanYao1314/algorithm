package DP.fromRecursionToDP;

import com.sun.deploy.security.WIExplorerUntrustedCertStore;

import java.util.Stack;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/3 12:44
 * 不用额外空间， 逆序一个栈
 *
 */
public class A2 {
    // 每次弹出最底层的元素，然后每一层压栈
    void reverse(Stack s){
        if (s.isEmpty()) return;
        Object o = popDown(s);
        reverse(s);
        s.add(o);
    }

    /**
     * 每次弹出最底层的元素，上层元素不变，
     * @param s
     * @return
     */
    Object popDown(Stack s){
        Object pop = s.pop();
        if (s.isEmpty()){
            return pop;
        }
        Object ret = popDown(s);
        s.add(pop);
        return ret;
    }
}
