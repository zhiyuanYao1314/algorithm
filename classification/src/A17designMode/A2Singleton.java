package A17designMode;

import javax.swing.plaf.SliderUI;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 22:40
 * 饿汉
 */
public class A2Singleton {
    static volatile A2Singleton self;
    private A2Singleton(){}
    public static A2Singleton GetInstance(){
        if (self == null){ // 不需要每次都获得锁，效率高！
            synchronized (A2Singleton.class){
                if (self==null){
                    self = new A2Singleton();
                }
            }
        }
        return self;
    }
}
