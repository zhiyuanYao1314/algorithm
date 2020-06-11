package link;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/25 12:25
 *
 * 将单链表按某值划分成左边小，中间相等，右边大的形式
 *
 */
public class Main14 {

    /**
     * 利用数组转化为荷兰国旗问题，然后再将链表接连起来
     */
    ListNode listPartition1(ListNode head, int pivot){
        return null;
    }


    /**
     * 6个指针
     */
    ListNode listPartition2(ListNode head, int pivot){
        // 小于pivot的头和尾
        ListNode sH = null;
        ListNode sT = null;
        // 等于pivot的头和尾
        ListNode eH = null;
        ListNode eT = null;
        // 大于pivot的头和尾
        ListNode mH = null;
        ListNode mT = null;
        ListNode cur = head;

        while (cur != null){
            if (cur.val<pivot){
                if (sH==null){
                    sH = cur;
                    sT = cur;
                }else {
                    sT.next = cur;
                    sT = cur;
                }
            }else if (cur.val==pivot){
                if (eH==null){
                    eH = cur;
                    eT = cur;
                }else {
                    eT.next = cur;
                    eT = cur;
                }
            }else {
                if (mH==null){
                    mH = cur;
                    mT = cur;
                }else {
                    mT.next = cur;
                    mT = cur;
                }
            }
        }
        // 合并三个集合
        if (sH==null){
            if (eH==null){
                return mH;
            }else {
                eT.next = mH;
                return eH;
            }
        }else {
            if (eH==null){
                sT.next = mH;
            }else {
                sT.next = eH;
                eT.next = mH;
            }
            return sH;
        }
    }
}
