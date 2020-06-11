package xiecheng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 14:15
 * Describe:
 * version:1.0
 */
public class Main3 {
    public static void main(String[] args) throws ParseException {
        //yyyy-MMM-dd HH:mm:ss:SSS
        //3/11/18 2:00
        String format = "dd/MM/yy HH:mm";

        Date nowTime = new SimpleDateFormat(format).parse("30/7/18 15:00");
        Date startTime = new SimpleDateFormat(format).parse("3/2/18 2:00");
        Date endTime = new SimpleDateFormat(format).parse("11/11/18 2:00");
        System.out.println(isEffectiveDate(nowTime, startTime, endTime));
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime 当前时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}