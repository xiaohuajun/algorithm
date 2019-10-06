package stringalgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/25 21:41
 * @description 寻找字符串中第一个唯一字符串
 */
public class FindFirstUniq {

    /**
     * 寻找字符串中第一个唯一字符串的索引
     * 找不到返回-1
     *
     * @param s 需要处理字符串
     * @return 目标的值在字符串中的索引
     */
    public static int findFirstUniqStr(String s) {
        Map<Character, Integer> cMap = new HashMap<>(16);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            cMap.put(c, cMap.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < len; j++) {
            if (cMap.get(s.charAt(j)) == 1) {
                return j;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(findFirstUniqStr(s));
    }
}
