import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/23 23:02
 * Describe:
 * version:1.0
 */
public class Test {

    public static void main(String[] args) {
    }


    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }



    // public static void main(String[] args) {
    //     System.out.println(new Test().getValue(2));
    //     Entry<Integer,Integer>[] as = new Entry[3];
    //     Entry en = as[0];
    //     System.out.println(en);
    //     as[0] = null;
    //     System.out.println(en);
    //
    //
    //     StringBuffer[] sb = new StringBuffer[3];
    //     sb[0]= new StringBuffer("asas");
    //     StringBuffer s = sb[0];
    //     System.out.println(s); //asas
    //     sb[0] = null;
    //     System.out.println(s); //asas
    //
    // }
}
