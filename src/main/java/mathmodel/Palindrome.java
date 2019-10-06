package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/16 00:29
 * @description 判断一个数是否是回文数
 * ----临界条件:
 * 不能为负数
 * ----如何反转后半部分数字：
 * 例如 1221
 * 1、得到最后一位数：1221 % 10 -----> 1
 * 2、得到倒数第二位
 * 1221/ 10 = 122
 * 122 % 10 = 2
 * <p>
 * 1 * 10 + 2 =12 -----反转后的数字
 * .......依次内推获得更多的反转数字
 */
public class Palindrome {


    public static boolean judge(int x) {
        long  s =System.currentTimeMillis();
        if (x < 0 || ((x % 10 == 0) && x != 0)) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        long e = System.currentTimeMillis();
        System.out.println("耗时---"+(e-s)+"ms");
        return x==revertNum || x==revertNum/10;
    }


    public static boolean judge1(int x){
        long  s =System.currentTimeMillis();
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        long e = System.currentTimeMillis();
        System.out.println("耗时---"+(e-s)+"ms");
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Palindrome.judge(122222221));
        System.out.println(Palindrome.judge1(1222222221));

    }
}
