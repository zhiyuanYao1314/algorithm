package xiecheng;

import java.util.Scanner;

public class Main33 {

    // 100%！
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String word = sc.nextLine().trim();
            String[] dic = new String[]{ "surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
            int i=0;
            for (;i<dic.length;i++){
                int min = minDistance(dic[i], word);
                if (min<=2){
                    System.out.println(dic[i]);
                    break;
                }
            }
            if (i == dic.length){
                System.out.println("null");
            }
        }
    }
    public  static  int minDistance(String str,String word){
        int len1 = str.length();
        int len2 = word.length();
        int[][] arr = new int[len1+1][len2+1];
        for (int i=0;i<=len1;i++){
            arr[i][0] =i;
        }
        for (int i=0;i<=len2;i++){
            arr[0][i] =i;
        }
        for (int i=1;i<len1+1;i++){
            for (int j=1;j<len2+1;j++){
                if (str.charAt(i-1)==(word.charAt(j-1))){
                    arr[i][j]= arr[i-1][j-1];
                }else{
                    arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i][j-1],arr[i-1][j-1]))+1;
                }
            }
        }
        return arr[len1][len2];
    }
}
