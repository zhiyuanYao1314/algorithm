package huawei;
import java.util.Scanner;


//20%
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(sc.nextLine().trim());
            StringBuffer str = new StringBuffer(sc.nextLine().trim());
            test(len,str);
        }
    }

    private static void test(int len, StringBuffer str) {

        int index=-1;
        for (int i=len-1;i>=0;i--){
            if(str.charAt(i)=='0'){
                index =i;
                break;
            }
        }

        for (int i=len-1;i>=0;i--){
            if (i!=index){
                str.setCharAt(i,'1');
            }
        }
        System.out.println(str);
    }


}