package ali;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

/**
 * 阿里笔试凉了。 这两天花时间再总结一下，这题目；
 * 1.
 * 第一行n,m表示有n个人和m个房子；
 * 第二行表示n个人分别有的钱，
 * 接下来的m行表示每套房子的享受值和费用；
 * 一个人最多只能买一套房，一套房最多只能被一个人买，
 * 求大家的最大享受值之和；
 * 2,2
 * 2,2
 * 2,2
 * 2,2
 *
 */
public class Main1 {
    /*
    方法1: dfs回溯 复杂度太高
    方法2： 贪婪，先取性价比高的，有问题；
    方法3：dp。。dp[i][j] = Math.max(dp[i-1][j]不买, dp[i-1][j-1]买+舒适度); // 来不及了。。。
    */
    public static class Room{
        int price;
        int use; // 舒适度
        public Room(int price, int use){
            this.use = use;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String row1 = sc.nextLine();
        String[] rs = row1.split(" ");
        int n = new Integer(rs[0]); // 人
        int m = new Integer(rs[1]); // 房子
        String row2 = sc.nextLine();
        String[] r2s = row2.split(" ");
        int[] money = new int[n]; // 所有人的钱
        for (int i=0;i<r2s.length;i++){
            money[i] = new Integer(r2s[i]);
        }
        Room[] rooms = new Room[m]; // 所有房子
        for (int i=0;i<m;i++){
            String tmp = sc.nextLine();
            String[] ts = tmp.split(" ");
            Room r = new Room(new Integer(ts[1]), new Integer(ts[0]));
            rooms[i] = r;
        }
        Arrays.sort(money); // 1-n
        Arrays.sort(rooms, new Comparator<Room>() { // 价格从小到大
            @Override // 性价比由高到低
            public int compare(Room o1, Room o2) {
                return ((double)o2.use/o2.price - (double)o1.use/o1.price)>0?1:-1;
            }
        });
        // int res = -1;

        int[][] dp = new int[n+1][m+1];

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (money[i]>rooms[j].price){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+rooms[j].price);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
        //
        // int sum =0;
        // Set<Integer> used = new HashSet<>();
        // for (int i=0;i<money.length;i++){
        //     for (int j=0;j<rooms.length;j++){
        //         if (money[i]>=rooms[j].price && !used.contains(i)){
        //             used.add(i);
        //             sum += money[i];
        //             break; // 买得起就买，继续下一个
        //         }else{
        //         }
        //     }
        // }
        // dfs(money, 0, 0, rooms, new HashSet<>());
        // System.out.println(sum);
    }
    static int max = -1;

    private static void dfs(int[] money, int cur, int sum, Room[] rooms, Set<Integer> used) {
        // 选完了
        if (cur==money.length){
            max = Math.max(max, sum);
            return;
        }
        int moni = money[cur];
        boolean cannotBuy = true;
        for (int i=0;i<rooms.length;i++){
            if (used.contains(i)){
                continue;
            }
            if (moni<rooms[i].price){// 后面都买不起
                break;
            }
            cannotBuy = false;
            used.add(i); // 买了
            sum += rooms[i].use;
            dfs(money, cur+1,sum, rooms, used);
            sum -= rooms[i].use;
            used.remove((Integer) i);
        }
        if (cannotBuy){
            dfs(money, cur+1,sum, rooms, used);
        }
    }
}
