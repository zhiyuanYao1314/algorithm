/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 8:59
 * Describe:
 * version:1.0
 */
public class Four {

    public static void main(String[] args) {
        Four f = new Four();
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(f.Find(90,array));
    }

    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int lines = array[0].length;
        if (array== null || array.length==0 || array[0]== null || array[0].length==0)
            return false;
        // 从右上角开始
        int r = 0, l=lines-1;
        while (r<rows && l>=0){
            if (target== array[r][l]){
                return true;
            }else if (target>array[r][l]){
                r++;
            }else l--;
        }
        return false;
    }


}
