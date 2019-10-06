package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/15 14:22
 * @description 求一个数的阶乘末尾0的个数
 */
public class TrailingZeroes {


    private static int getZeroCount(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }


    public static void main(String[] args) {
        int n = TrailingZeroes.getZeroCount(5);
        System.out.println(n);
    }

}
