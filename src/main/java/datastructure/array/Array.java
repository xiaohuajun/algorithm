package datastructure.array;


import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/10/2 20:24
 * @description 数据结构--数组
 * 1、固定大小空间
 * 2、连续存储
 */
public class Array {


    private int[] a;

    private int e;


    public Array(int size) {
        a = new int[size];
        e = 0;
    }

    public int size() {
        return a.length;
    }

    public int findMaxValue() {
        int max = 0;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public int findSecondValue() {
        int max, second;
        max = second = Integer.MIN_VALUE;
        if (e >= 2) {
            for (int i : a) {
                if (i > max) {
                    second = max;
                    max = i;
                } else if (second < i && i < max) {
                    second = i;
                }
            }
        }
        return second;
    }

    /**
     * add element
     *
     * @param value add a value to the array
     */
    public void add(int value) {
        a[e++] = value;
    }

    /**
     * 需要删除的元素在数组中比较多的情况
     *
     * @param value delete the value in array
     * @return current array length after deleting the value
     */
    public int[] delete(int value, int[] an, int s) {
        int i = 0;
        for (int j = 0; j < an.length; j++) {
            if (value != an[j]) {
                an[i] = an[j];
                i++;
            }
        }
        int[] res = new int[i];
        System.arraycopy(an, 0, res, 0, i);
        return res;
    }

    /**
     * 使用与删除的value在数组不多的情况
     *
     * @param val
     * @param na
     * @return
     */
    public int[] delete(int val, int[] na) {
        int len = na.length;
        int i = 0;
        while (i < len) {
            if (na[i] == val) {
                na[i] = na[len - 1];
                len--;
            } else {
                i++;
            }
        }
        return na;
    }


    /**
     * find a value in array
     *
     * @param key    target value
     * @param isSort the array whether is sorted
     * @return a index for key in array
     */
    public int find(int key, boolean isSort) {
        if (isSort) {
            return binarySearch(key);
        } else {
            return commonSearch(key);
        }
    }

    /**
     * common traversal array
     *
     * @param k search a target value in array
     * @return if cannot find a value in array that return -1
     */
    private int commonSearch(int k) {
        for (int i : a) {
            if (i == k) {
                return i;
            }
        }
        return -1;
    }

    /**
     * a sorted array to binary search
     *
     * @param k search a target value in array
     * @return if cannot find a value in array that return -1
     */
    private int binarySearch(int k) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) >>> 1;
            if (a[mid] > k) {
                h = mid - 1;
            } else if (a[mid] < k) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 两个指正，j 是快指针，i 是慢指针
     *
     * @param nums
     * @return
     */
    public int[] removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        int[] na = new int[i + 1];
        System.arraycopy(nums, 0, na, 0, i + 1);
        return na;
    }


    public static void main(String[] args) {
        Array a = new Array(8);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(0);
        a.add(4);
        a.add(2);
        int[] an = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] a1 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("=======去掉重复元素=========");
        System.out.println(Arrays.toString(a.removeDuplicates(an)));
        System.out.println("=======删除某个元素=======");
        System.out.println(Arrays.toString(a.delete(2, a1, 1)));
    }

}
