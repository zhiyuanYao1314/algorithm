package zhaohang;

class Main2{
    public static void main(String[] args) {
        System.out.println(scheme(8));
    }

    /**
     * 数学规律题
     */
    public static long scheme(int n){
        if (n<6) return 0;
        if (n==6 || n==7) return 1;
        return  (long)Math.pow(2,n-6)%666666666;
        // n= n-6;
        // int[] all = new int[n];
        // all[0] =1;
        // all[1] =1;
        // for (int i=2;i<all.length;i++){
        //     all[i] =
        // }
        // return -1;
    }
}
