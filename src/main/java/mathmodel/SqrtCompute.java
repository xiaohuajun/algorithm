package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/26 16:47
 * @description 已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后10 位。
 * 分析：只需要在[1.41,1.42] 中找 0.001  l = 1.41   r = 1.42  mid = (l+r)/2
 * 循环退出条件：r-l <= flag
 */
public class SqrtCompute {


    /**
     * 利用二分查找
     *
     * @return
     */
    public static double computeSqrt() {
        double l = 1.41;
        double r = 1.42;
        double mid = (l + r) / 2;
        double flag = 0.0000000001;
        while (r - l > flag) {
            mid = (l + r) / 2;
            //这个表达式的规则见笔记
            if (mid * mid < 2) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(SqrtCompute.computeSqrt());
    }

}
