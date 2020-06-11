package array;

import javax.activation.MailcapCommandMap;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/21 20:48
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Main12 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers==null || numbers.length==0) return "";
        String[] strs = new String[numbers.length];
        for (int i=0;i<numbers.length;i++){
            strs[i] = numbers[i]+"";
        }
        Arrays.sort(strs, (o1,o2)-> ((o1+o2).compareTo(o2+o1)));
        String ret = "";
        for (String str: strs){
            ret += str;
        }
        return ret;
    }

}
