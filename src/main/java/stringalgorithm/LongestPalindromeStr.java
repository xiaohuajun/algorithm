package stringalgorithm;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/25 11:46
 * @description 找出一个字符串的最长回文子串
 */
public class LongestPalindromeStr {

    /**
     * 利用动态规划来解决找出最长回文子串
     * 空间复杂度和时间复杂度都是O(N^2)
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        //只有一个子串那肯定是回文
        if (len <= 1) {
            return s;
        }
        int longestPalindromeIndex = 1;
        String rs = s.substring(0, 1);
        //动态规划的子问题的解-----可以理解每个子问题的状态
        boolean[][] dp = new boolean[len][len];
        /**
         * 最主要的是找到状态和状态转移方程
         * 规定s[l,r]是字符串的左边界，右边界，例如：s=babad，s[0,4] = "babad" , s[0,1]="ba"
         * 寻找状态（子问题的解）
         * dp[l][r] 表示s[l,r]是否构成回文串，boolean类型二维数组，即，s[l,r]是回文子串=>dp[l][r]=true
         * 状态转移方程：
         * 1、当子串包含一个字符，它一定是回文的
         * 2、如果当子串包含2个以上的字符的话: s[l,r] 是一个回文子串，例如:"abccba" 那么 s[l+1,r-1]也一定是
         * 回文子串，即：dp[l][r] = true 成立 =>  dp[l+1][r-1] = true 成立（这种上一个子问题的解可以为下一个
         * 子问题提供一定信息的状态----正是动态规划的特点）----
         * s[l] == s[r] 成立，就接着判断 s[l + 1] 与 s[r - 1]，这很像中心扩散法的逆方法
         * 事实上，当 s[l] == s[r] 成立的时候，dp[l][r] 的值由 dp[l + 1][r - l] 决定
         * ========================
         * 把上面两点归纳一下，只要 s[l + 1, r - 1] 至少包含两个元素，
         * 就有必要继续做判断，否则直接根据左右边界是否相等就能得到原字符串的回文性。
         * 而“s[l + 1, r - 1] 至少包含两个元素”等价于 l + 1 < r - 1，整理得 l - r < -2，或者 r - l > 2。
         *综上所述：
         * 如果一个字符串的左右边界相等，以下二者之一成立即可：
         * 1、去掉左右边界以后的字符串不构成区间，即“ s[l + 1, r - 1]
         * 至少包含两个元素”的反面，即 l - r >= -2，或者 r - l <= 2；
         * 2、去掉左右边界以后的字符串是回文串，具体说，它的回文性决定了原字符串的回文性。
         * 归纳状态方程：dp[l][r] = (s[l]==s[r] && (r-l <= 2 or  dp[l+1][r-1]))
         *
         */
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    //因为substring截取的是（0,1]所以需要判断r-l+1>longestPalindromeIndex
                    if (r - l + 1 > longestPalindromeIndex) {
                        longestPalindromeIndex = r - l + 1;
                        rs = s.substring(l, r + 1);
                    }
                }
            }
        }
        return rs;
    }

    /**
     * 中心扩散法-
     * 遍历每一个字符的索引，并以所遍历的索引为中心，利用回文中心对称的特点往两边扩散
     * 扩散条件：l >=0 && r<len ; s[l]=s[r]
     * 扩散循环体：l--   r++
     * 时间复杂度：O(N^2)  空间复杂度：O(1)
     *
     * @param s 字符串
     * @return 最长回文串
     */
    public static String longestPalindromeForCenter(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            //回文子串长度是奇数  =>  重合索引
            String palindromeOdd = centerSpread(s, len, i, i);
            //回文子串长度是偶数  =>  相邻索引
            String palindromeEven = centerSpread(s, len, i, i + 1);
            String maxLen = palindromeOdd.length() > palindromeEven.length() ?
                    palindromeOdd : palindromeEven;
            if (maxLen.length() > longestPalindrome) {
                longestPalindrome = maxLen.length();
                longestPalindromeStr = maxLen;
            }
        }
        return longestPalindromeStr;
    }

    private static String centerSpread(String s, int len, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 这里要特别小心，跳出 while 循环的时候，是第 1 个满足 s.charAt(l) != s.charAt(r) 的时候
        // 所以，不能取 l，不能取 r
        return s.substring(l + 1, r);
    }


    public static void main(String[] args) {
        String s = "babad";
        System.out.println("=========中心扩散法求解==========");
        System.out.println(LongestPalindromeStr.longestPalindromeForCenter(s));
        System.out.println("=========动态规划求解==========");
        System.out.println(LongestPalindromeStr.longestPalindrome(s));
    }


}
