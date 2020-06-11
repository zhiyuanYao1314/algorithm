package xiecheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 输出在时间区间范围内的序号
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int curtime = sc.nextInt();
        String line = "";
        String[] nums = new String[n];
        int[] starttimes = new int[n];
        int[] endtimes = new int[n];
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
            starttimes[i] = sc.nextInt();
            endtimes[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            if (curtime <= endtimes[i] && curtime >= starttimes[i]) {
                res.add(nums[i]);
            }
        }
        if (res.size() == 0) {
            System.out.println("null");
        } else {
            Collections.sort(res);
            for (String t : res) {
                System.out.println(t);
            }
        }
    }

}