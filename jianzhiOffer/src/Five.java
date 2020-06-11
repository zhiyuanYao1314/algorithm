import java.io.FileInputStream;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 9:14
 * Describe:
 * version:1.0
 */
public class Five {

    /**
     * 总结：
     * 1. 对于数组中元素的替换(一个元素替换成多个)，因为中间插入元素代价较大，
     *    所以，选择从后面插入，
     * 2. 这里采用双指针，第一个指针指向原来的数组尾部，
     *    第二个指针指向新的数组尾部。第一个指针每碰到一个非空格，就第二个指针处添加相同的元素，
     *    第一个指针每碰到一个空格，第二个指针依次插入02%(倒序)。
     *    退出的条件是第一个指针<0.
     * 2.
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str== null || str.length()==0){
            return "";
        }
        int oldL = str.length()-1;

        // 每遇到一个空格，在末尾添加两个空格。
        for (int i=0;i<=oldL;i++){
            if (str.charAt(i)==' ') str.append("  ");
        }
        int newL = str.length()-1;
        while (oldL>=0){
            if (str.charAt(oldL)==' '){
                str.setCharAt(newL--,'0');
                str.setCharAt(newL--,'2');
                str.setCharAt(newL--,'%');
            }else str.setCharAt(newL--,str.charAt(oldL));
            oldL--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Five f = new Five();
        System.out.println(f.replaceSpace(new StringBuffer("A B C ")));
    }
}
