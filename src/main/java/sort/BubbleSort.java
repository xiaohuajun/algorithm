package sort;

import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/27 09:46
 * @description 冒泡排序
 * 思路两两比较大小，如果第一个比第二个大的话，交换位置
 * 优化：数组排好序后，仍然会循环每一趟去进行比较，直到 arr.lenght-1;
 */
public class BubbleSort {


    /**
     * 思路两两比较大小，如果第一个比第二个大的话，交换位置
     * 优化：数组排好序后，仍然会循环每一趟去进行比较，直到 arr.lenght-1;
     *
     * @param arr need sort array
     * @return needed sort array
     */
    public static int[] bubbleSort(int[] arr) {
        long sTime = System.currentTimeMillis();
        //定义一个临时变量
        int tmp;
        //是否有意义进行比较
        boolean isCompare;
        int len = arr.length - 1;
        if (arr.length < 2) {
            return arr;
        }
        //需要排序的回数len
        for (int i = 0; i < len; i++) {
            isCompare = false;
            //第i回的两个数之间的比较,比较次数：len-i
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    //把小的放在arr[j]这个位置=>因为是第一个
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isCompare = true;
                }
            }
            if (!isCompare) {
                break;
            }
        }
        long eTime = System.currentTimeMillis();
        System.out.println("BubbleSort的耗时-->" + (eTime - sTime) + "ms");
        return arr;
    }


    public static void main(String[] args) {
        int[] a = {3, 4, 2, 18, 9, 15};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(a)));
    }
}
