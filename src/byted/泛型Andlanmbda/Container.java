package byted.泛型Andlanmbda;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/7/12 17:53
 * Describe:
 * version:1.0
 */
public class Container<T> {
    Object[] s;

    public Container(){
        s = new Object[10];
    }

    public  void put(T x){
        s[0] = x;
    }

}
