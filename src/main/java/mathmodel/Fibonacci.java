package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/24 10:39
 * @description 斐波那契数列 递归实现--理解
 * 1,1,2,3,5,8,13,21,34
 * 1、找规律建立数学表达式：f(n)=f(n-1)+f(n-2)
 * 2、约束条件：f(1)=f(2)=1
 */
public class Fibonacci {


    public static int comFibonacci(int n) {
        //约束条件
        if (n <= 2) {
            return 1;
        }
        // 递归，调用自身--产生重复计算
        return comFibonacci(n - 1) + comFibonacci(n - 2);
    }

    public static int computeFibnacciForCorrect(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

    public static void main(String[] args) {
        int p = 8;
        System.out.println(Fibonacci.comFibonacci(p));
    }

}
