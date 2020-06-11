package graph;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/6/2 15:08
 * 733 图像渲染
 */
public class A6 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image==null || image.length==0) return image;
        int rs = image.length;
        int cs = image[0].length;
        int curColor = image[sr][sc];
        if (newColor==curColor)return image;
        dfs(image,rs,cs,sr,sc,newColor, curColor);
        return image;
    }

    void dfs(int[][] board,int rs , int cs, int i, int j, int newColor, int curColor) {
        if (i<0 || i>=rs || j<0 || j>=cs|| // 越界
                board[i][j]!=curColor || // 不一样结束
                board[i][j]==newColor){ // 已经改过了
            return;
        }
        board[i][j] =newColor;
        dfs(board, rs, cs, i+1,j,newColor, curColor);
        dfs(board, rs, cs, i-1,j,newColor, curColor);
        dfs(board, rs, cs, i,j+1,newColor, curColor);
        dfs(board, rs, cs, i,j-1,newColor, curColor);
    }
}
