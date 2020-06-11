package A17designMode;


/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 22:38
 * 单例模式
 * 懒汉 饿汉
 */
public class A1Singleton {
    static A1Singleton slef = new A1Singleton();
    private A1Singleton (){
    }
    public static A1Singleton getInstance(){
        return slef;
    }
}
