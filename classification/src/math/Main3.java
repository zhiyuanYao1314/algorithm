package math;



public class Main3 {
    public static void main(String[] args) {

    }

    public int NumberOf1(int n) {
        int count =0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

}
