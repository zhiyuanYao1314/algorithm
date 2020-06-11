import javax.activation.MailcapCommandMap;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/29 13:18
 * Describe:
 * version:1.0
 */
public class A17 {
    public static void main(String[] args) {
        A17 a = new A17();
        a.print1ToMaxOfNDigits(5);
    }
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }
    //
    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
}
