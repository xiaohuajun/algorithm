package mathmodel;

import sort.QuickSort;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/27 19:24
 * @description 求数组的中位数
 */
public class MidNumInArr {


    public static int midNum(int[] a) {
        int len = a.length;
        //先排序
        QuickSort.quickSort(a, 0, len - 1);
        return (a[0] + a[len - 1]) / 2;
    }


    public static void main(String[] args) {
        int[] a = {2, 5, 4, 9, 3, 6, 8, 7, 1};
        System.out.println(MidNumInArr.midNum(a));
    }
}
