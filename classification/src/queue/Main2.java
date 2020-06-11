package queue;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/5/26 15:16
 * 使用数组实现队列：putindex记录放的位置; getIndex记录取的位置；
 */
public class Main2 {

    int cap;
    int[] nums;
    int size=0;
    int putIndex =0;
    int getIndex =0;
    Main2(int n ){
        cap=n;
        nums= new int[n];
    }
    void put(int n){
        if (size ==cap){
            throw new RuntimeException("full!");
        }
        size++;
        nums[putIndex]=n;
        getNext(putIndex);
    }
    int get(){
        if (size<0){
            throw new RuntimeException("empty!");
        }
        size--;
        int ret = nums[getIndex];
        getNext(getIndex);
        return ret;
    }
    private void getNext(int putIndex) {
        if (putIndex==cap-1)
            putIndex=0;
        else
            putIndex++;
    }
}
