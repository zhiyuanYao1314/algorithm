package math;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/22 14:41
 * 大小王当癞子，五张牌，其中大小鬼为癞子，牌面为 0。
 * 判断这五张牌是否能组成顺子。
 */
public class Main8 {

    // 用count0填充序列的差，
    public boolean isContinuous(int [] numbers) {
        if (numbers==null || numbers.length<5) return false;
        Arrays.sort(numbers);
        int j=0;
        int count0=0;
        while (numbers[j++]==0){
            count0++;
        }
        for (int i=count0;i<numbers.length-1;i++){
            if (numbers[i+1]== numbers[i]) return false;
            count0 -= numbers[i+1]-numbers[i]-1;
        }
        if (count0>=0) return true;
        return false;
    }
}
