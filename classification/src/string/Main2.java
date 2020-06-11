package string;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Main2 {
    public static void main(String[] args) {

    }

    /**
     * 先将字符串扩充，每一个空格，补两个空格，
     * 然后从佬地方开始往前替换，
     * 遇到空格，往前替换三个，
     * 非空格，替换一个
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
}
