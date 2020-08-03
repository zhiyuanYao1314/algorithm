package pdd;
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = 4;
        char[][] cs = new char[tt][tt];
        for (int i=0;i<tt;i++){
            String line = sc.nextLine();
            for (int j=0;j<tt;j++){
                cs[i][j] = line.charAt(j);
            }
        }

        Long[][] dp = new Long[tt][tt];
        for (int i=0;i<tt;i++){

        }
        for (int j=0;j<tt;j++){

        }

        System.out.println("hellp");
        bfs(cs, 0,0, tt);
        System.out.println(count);
    }

    private static void bfs(char[][] cs, int x, int y, int tt) {
        if (x==tt-1 && y==tt){
            count++;
            return;
        }
        if (y==tt){
            bfs(cs,x+1,0, tt);
            return;
        }
        if (cs[x][y]=='#'){
            bfs(cs,x,y+1, tt);
            return;
        }

        for (char i =1;i<=6;i++){
            if (x-1<0 && y-1<0){
                cs[x][y]=i;
                bfs(cs,x,y+1, tt);
                continue;
            }else if (x-1<0){
                if (cs[x][y-1]!=i){
                    cs[x][y]=i;
                    bfs(cs,x,y+1, tt);
                    cs[x][y]='*';
                }
            }else if (y-1<0){
                if (cs[x-1][y]!=i){
                    cs[x][y]=i;
                    bfs(cs,x,y+1, tt);
                    cs[x][y]='*';
                }
            }else{
                if ((cs[x-1][y] != i && cs[x][y-1]!=i)){
                    cs[x][y]=i;
                    bfs(cs,x,y+1, tt);
                    cs[x][y]='*';
                }
            }
        }
    }

    static Long count =0L;


}
