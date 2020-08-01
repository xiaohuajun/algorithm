package search;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/8/16 10:50
 * @description 有序数组的二分查找 二分查询满足的条件： 1、具有单调性 2、具有左右边界 3、能通过index进行访问
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

  /**
   * 搜索旋转有序数据，部分有序
   *
   * @param nums
   * @param target
   * @return
   */
  public static int searchForPartSorted(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int l = 0;
    int r = nums.length - 1;
    int mid;
    while (l <= r) {
      mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      //前半部分有序
      if (nums[l] <= nums[mid]) {
        if (target < nums[mid] && target >= nums[l]) {
          //在前半部分
          r = mid - 1;
        } else {
          //后半部分
          l = mid + 1;
        }
      } else {
        if (target > nums[mid] && target <= nums[r]) {
          //后半部分
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    int k = 0;
    int[] a = {4,5,6,7,0,1,2};
    System.out.println(BinarySearch.searchForPartSorted(a, k));
  }
}
