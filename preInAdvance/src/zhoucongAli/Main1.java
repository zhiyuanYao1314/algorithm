
public class Main1 {
    /**
     *
     * @param args
     *
     */
    public static void main(String[] args) {
        Main1 m1 = new Main1();
        // 测试案例1：
        boolean same1 = m1.isSameAfterMove("abck", "cdab");
        // 测试案例2：
        boolean same2 = m1.isSameAfterMove("abcd", "cdab");
        System.out.println(same1);// false
        System.out.println(same2);// true
    }
    // 判断循环位移是否相同
    boolean isSameAfterMove(String s1, String s2){
        // 1. 判断特殊值
        if (s1==null && s2==null){
            return true;
        }
        if (s1==null || s2==null){
            return false;
        }
        if (s1.length()!=s2.length()){
            return false;
        }
        //2. 循环判断
        for (int i=0;i<s2.length();i++){
            s2 = s2.substring(i)+s2.substring(0,i);
            if (s1.equals(s2)){
                return true;
            }
        }
        return false;
    }

}
