package 猿辅导;
import java.util.*;

public class Main1 {

    /**
     * 以起始点从小打到排序；
     * 循环扔到集合里，
     * 如果和当前集合不冲突，就合并结束值，
     * 如果冲突，添加到集合
     * 50%
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        int[][] ses = new int[n][2]; //
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] ls = line.split(" ");
            ses[i][0] = new Integer(ls[0]);
            ses[i][1] = new Integer(ls[1]);
        }

        Arrays.sort(ses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // for (int i = 0; i < ses.length; i++) {
        //     System.out.println(ses[i][0]);
        // }

        List<Integer> ans = new ArrayList<>();
        ans.add(ses[0][1]);
        for (int i = 1; i < ses.length; i++) {
            int j = 0;
            for (; j < ans.size(); j++) {
                if (ses[i][0] >= ans.get(j)) {
                    ans.set(j, ses[i][1]);
                    break;
                } else { // <
                    continue;
                }
            }
            if (j == ans.size()) {
                ans.add(ses[i][1]);
            }
        }
        System.out.println(ans.size());
    }
}
