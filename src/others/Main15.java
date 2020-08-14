package others;


/**
 * 汉诺塔
 */

public class Main15 {

    public static void main(String[] args) {
        hannuota(3);
    }

    public static void hannuota(int n){
        help(n, 'A','B','C');
    }
    // 目的是有n层的汉诺塔，需要将其从A移动到C；
    public static void help(int n , char A, char B, char C){
        if (n==1){
            System.out.println("移动"+n+"从"+A+"移动到"+C);
            return;
        }
        help(n-1, A, C, B);
        System.out.println("移动"+n+"从"+A+"移动到"+C);
        help(n-1, B, A, C);
    }
}
