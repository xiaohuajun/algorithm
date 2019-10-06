package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/21 17:11
 * @description 计算两个整数字符串之和
 *
 */
public class ComputeTwoStrSum {


    public static String addString(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "51189";
        String s2 = "967895";
        System.out.println(ComputeTwoStrSum.addString(s1, s2));
    }


}
