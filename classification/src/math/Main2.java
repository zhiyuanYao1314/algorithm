package math;


/**
 * 最大共约数
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println(divisor(5,3));
        // ^ (n-1)
    }

    // 2 1
    public static int divisor(int m , int n){
        if (n==0) return 0;
        while (n!=0){
            int tmp = m;
            m =n;
            n = tmp%n;
        }
        return m;
    }


}
