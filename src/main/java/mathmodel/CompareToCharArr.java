package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/15 21:42
 * @description 快速查找两个顺序和值都一样的char[]数组bu
 * 例如：char1 [a,b,c,d,e,f,g] [a,b,c,d,e,f,g],快速找出e
 * 1、java中的char 是UNICODE编码
 * 2、char运算也就是ASCII码运算
 * ASCII码：a~z:[65~90]   A~Z:[97~112]
 */
public class CompareToCharArr {


    public static char findDiffChar(char[] char1, char[] char2) {
        char r = 0;
        char h = 0;
        for (int i = 0; i < char1.length; i++) {
            r += char1[i];
        }
        for (int i = 0; i < char2.length; i++) {
            h += char2[i];
        }
        return (char) ((r - h) < 0 ? -(r - h) : r - h);
    }

    public static void main(String[] args) {
        char[] c2 = {'a', 'b', 'c', 'd', 'f', '(', 'g'};
        char[] c1 = {'a', 'b', 'c', 'd', 'f', 'g'};
        System.out.println(CompareToCharArr.findDiffChar(c1, c2));
    }
}
