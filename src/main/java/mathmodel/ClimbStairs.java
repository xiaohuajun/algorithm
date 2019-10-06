package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/24 12:03
 * @description 一只青蛙一次可以跳一级台阶，也可以跳两级台阶，n级台阶有多少种跳法
 * 分析：
 * 1级台阶，就有1种跳法
 * 2级台阶，有2种跳法
 * 3级台阶，就有3种
 * 4级台阶，5种
 * ---------
 * 第一种情况：第一步跳1的话，那f(n-1)=n-1种跳法（包含所有1的情况）
 * 第二种清理：第一步跳2的话，那f(n-2)=n-2种跳法（包含所有2的情况）
 * 所以：n级台阶总共有：f(n)=f(n-1)+f(n-2)种跳法
 * 约束条件：f(1)=1   f(2)=2
 */
public class ClimbStairs {

    /**
     * 用动态规划来解决
     * 时间复杂度 O(n)
     * 空间复杂度 ：声明一个数组空间，也是O(n)
     *
     * @param n 台阶数
     * @return 总的跳法
     */
    public static int computeNStep(int n) {
        if (n == 1) {
            return 1;
        }
        //采用n+1的空间，方便计算,因为数组索引从0开始
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 使用斐波那契数列去解决
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)---second
     *
     * @param n
     * @return
     */
    public static int byFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        int pa = 10000;
        System.out.println(ClimbStairs.byFibonacci(pa));
    }
}
