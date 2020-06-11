/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 9:35
 * Describe:
 * version:1.0
 */
public class Ten2 {
    public static   void main(String[] args) {
        System.out.println(RectCover(0));
    }

    public static int RectCover(int target) {
        if (target<=3){return target;}
        int[] ans = new int[target+1];
        ans[0]=0;
        ans[1]=1;
        ans[2]=2; // 3 3 4 5
        for (int i =3;i<target+1;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        return ans[target];
    }




}
