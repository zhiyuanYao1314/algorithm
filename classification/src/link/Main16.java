package link;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 13:58
 *
 * 判断两链表的相交节点
 *
 */
public class Main16 {

    /**
     * 1. 判断两个链表是否有环，三情况：
     *      判断单个链表是否有环：快慢指针， 快指针从回头节点，一起运动；
     * 1.1 两个都没有环
     *  1.1.1 判断是否相交：尾节点是否相同？
     *    相同： 相交，a-b，走相同的路，到达公共节点；
     *    不同： return false;
     * 1.2 一个有环 一个无环
     *      return false;
     * 1.3 两个都有环
     *      loop1, loop2
     *      loop1==loop2;
     *          1.3.2 相交不在环上： return loop1;
     *      loop1走一圈，没遇到loop2:
     *         1.3.1 不相交：// 6 6
     *              return false;
     *      loop1走一圈，遇到loop2:
     *          1.3.3 相交在环上：// 6 rerurn loop1 || loop2;
     */


}
