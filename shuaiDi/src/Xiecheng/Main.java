package Xiecheng;


import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import javax.swing.tree.TreeNode;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
    public static int test(TreeNode node){
        // poll peek
        Queue queue = new PriorityQueue();
        queue.add(node);
        while (!queue.isEmpty()){
            queue.poll();
        }
        return 0;

    }
}
