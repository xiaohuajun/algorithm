package search;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/16 18:26
 * @description 给一个整数数组，写一个程序有效地找到数组第二大的数
 * 1、声明一个最大值max,最小值secondMax
 * 2、遍历数组，if某个元素比max大，那就这个元素就是最大值。。。。，
 * 3、if某个元素小于max且大于secondMax 那这个元素就是secondMax;
 * 分析临界情况：
 * [1]只有一个元素
 */
public class FindSecondLargest {

    public static int findSecLargestInArray(int[] arr) {
        int arrSize = arr.length;
        int max, secondMax;
        max = secondMax = Integer.MIN_VALUE;
        //必须有两个元素
        if (arrSize >= 2) {
            for (int i = 0; i < arrSize; i++) {
                if (arr[i] > max) {
                    secondMax = max;
                    max = arr[i];
                } else if (arr[i] > secondMax && arr[i] < max) {
                    secondMax = arr[i];
                }
            }
        }
        return secondMax;
    }


    public static void main(String[] args) {
        int[] a = {12, 35, 1, 10, 34, 1, 2, 34, 54, 20, 15,
                23, 29, 39, 44, 50, 60, 80, 80, 90, 48};
        int sc = FindSecondLargest.findSecLargestInArray(a);
        System.out.println(sc);

    }

}
