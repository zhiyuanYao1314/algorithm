import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {

        // 不会初始化
        Array[] a = new Array[10];

        //  会初始化
//        Array aa = new Array();

    }

}


//class Array{
//    public Array() {
//    }
//
//    static {
//        System.out.println("----");
//    }
//}

