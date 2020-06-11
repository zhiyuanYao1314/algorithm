package string;

import java.util.LinkedList;
import java.util.Queue;

public class Main5 {
    public static void main(String[] args) {
        Main5 main5 = new Main5();
        main5.Insert('a');
        main5.Insert('b');
        main5.Insert('a');
        System.out.println(main5.FirstAppearingOnce());
    }

    private int[] cnts = new int[256]; // 记录所有char对应的数量
    private Queue queue = new LinkedList();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[(char) queue.peek()]>1){
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty()?'#': (char) queue.peek();
    }
}
