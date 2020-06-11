package A18Threads.A1Thread;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 2:24
 * 两个线程轮流打印1-100
 */
public class A4Thread {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }

    static Integer n =0;
    static Object o = new Object();
    static volatile boolean isA = true;
    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i=0;i<50;i++){
                synchronized (o){
                    while (!isA){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+":"+n++);
                    isA = false;
                    o.notifyAll();
                }

            }
            super.run();
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i=0;i<50;i++){
                synchronized (o){
                    while (isA){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+":"+n++);
                    isA = true;
                    o.notifyAll();
                }

            }
            super.run();
        }
    }

}
