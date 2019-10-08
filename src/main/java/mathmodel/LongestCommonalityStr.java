package mathmodel;

import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/22 12:20
 * @description 两个字符串的最长公共操作
 * 子串：要求连续
 * 序列：要求顺序一样，不连续
 */
public class LongestCommonalityStr {

    /**
     * 求两个字符串最长公共的子序列
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 两个字符串的最长公共子序列（不需要连续）
     */
    public static int[][] getLcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[j][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp;
    }


    public static String maxSubstring(String strOne, String strTwo) {

        // 矩阵的横向长度
        int len1 = strOne.length();
        // 矩阵的纵向长度
        int len2 = strTwo.length();
        // 保存矩阵的上一行
        int[] topLine = new int[len1];
        // 保存矩阵的当前行
        int[] currentLine = new int[len1];
        // 矩阵元素中的最大值
        int maxLen = 0;
        // 矩阵元素最大值出现在第几列
        int pos = 0;
        for (int i = 0; i < len2; i++) {
            // 遍历str1，填充当前行的数组
            for (int j = 0; j < len1; j++) {
                if (strTwo.charAt(i) == strOne.charAt(j)) {
                    // 如果当前处理的是矩阵的第一列，单独处理，因为其坐上角的元素不存在
                    if (j == 0) {
                        currentLine[j] = 1;
                    } else {
                        currentLine[j] = topLine[j - 1] + 1;
                    }
                    if (currentLine[j] > maxLen) {
                        maxLen = currentLine[j];
                        pos = j;
                    }
                }
            }
            // 将矩阵的当前行元素赋值给topLine数组; 并清空currentLine数组
            for (int k = 0; k < len1; k++) {
                topLine[k] = currentLine[k];
                currentLine[k] = 0;
            }
            // 或者采用下面的方法
            // topLine = currentLine;
            // currentLine = new int[len1];
        }
        return strOne.substring(pos - maxLen + 1, pos + 1);
    }


    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "acba";
        System.out.println(Arrays.toString(getLcs(s1, s2)));
    }

}
