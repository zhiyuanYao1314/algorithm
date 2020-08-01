package others;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Main11 {
    public static void main(String[] args) {
        List<String> res = restoreIpAddresses("1111232211");
        System.out.println(res);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        help(0, s,"", res);
        return res;
    }

    static void help(int n, String s, String path, List<String> res){
        // 说明到了最后一个
        if (n==4){
            if (s.length()==0){
                res.add(path);
                return;
            }
        }
        // 每一层 选取当前的元素
        for (int i=1;i<4;i++){ // 1-3位数
            if (s.length()<i){
                break;
            }
            String cur = s.substring(0,i);
            int c = new Integer(cur);
            if (c>255 || i!=cur.length()){
                break;
            }
            String next = path + cur+ (n==3?"":".");
            help(n+1,s.substring(i),next,res);
        }

    }

}