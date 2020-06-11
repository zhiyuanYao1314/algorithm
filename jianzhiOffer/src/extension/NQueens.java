package extension;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 15:50
 * Describe:
 * version:1.0
 */
public class NQueens {
    int N =4;
    // 皇后的位置
    int[] q =new int[N+1];

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.queen(1));
    }

    /**
     *  回溯，循环+递归，
     *  保存历史记录进行判断
     *  if 当前成功，继续，if 继续成功，return true, else continue
     *  else 继续。
     * @param r
     * @return
     */
    public  boolean queen(int r){
        // N个queen都放置成够后，最后return true
        if (r ==N+1) return true;
        for (int c=1;c<=N;c++){
            q[r] = c;
            // 一行一行的测试放置的位置。
            if (place(r)){
                if (queen(r+1)) return true;
                // else continue;
            }
        }
        return false;
    }
    // 当前位置防止queen成功的条件
    public boolean place(int r){
        for (int i=1;i<r;i++){
            if (q[r] == q[i] || Math.abs(r-i)== Math.abs(q[r]-q[i])) return false;
        }
        return true;
    }
}
