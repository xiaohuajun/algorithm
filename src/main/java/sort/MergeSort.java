package sort;


import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/16 18:03
 * @description
 * 归并排序：两个有序数组合并一个有序数组
 * 1、声明一个新的空间的存放合并后的数组
 * 2、定义两个指针分别用来标记各自数组的初始位置
 * 3、比较两个指针指向的元素的大小，把小的放入合并数组
 * 4、重复3步，并且把剩下的元素放到合并数组的尾部
 */
public class MergeSort {


    /**
     * 空间复杂度：O(m+n)
     * 时间复杂度：O(m+n)
     * 合并成新的数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    private static int[] mergeSort(int[] nums1, int m, int[] nums2, int n) {
        int[] c = new int[m + n];
        int i, j, k;
        //标记起始位置
        i = j = k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                c[k++] = nums1[i++];
            } else {
                c[k++] = nums2[j++];
            }
        }
        //把上面过程剩下的元素复制到尾部
        while (i < m) {
            c[k++] = nums1[i++];
        }
        while (j < n) {
            c[k++] = nums2[j++];
        }
        return c;
    }

    /**
     * 空间复杂度：O(m)
     * 时间复杂度：O(m+n)
     * 两个指针，从两个数组的初始位置，开始扫描，比较两个指针所指向的元素
     * 小的放入合并的数组并移动指针，最后的把剩下的元素，加入合并的尾部
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static void mergeSortForSaveSpace(int[] nums1, int m, int[] nums2, int n) {
        //合并后的元素合并到nums1中，先把数组中的元素，复制到另一个数组，进行操作
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int i, j, k;
        i = j = k = 0;
        while (i < m && j < n) {
            nums1[k++] = nums1Copy[i] < nums2[j] ? nums1Copy[i++] : nums2[j++];
        }
        if (i < m) {
            System.arraycopy(nums1Copy, i, nums1, i + j, (m + n) - (i + j));
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, (m + n) - (i + j));
        }
    }


    /**
     * 空间复杂度为：O(1)
     * 时间复杂度：O(m+n)
     * 两个指针：从后往前，比较两个指针所指向的元素的大小，大的放入合并的数组，
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeSortForThanSaveSpace(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        /*int[] c = MergeSort.mergeSort(nums1, m, nums2, n);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }*/
       /* System.out.println("=====空间复杂度：O(m)=======");
        MergeSort.mergeSortForSaveSpace(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));*/
        System.out.println("=====空间复杂度：O(1)=======");
        MergeSort.mergeSortForThanSaveSpace(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        //复制数组的用法
      /* System.arraycopy(nums1, 3, nums2, 0, 3);
        System.out.println(Arrays.toString(nums2));*/
        //求中位数
       /* int len = c.length;
        int midNum;
        if (len % 2 == 0) {
            midNum = (c[len / 2 - 1] + c[len / 2]) / 2;
            System.out.println(midNum);
        } else {
            midNum = c[len / 2];
        }
        System.out.println(midNum);*/

    }
}
