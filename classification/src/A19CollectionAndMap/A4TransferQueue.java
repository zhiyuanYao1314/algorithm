package A19CollectionAndMap;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/6 23:42
 * transfer：
 * 于syncheonzied类似但是不同的是，
 * transfer可以放入多个值，
 * 可以检测是否有线程在等待获取数据，如果检测到就立即发送新增的数据给这个线程获取而不用放入队列。
 */

/**
 * synchronized和transfer线程的区别：
 *
 * SynchronousQueue一般来说如果线程a通过put方法存入数据到队列中，如果没有别的线程通过take方法去获取这个数据，
 * 那线程a进入阻塞状态；当有别的线程获取了这个值之后，线程a就恢复执行。
 * 如果线程b获取这个队列的数据时队列是空的，那线程b进入阻塞状态。直到有线程往这个队列里添加数据。
 *
 * 队列LinkedTransferQueue和SynchronousQueue有些类似，但LinkedTransferQueue可以使用put、tryTransfer、transfer添加多个数据而不用等别的线程来获取。
 * tryTransfer和transfer与put不同的是，tryTransfer和transfer可以检测是否有线程在等待获取数据，如果检测到就立即发送新增的数据给这个线程获取而不用放入队列。
 * 所以当使用tryTransfer和transfer往LinkedTransferQueue添加多个数据的时候，添加一个数据后，会先唤醒等待的获取数据的线程，再继续添加数据。
 */
public class A4TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> q = new LinkedTransferQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //等待支付完成
                    // System.out.println(q.take());// 拿到结果了
                    // 继续执行
                    System.out.println("反馈客户");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        q.transfer("客户完成了支付");
        System.out.println("阻塞了！");
    }
}