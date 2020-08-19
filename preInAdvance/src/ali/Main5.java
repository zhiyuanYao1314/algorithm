package ali;

public class Main5 {
/**
 * synchronized
 * 两个线程轮流打印1-100；
 */

    public static void main(String[] args) {
        Main5 m5 = new Main5();
        new Thread(new A()).start();
        new Thread(new B()).start();
    }

    // 1. lock
    static Object lock = new Object();

    // 2. turnForA;
    static boolean turnForA = true;

    // 2. int
    static int count=1;

    static class A implements Runnable {
        @Override
        public void run() {
            for (int i=0;i<50;i++){
                synchronized (lock){
                    while (!turnForA){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A"+count++);
                    turnForA = false;
                    lock.notifyAll();
                }
            }
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            for (int i=0;i<50;i++){
                synchronized (lock){
                    while (turnForA){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B"+count++);
                    turnForA = true;
                    lock.notifyAll();
                }
            }
        }
    }

}
