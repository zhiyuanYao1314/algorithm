package A16Others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/29 17:10
 * 将一个大的9*9的格子划分成9个9宫格，编号0-8；
 * 给定i,j； 判断它属于哪个9宫格；
 *
 */
public class A2 {
    public static void main(String[] args) {

    }

    public int which9(int i, int j){
        return (i/3)*3+j/3;
    }
}
