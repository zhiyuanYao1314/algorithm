package stack;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureECDSA;
import sun.security.action.PutAllAction;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 15:04
 *数组实现栈； 规定栈的大小；一个index记录put的位置和get的位置；
 */
public class Main6 {
    int[] nums;
    int cap;
    int index; // 表示放入的位置；
    Main6(int cap){
        this.cap =cap;
        nums = new int[cap];
    }
    void put(int n ){
        if (index==cap){
            throw new RuntimeException("元素满了");
        }
        nums[index++]= n;
    }
    int get(){
        return nums[--index];
    }
}
