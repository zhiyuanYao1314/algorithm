package A18Threads.A1Thread;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.lang.ref.SoftReference;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/4 16:32
 *
 *
 */

class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我被垃圾回收了");
    }
}
public class A20SoftReference {
    // 设置虚拟机参数 -Xms20M -XmxX20M
    public static void main(String[] args) throws InterruptedException {
        // 这里， m指向了一个软引用对象， 这个对象有指向了一个10M的空间
        SoftReference m = new SoftReference(new byte[1024*1024*10]);
        System.out.println(m.get()); // [B@4554617c 存在因为空间够
        Thread.sleep(2000);
        System.gc(); // 当空间不够的时候，软引用指向的空间将被释放；// 否则不释放；
        System.out.println(m.get()); // [B@4554617c， 因为空间够
        byte[] b = new byte[1024*1024*11];
        System.out.println(m.get()); // null 被垃圾回收了
    }
}
