import java.util.DuplicateFormatFlagsException;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/21 17:36
 * Describe:
 * version:1.0
 */
public class Third {

    public static void main(String[] args) {
        Third t = new Third();
        int[] duplication = new int[1];
        System.out.println(t.duplicate(new int[]{2,1,4,2,4}, 5,duplication));
        System.out.println(duplication[0]);
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i=0;i<length;i++){
            while (i != numbers[i]){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    public void swap(int[] numbers, int i,int j){
        int tmp = numbers[i];
        numbers[i]=numbers[j];
        numbers[j]= tmp;
    }
}
