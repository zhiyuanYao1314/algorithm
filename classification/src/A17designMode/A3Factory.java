package A17designMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/4/28 22:57
 */
public class A3Factory {
    public static List getInstance(String list){
        if ("ArrayList".equalsIgnoreCase(list)){
            return new ArrayList();
        }else if ("LinkedList".equalsIgnoreCase(list)){
            return new LinkedList();
        }
        return null;
    }
}
