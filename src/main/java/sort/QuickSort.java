package sort;


import java.util.Arrays;


/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/26 22:34
 * @description 快速排序
 * 随机选择一位数,分别与每一个元素比较，小的放在左边，大的放在右边--partition
 * 递归的进行partition，把左右子数组排序
 */
public class QuickSort {

    /**
     * 面对大量的重复元素，还有改进的空间
     *
     * @param a 排序数组
     * @param l 数组的左边界
     * @param r 数组的右边界
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] a, int l, int r) {
        long sTime = System.currentTimeMillis();
        if (l >= r) {
            return a;
        }
        int i = l;
        int j = r;
        //选择一个基准值
        int key = a[l];
        while (i < j) {
            //从右往左找到第一个小于key的元素--a[j] < key
            while (i < j && a[j] >= key) {
                j--;
            }
            if (i < j) {
                //把找到的数(a[j])放到左边,并移动左边的指针-i++
                a[i] = a[j];
                i++;
            }
            //从左往右找到第一个大于key的元素
            while (i < j && a[i] < key) {
                i++;
            }
            if (i < j) {
                //把找到的数放在右边，并移动右边的指针-j--
                a[j] = a[i];
                j--;
            }
        }
        //因为以上操作已经，把小于key的元素已经放到i-1处，
        //所以当以上操作结束时，应该key放在i处
        a[i] = key;
        //递归的调用，进行partition，把左右两个子数组进行排序
        //左子数组
        quickSort(a, l, i - 1);
        //右子数组
        quickSort(a, i + 1, r);
        long eTime = System.currentTimeMillis();
        System.out.println("quickSort的耗时-->" + (eTime - sTime) + "ms");
        return a;
    }

    /**
     * 利用三向切分
     * 维护三个指针lt  i  gt
     * [lo~lt-1]：全部小于基准值的
     * [gt+1~hi]:全部都是大于基准值
     * [lt~i-1] :全部都是等于基准值
     * [i~gt]:还没有处理的
     * 处理排序数组中存在大量的重复元素，其实不需要对重复的元素进行排序的
     * 性能比上面个方法快很多
     * 思路：
     * 不要让重复元素进入递归子数组，
     * 把等于切分元素的元素归位
     *
     * @param a 需要排序的数组
     * @param l 数组的左边界
     * @param r 数组的右边界
     * @return 排序后数组
     */
    public static int[] quickSortThreePart(int[] a, int l, int r) {
        long sTime = System.currentTimeMillis();
        if (l >= r) {
            return a;
        }
        //定义三个指针
        int lt = l;
        int i = l + 1;
        int gt = r;
        //切分的基准值
        int v = a[l];
        while (i <= gt) {
            if (a[i] < v) {
                //把a[i]放在a[lt]的位置,把a[lt]放在a[i]的位置上
                int t = a[lt];
                a[lt] = a[i];
                a[i] = t;
                lt++;
            } else if (a[i] > v) {
                //把a[i] 放在a[gt]位置，把a[gt]位置放在a[i]的位置
                int t = a[gt];
                a[gt] = a[i];
                a[i] = t;
                gt--;
            } else {
                //lt ~ i:存放等于v的元素，
                i++;
            }
        }
        quickSortThreePart(a, l, lt - 1);
        quickSortThreePart(a, gt + 1, r);
        long eTime = System.currentTimeMillis();
        System.out.println("quickSortThreePart的耗时-->" + (eTime - sTime) + "ms");
        return a;
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {4, 17, 5, 40, 12, 32, 13, 3, 2, 26, 34, 112,
                38, 25, 304, 40, 2, 4, 12, 32, 2, 4, 13, 13, 13, 32, 2};
        int[] a1 = {4, 17, 5, 40, 12, 32, 13, 3, 2, 26, 34, 112,
                38, 25, 304, 40, 2, 4, 12, 32, 2, 4, 13, 13, 13, 32, 2};
        int l = 0;
        int r = a.length - 1;
        System.out.println(Arrays.toString(QuickSort.quickSort(a1, l, r)));
        System.out.println("======三向切分=====");
        System.out.println(Arrays.toString(QuickSort.quickSortThreePart(a, l, r)));
    }


}
