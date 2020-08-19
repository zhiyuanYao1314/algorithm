package ali;

/**
 * 懒汉式单例；
 *
 */
public class Main3 {

    private volatile static Main3 self; // 保证self的 各个线程的可见性和不可指令重排

    private Main3(){

    }
    public static Main3 getInstance(){
        if (self==null){
            synchronized (Main3.class){
                if (self==null){
                    self = new Main3();
                }
                return self;
            }
        }
        return self;
    }

    public static void main(String[] args) {

    }



}
