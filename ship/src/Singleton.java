import javax.swing.plaf.SliderUI;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/7 13:42
 * Describe:
 * version:1.0
 */
public class Singleton {
    private static Singleton self;
    private Singleton(){
    }
    public Singleton getInstance(){
        if (self == null){
            synchronized (Singleton.class){
                    self = new Singleton();
            }
        }
        return self;
    }
    Person p;
    public Person getPerson(String str){
        switch (str){
            case "person1":
                p = new Person1();
                break;
            case "person2":
                p = new Person2();
                break;
        }
        return p;
    }

}
