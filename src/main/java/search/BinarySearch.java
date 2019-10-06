package search;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/16 10:50
 * @description 有序数组的二分查找
 */
public class BinarySearch {


    public static int binarySearch(int key, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //推荐写法:(left + right) >>> 1
            //不推荐的写法：(left + right) / 2--当right、left很大的时候会有溢出的可能性
            // 溢出可能性比较小：left + (right - left) / 2
            int mid = (left + right) >>> 1;
            //key小的清况，说明key在左边，应该向左二分r--
            if (nums[mid] > key) {
                right = mid - 1;
                //key大的清况，说明key在右边，应该向右二分。l++
            } else if (nums[mid] < key) {
                left = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int k = 0;
        int[] a = {-1, 0, 3, 5, 9, 12};
        System.out.println(BinarySearch.binarySearch(k, a));
    }
}
