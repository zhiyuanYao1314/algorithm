package array;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Main3 {
    public static void main(String[] args) {
    }

    /**
     * 从右上角开始，每次减少一行或一列，
     * time: m+n
     * space: 1
     */
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
