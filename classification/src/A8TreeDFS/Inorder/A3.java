package A8TreeDFS.Inorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/29 11:44
 *
 * 折纸 凹痕
 * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，
 * 压出折痕后展开。此时折痕是凹下去的。如过从下向上连续折叠两次，
 * 压出折痕后展开，此时有三条折痕，从上到下一次是下折痕，下折痕，上折痕。
 * 给定一个参数N, 代表对折的次数，打印所有方向
 * 如：N=2; 打印 down down up;
 */
public class A3 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        List<String> strings = a3.breakOff(2);
        System.out.println(strings);
    }

    List<String> breakOff(int k){
        List<String> ans = new ArrayList<>();
        help(k, "down",ans);
        return ans;
    }

    void help(int k,String down, List<String> ans){
        if (k<=0){
            return;
        }
        help(k-1, "down", ans);
        ans.add(down);
        help(k-1, "up", ans);
    }
}
