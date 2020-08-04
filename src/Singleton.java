
/**
 * 线程安全的懒汉模式
 */
public class Singleton {

    // 单例对象本身
    static Singleton self;

    // 锁对象 volatile放置指令重排
    static volatile Object lock;

    /**
     * 私有化构造方法
     */
    private Singleton(){
    }

    /**
     * double lock，双锁模式，提高效率
     * @return
     */
    static Singleton getInstance(){
        if (self==null){
            synchronized (lock){
                if (self==null){ // 必须判断一次！
                    self = new Singleton();
                }
                return self;
            }
        }
        return self;
    }
}
