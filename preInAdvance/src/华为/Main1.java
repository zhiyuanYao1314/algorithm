package 华为;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        // merge sort
        List tasks = new ArrayList<>(); // 1 2 0 3
        tasks.add(3);
        tasks.add(5);
        tasks.add(4);
        tasks.add(3);
        int[] ans = printOrder(tasks);
        System.out.println(Arrays.toString(ans));
    }
    static class Node{
        int val;
        int index;
        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static int[] printOrder(List<Integer> tasks){
        List<Node> nodes= new ArrayList<>();
        for (int i=0;i<tasks.size();i++){
            Node tmp = new Node(tasks.get(i), i);
            nodes.add(tmp);
        }
        for (int i=nodes.size()-1;i>=1;i--){
            for (int j=0;j<i;j++){
                if (nodes.get(j).val<nodes.get(j+1).val){
                    Node tmp = nodes.get(j+1);
                    nodes.set(j+1,nodes.get(j));
                    nodes.set(j, tmp);
                }
            }
        }
        int[] ans = new int[nodes.size()];
        int i=0;
        for (Node n: nodes){
            ans[i++] = n.index;
        }
        return ans;
    }
}
