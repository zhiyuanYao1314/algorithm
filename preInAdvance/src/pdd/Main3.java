package pdd;
import java.util.*;

/**
 * 3 背包
 * 80%
 *
 */
public class Main3 {

    static class Node{
        int re;
        int meiwei;

        public Node(int re, int meiwei) {
            this.re = re;
            this.meiwei = meiwei;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] l1s = line1.split(" ");
        int zhong  =new Integer( l1s[0]);// 中
        int wan =new Integer( l1s[1]); // 晚
        int meiwei =new Integer( l1s[2]); // meiwei
        HashMap<Integer, Integer> zhongfan = new HashMap<>();
        HashMap<Integer, Integer> wanfan = new HashMap<>();
        put(zhongfan, sc,zhong);
        put(wanfan, sc,wan);
        int min= Integer.MAX_VALUE;
        // zs ws

        if (meiwei==0){
            System.out.println(0);
            return;
        }

        Node[] zs = new Node[zhongfan.size()];
        Node[] ws = new Node[wanfan.size()];
        int i=0;
        for (Integer ele:zhongfan.keySet()){
            zs[i++] = new Node(zhongfan.get(ele), ele); // ele是美味
        }
        i=0;
        for (Integer ele:wanfan.keySet()){
            ws[i++] = new Node(wanfan.get(ele), ele); // ele是美味
        }
        // 美味从小到大拍
        Arrays.sort(zs, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.meiwei-o2.meiwei;
            }
        });
        Arrays.sort(ws, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.meiwei-o2.meiwei;
            }
        });

        for (int j=0;j<zs.length;j++){
            if (zs[j].meiwei>=meiwei){
                min = Math.min(min,zs[j].re);
                continue;
            }
            for (int k=ws.length-1;k>=0;k--){
                if (ws[k].meiwei>=meiwei){
                    min = Math.min(min,zs[j].re);
                    continue;
                }
                if (zs[j].meiwei+ws[k].meiwei>=meiwei){
                    min = Math.min(min,zs[j].re+ws[k].re);
                }else {
                    break;
                }
            }
        }
        if (min == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static void put(HashMap<Integer, Integer> zhongfan, Scanner sc, int zhong) {
        for (int i=0;i<zhong;i++){
            String cur = sc.nextLine();
            String[] cs = cur.split(" ");
            int curRe = new Integer(cs[0]);
            int curMei = new Integer(cs[1]);
            if (zhongfan.get(curMei)==null){
                zhongfan.put(curMei, curRe);
            }else{
                zhongfan.put(curMei, Math.min(curRe, zhongfan.get(curMei)));
            }
        }
    }

}
