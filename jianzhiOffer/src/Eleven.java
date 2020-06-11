import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.ws.EndpointReference;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/22 12:44
 * Describe:
 * version:1.0
 */
public class Eleven {

    public static void main(String[] args) {
    }
    /**
     * 旋转数组的最小值
     * 二分法，每次都去找旋转数组那部分，
     * 最后返回值是左边界的下标。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0) return 0;
        if (array.length==1) return array[1];
        int l = 0;
        int r = array.length-1;
        while (l<r){
            int m = (l+r)/2;
            if (array[m] == array[r] &&  array[r]== array[l]){
                int min =Integer.MAX_VALUE;
                for (int i=l;i<=r;i++){
                    if (array[i]<min) min=array[i];
                    return min;
                }
            }else if (array[m]>=array[r]) l = m+1;
            else r = m;
        }
        return array[l];
    }
}
