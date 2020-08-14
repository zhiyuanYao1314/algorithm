package kuaishou;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/8/4 2:59
<<<<<<< Updated upstream
 *  单例
 */
public class Main4 {

    private static volatile Main4 self;

    private Main4(){}

    public static Main4 getInstance() {
        if (self == null) {
            synchronized (Main4.class) {
                if (self == null) {
                    self = new Main4();
                }
                return self;
            }
        }
        return self;
    }
}
