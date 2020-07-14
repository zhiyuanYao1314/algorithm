package byted;

import com.sun.codemodel.internal.JTryBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * 93 复制ip地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * "111 111 11"
 *
 */
public class Main48 {

    public static void main(String[] args) {
        Main48 m = new Main48();
        List<String> list = m.restoreIpAddresses("25525525523");
        for (String s: list){
            System.out.println(s);
        }
    }
    // 0-255
    public List<String> restoreIpAddresses(String s) {
        int i=0;
        int n= s.length();
        help(s, 0, "", 1);
        return ans;
    }
    List<String> ans = new ArrayList<>();
    public void help(String s, int index, String path, int count) {
        // 结束
        if (count==4){
            String cur = s.substring(index);
            int num;
            try {
                num = new Integer(cur);
            }catch (Exception e){
                return;
            }
            if (num>=0 && num<=255){
                ans.add(path+"."+cur);
            }
            return;
        }
        int cur = s.charAt(index)-'0';
        int i=index;
        if (cur==0){
            index++;
            path += "."+0;
            help(s, index, path, count+1);
            return;
        }
        while (cur<255){
            path += "."+cur;
            index++;
            help(s, index, path, count+1);
            path = path.substring(0, path.lastIndexOf("."));
            cur += (s.charAt(index)-'0');
        }
    }
}