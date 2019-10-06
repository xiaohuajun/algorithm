package datastructure.stack;


/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/3 20:47
 * @description 栈的使用
 */
public class ReverseStr {


    /**
     * 使用栈来进行逆序
     *
     * @param str 需要处理的字符串
     * @return 逆序的结果
     */
    public static String reverseStr(String str) {

        int len = str.length();
        StackToArray<Character> stack = new StackToArray<>(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a{b(c[d])f}";
        System.out.println(ReverseStr.reverseStr(str));
    }

}
