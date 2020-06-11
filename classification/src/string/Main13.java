package string;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/1 11:41
 * Leetcode6 Z字型变换
 */
public class Main13 {

    /**
     * 从上往下 从下往上。
     */
    public String convert(String s, int numRows) {
        if (s==null || numRows==0) return null;
        if (numRows==1) return s;
        List<StringBuffer> list = new ArrayList<>();
        int rows = Math.min(s.length(), numRows);
        for (int i=0;i<rows;i++){
            list.add(new StringBuffer());
        }
        boolean godowning = false;
        int curRow =0;
        for (int i=0;i<s.length();i++){
            // 先放元素，放完了元素 再换方向！
            list.get(curRow).append(s.charAt(i));
            if (curRow==0 || curRow==rows-1) godowning =!godowning;
            curRow += godowning?1:-1;
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer sb: list){
            ans.append(sb);
        }
        return ans.toString();
    }
}
