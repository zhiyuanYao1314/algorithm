import java.util.Scanner;
public class Main2 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String url = sc.next();
        String[] strings = get(url);
        for (String s: strings){
            System.out.print(s+" ");
        }
    }
    // 解析四部分；
    public static String[] get(String url){

        String[] ans = new String[4];
        // 1. 先按://划分，如果有： 判断端口号，没有，则端口号80
        // 2. 有没有：
        //   2.1 有： 截取前面的为host； ：---/为port
        //   2.2 没有： 截取前面的为 ---/为host
        // 3. 截取到？
        // 4， 截取问好后面的
        int i = url.indexOf("://");
        String port =80+"";
        if (i!=-1){
            String scheme = url.substring(0,i);
            if (scheme.equalsIgnoreCase("http")){
                port = "80";
            }else if (scheme.equalsIgnoreCase("https")){
                port = "443";
            }
            url = url.substring(i+3);
        }
        // 2. 有没有：
        //   2.1 有： 截取前面的为host； ：---/为port
        //   2.2 没有： 截取前面的为 ---/为host
        // 3. 截取到？
        // 4， 截取问好后面的
        int j = url.indexOf(":");
        String host;
        if (j!=-1){
            host = url.substring(0,j);
            url = url.substring(j+1);
            port = url.substring(0,url.indexOf("/"));
        }else {
            host = url.substring(0,url.indexOf("/"));
        }
        url = url.substring(url.indexOf("/")); // 后面是path;

        ans[0] = host;
        ans[1] = port;
        // 3. 截取到？
        // 4， 截取问好后面的
        int k = url.indexOf("?");
        String path;
        if (k!=-1){
            path = url.substring(0,url.indexOf("?"));
        }else {
            path = url; // 没有问号 去广
            ans[2] = path;
            ans[3] = "";
            return ans;
        }
        url = url.substring(url.indexOf("?")+1);// query
        int q = url.indexOf("#");
        String query ;
        if (q!=-1){
            query = url.substring(0,q);
        }else {
            query = url;
        }
        ans[2] = path;
        ans[3] = query;
        return ans;
    }
}
