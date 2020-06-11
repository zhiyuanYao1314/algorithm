package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 10:48
 * Describe:
 * version:1.0
 */
public class PlayChess {

    public static void main(String[] args) {
        PlayChess playChess = new PlayChess();
        String[]  chessboard =  new String[]{"......", "..B...", ".C.Pj.", "......", "..b..."," ...J.." };
        System.out.println(playChess.playchess(chessboard));
    }

    /**
     * 先找到小j，
     * 1. 判断行列的上下左右所有是否有J,B。
     * 2. 判断行列是否有P,且中间有其他子
     * 3. 判断行列是否有C，且中间无其他子。
     *
     * 总结：
     * 1. 判断边界， if (x-1>0 && chess[x-1].indexOf('J'))
     * 2. 字符串常用函数 charAt(2), indexOf('J')
     * @param chessboard
     * @return
     */
    public String playchess (String[] chessboard) {

        // j -> J,B C P
        // find (x,y) for j
        int x=0;
        int y=0;
        for (;x<chessboard.length;x++){
            if (chessboard[x].contains("j")){
                y = chessboard[x].indexOf('j');

                int Jy=chessboard[x].indexOf('J');
                int By=chessboard[x].indexOf('B');
                int Py=chessboard[x].indexOf('P');
                int Cy = chessboard[x].indexOf("C");
                // 将或兵在左右
                if ((Jy!= -1 && (Jy== y-1 || Jy==y+1)) || (By!= -1 && (By== y-1 || By==y+1))){
                    return "Happy";
                }
                // 炮在同一行且中间有子
                if (Py !=-1){
                    int min = Math.min(Py,y);
                    int max = Math.max(Py,y);
                    for (int i = min + 1; i < max; i++) {
                        if (chessboard[x].charAt(i) != '.') {
                            return "Happy";
                        }
                    }
                }
                // 车在同一行且中间无子
                if (Cy !=-1){
                    int min = Math.min(Cy,y);
                    int max = Math.max(Cy,y);
                    int i = min + 1;
                    for (; i < max; i++) {
                        if (chessboard[x].charAt(i) != '.') {
                            break;
                        }
                    }
                    if (i == max){
                        return "Happy";
                    }
                }
                break;
            }
            // (x,y)
        }

        // 将或兵在上下
        if (x-1>=0 && (chessboard[x-1].charAt(y)=='J' || chessboard[x-1].charAt(y)=='B')){
            return "Happy";
        }
        if (x+1<chessboard.length && (chessboard[x+1].charAt(y)=='J' || chessboard[x+1].charAt(y)=='B')){
            return "Happy";
        }
        // 炮在同一列且中间有子
        for (int i=0;i<chessboard.length;i++){
            if (chessboard[i].charAt(y)=='P' && Math.abs(i-x)>1){
                int min = Math.min(i,x);
                int max = Math.max(i,x);
                for (int k=min+1; k<max ; k++){
                    if (chessboard[k].charAt(y) != '.'){
                        return "Happy";
                    }
                }
            }
        }
        // 炮在同一列且中间无子
        for (int i=0;i<chessboard.length;i++){
            if (chessboard[i].charAt(y)=='C' && Math.abs(i-x)>1){
                int min = Math.min(i,x);
                int max = Math.max(i,x);
                int k=min+1;
                for ( ;k<max ; k++){
                    if (chessboard[k].charAt(y) != '.'){
                        break;
                    }
                }
                if (k == max){
                    return "Happy";
                }
            }
        }
        return "Sad";
    }
}
