package xiecheng;
import java.util.*;
public class Main {
    // 70%
    static int calcMinStaff(int[][] arr) {
        int count =0;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if (arr[i][0]>=arr[j][1]){
                    count ++;
                    arr[j][1] =arr[i][1];
                    arr[i][1] =Integer.MAX_VALUE;
                    arr[i][0] =Integer.MIN_VALUE;
                }else if(arr[i][1]<=arr[j][0]){
                    count++;
                    arr[j][0] =arr[i][0];
                    arr[i][1] =Integer.MAX_VALUE;
                    arr[i][0] =Integer.MIN_VALUE;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        int n; // 所有数
        n = Integer.parseInt(in.nextLine().trim());
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++){
            String str = in.nextLine().trim();
            String[] split = str.split(",");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        res = calcMinStaff(arr);
        System.out.println(res);
        System.out.println(String.valueOf(n-res));

    }
}
