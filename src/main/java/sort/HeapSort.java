package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/11 13:13
 * @description 堆排序
 * 节点的位置公式：
 * parent(n) = (n-1)/2
 * left(n) = 2n+1
 * right(n) = 2n+2;
 */
public class HeapSort {

    /**
     * 父节点
     *
     * @param n 节点的索引
     * @return 父节点
     */
    private int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * 左子结点
     *
     * @param n
     * @return
     */
    private int left(int n) {
        return 2 * n + 1;
    }

    /**
     * 右子节点
     *
     * @param n
     * @return
     */
    private int right(int n) {
        return 2 * n + 2;
    }

    /**
     * 构建一个最小堆
     *
     * @param a 堆元素
     * @param k 节点总数-构建堆的大小
     */
    public static void makeMinHeap(int[] a, int k) {
        //从根节点构造最小堆
        for (int i = (k - 1) / 2; i >= 0; i--) {
            adjustHeap(a, i, k);
        }
    }

    /**
     * 调整堆的逻辑
     * 1、从左右子节点找到最小的节点
     * 2、比较当前节点和找到的子节点比较
     * 3、小于子节点的直接点抛弃，大于子节点的
     *
     * @param a 数组
     * @param i 当前节点的索引
     * @param n 总结点-堆的大小
     */
    private static void adjustHeap(int[] a, int i, int n) {
        //定义左子结点的索引
        int j = 2 * i + 1;
        int temp;
        while (j < n) {
            //找到左右子节点中最小的节点
            if (j + 1 < n && a[j + 1] < a[j]) {
                j++;
            }
            //改成最大堆---找最大的
            /*if (j + 1 < n && a[j + 1] > a[j]) {
                j++;
            }*/
            //根节点比左右子节点都要小，直接抛弃
            if (a[i] <= a[j]) {
                break;
            }
            //max heap
           /* if (a[i] > a[j]) {
                break;
            }*/
            //大的往下沉
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i = j;
            j = 2 * i + 1;
        }
    }

    /**
     * 1、堆首和堆尾互换，
     * 2、尺寸减1
     * 3、调整堆:从当前堆中的0开始调整
     *
     * @param a 数组
     * @param n 总结点数
     */
    public static void heapSort(int[] a, int n) {
        makeMinHeap(a, n);
        for (int i = n - 1; i > 0; i--) {
            //堆首和堆尾互换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            //尺寸减1,从0开始调整堆
            adjustHeap(a, 0, i);
        }

    }

    /**
     * 取topN
     *
     * @param a
     * @param n
     * @return
     */
    public static int[] topN(int[] a, int n) {
        makeMinHeap(a, n);
        //处理n后面的元素
        for (int i = n; i < a.length; i++) {
            //如果后面的元素大于堆首元素，那替换
            if (a[i] > a[0]) {
                int t = a[i];
                a[i] = a[0];
                a[0] = t;
                adjustHeap(a, 0, n);
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int[] arr = {56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};
        int len = arr.length;
        //堆排序
        heapSort(arr, len);
        System.out.println("=========最小堆=========");
        System.out.println(Arrays.toString(arr));
//        System.out.println("===========topN=======");
//        System.out.println(Arrays.toString(topN(arr, 5)));

    }
}
