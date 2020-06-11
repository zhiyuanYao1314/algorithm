package others;

/**
 * Author:yaozhiyuan0117@163.com
 * Time:2020/3/20 18:46
 * Describe:
 * version:1.0
 */
public class Pokemon {

    public static void main(String[] args) {
        Pokemon p = new Pokemon();
        System.out.println(p.Pokemonfight(8,3,8,1));
    }

    // 注意首先想到的是暴力破解法
    public long Pokemonfight (long HP, long ACK, long HP2, long ACK2) {
        if (ACK>HP2 || (ACK*2>HP2 && HP>ACK2)) return -1;
        if (ACK2>=HP) return 1;

        long count=0;
        long currentHP2 = HP2;
        while (HP>0){
            currentHP2 = currentHP2-ACK;
            if (currentHP2-ACK>0 || HP-ACK2<=0) HP =HP - ACK2;
            else currentHP2 = HP2;
            count++;
        }
        return count;
    }
}
