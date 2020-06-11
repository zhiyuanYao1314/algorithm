package A18Threads.A1Thread;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/7 14:40
 *
 * 两个线程轮流打印1A2B3C...
 * 自己实现CAS比较使用
 */
public class A20Inteview3_4 {

    static enum Single {T1, T2}; // 信号灯的两种状态！
    //信号灯， 开始的时候，1号线程运行 volatile保证线程线程的可见性，没有延迟。
    // 实际中去掉也没有关系，可能会慢一些!
    static /*volatile*/ Single which = Single.T1;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=26;i++){
                    while (which==Single.T2){}
                    System.out.println(i);
                    which=Single.T2;
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(char i='A';i<='Z';i++){
                    while (which==Single.T1){} // 没轮到自己的时候，无限等待
                    System.out.println(i);
                    which=Single.T1;
                }
            }
        }).start();

    }
}
