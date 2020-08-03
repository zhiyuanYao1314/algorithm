package pdd;
import java.util.*;
// 96%
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] l1s = line1.split(" ");
        int n =new Integer( l1s[0]);// 重点
        int m =new Integer( l1s[1]); // 次数
        String[] l2s = line2.split(" ");
        int[] nums = new int[m];
        for (int i=0;i<m;i++){
            nums[i] = new Integer(l2s[i]);
        }
        if (n==0){
            System.out.println("paradox");
            return;
        }
        int count =0;
        for (int i=0;i<m;i++){
            int cur = n -nums[i];
            if (cur==0){
                System.out.println("paradox");
                return;
            }else if (cur>0){
                n =cur;
            }else {
                n = -cur;
                count++;
            }
        }
        System.out.println(n+" "+count);
    }
}