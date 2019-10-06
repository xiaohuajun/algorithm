package mathmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/30 21:42
 * @description 求N的所有的质数
 * 规定：只能被1和本身整除的数，----  除了 1 和 本身  没有其他的因子
 */
public class PrimeNum {


    /**
     * 10的质数有：2、3、5、7
     *
     * @param n n
     * @return n的所有质数
     */
    public static List<Integer> getPrimeNum(int n) {
        List<Integer> reList = new ArrayList<>();
        reList.add(2);
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == i - 1) {
                    reList.add(i);
                }
            }
        }
        return reList;
    }

    public static void main(String[] args) {
        int p = 10000000;
        System.out.println(PrimeNum.getPrimeNum(p));
    }

}
