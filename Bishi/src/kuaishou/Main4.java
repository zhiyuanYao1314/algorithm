package kuaishou;


import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){

        }

    }

    public int GetMaxStaffs2 (char[][] pos) {
        int rows = pos.length;
        int lines = pos[0].length;
        int all =0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<lines;j++){
                if (pos[i][j]=='.') all++;
            }
        }
        return all;
    }

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    //40%
    public int GetMaxStaffs (char[][] pos) {
        int rows = pos.length;
        int lines = pos[0].length;
        int all =0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<lines;j++){
                if (pos[i][j]=='.') {
                    all++;
                    for (int[] dire:dir){
                        int x =i+dire[0];
                        int y=j+dire[1];
                        if (x>=0&& x<rows && y>=0 && y<=lines){
                            pos[x][y] = '*';
                        }
                    }
                }
            }
        }
        return all;
    }
}
