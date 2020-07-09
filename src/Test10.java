

public class Test10 {

    public static void main(String[] args) {

    }

    void heapSort(int[] arr){
        // arr 5 4 3 2 1 0
        buildHeap(arr);
        // swap and size--； down
        int size = arr.length;
        while (size>1){
            swap(arr, 0, size-1);
            size--;
            down(arr, size);
        }
    }

    /**
     *
     *
     */
    private void down(int[] arr, int size) {
        int cur =0;
        int next = cur*2+1;
        while (next<size){
            if (next+1<size && arr[next+1]<arr[next])
                next = next+1;
            if (arr[cur]<arr[next])
                break;
            swap(arr, cur,next);
            cur = next;
            next = cur*2+1;
        }
    }

    // 1 23 4567
    //  build heap time： n
    public  void buildHeap(int[] arr){
        int n = arr.length;
        int half = n/2-1;// 2
        while (half>=0){
            int cur =half;
            int next = cur*2+1;
            // 向下过滤
            while (next<n){
                if (next+1<n && arr[next+1]<arr[next]){
                    next = next+1;
                }
                if (arr[cur]<arr[next])
                    break;
                swap(arr, cur,next);
                cur = next;
                next = 2*cur+1;
            }
            half--;
        }
    }

    public void swap(int[] arr,int i, int j ){

    }


}
