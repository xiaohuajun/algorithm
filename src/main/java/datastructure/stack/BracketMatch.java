package datastructure.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/4 13:47
 * @description
 */
public class BracketMatch {

    private static final Map<Character, Character> BRACKETS = new HashMap<>(16);

    static {
        BRACKETS.put(')', '(');
        BRACKETS.put(']', '[');
        BRACKETS.put('}', '{');
    }

    /**
     * 括号匹配
     * 括号都是成对出现的
     * 算法：
     * 遇到左括号入栈
     * 遇到右括号出栈，到hash表中的取出v,判断是否配对
     *
     * @param str 处理的目标字符床
     * @return 是否匹配
     */
    public static boolean isMatch(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int len = str.length();
        StackToArray<Character> stack = new StackToArray<>();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            //匹配左括号
            if (BRACKETS.containsValue(c)) {
                stack.push(c);
                //匹配右括号是否匹配对
            } else if (BRACKETS.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(BRACKETS.get(c))) {
                    return false;
                }
            }
        }
        //全部匹配正确栈中是空的
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String str = "a{b(c[d])f}";
        System.out.println(BracketMatch.isMatch(str));
    }

}
