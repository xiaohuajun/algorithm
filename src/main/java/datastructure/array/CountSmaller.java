package datastructure.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/7/12 10:56
 * @description 计算一个数组中元素右边的元素比自己的小的元素个数
 */
public class CountSmaller {

  /**
   * 为了索引数组提供的临时数组
   */
  private  int[] temp;
  /**
   * 最终结果数组
   */
  private  int[] counter;
  /**
   * 索引数组，原始数组元素对应的缩影
   */
  private  int[] indexes;


  /**
   * 计算数组中元素右边的元素比自己小的个数
   *
   * @param nums 需要处理的数组
   * @return
   */
  public  List<Integer> countSmaller(int[] nums) {
    List<Integer> resList = new LinkedList<>();
    int len = nums.length;
    //临界处理
    if (len == 0) {
      return resList;
    }
    //初始化数组
    temp = new int[len];
    counter = new int[len];
    indexes = new int[len];
    //把原始数组的索引放入索引数组
    for (int i = 0; i < len; i++) {
      indexes[i] = i;
    }
    //归并排序原始数组；完成统计任务
    mergeSortAndCountSmallerNum(nums, 0, len - 1);
    for (int i = 0; i < len; i++) {
      resList.add(counter[i]);
    }
    return resList;
  }

  /**
   * 对数组nums [l,r] 区间归并排序，并在排序过程中完成统计小于的个数
   *
   * @param nums 数组
   * @param l    左边界
   * @param r    右边界
   */
  private  void mergeSortAndCountSmallerNum(int[] nums, int l, int r) {
    if (l == r) {
      return;
    }
    int mid = (l + r) >>> 1;
    mergeSortAndCountSmallerNum(nums, l, mid);
    mergeSortAndCountSmallerNum(nums, mid + 1, r);
    //归并排序优化
    //如果索引数组有序，那就没有必要排序,反之继续排序
    if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
      mergeTwoSortedArrAndCountSmallerNum(nums, l, mid, r);
    }
  }


  /**
   * [l,mid] 排序好的 [mid + 1,r] 也是排序好的
   *
   * @param nums 数组
   * @param l    当前左边界
   * @param mid  中位数
   * @param r    右边界
   */
  private  void mergeTwoSortedArrAndCountSmallerNum(int[] nums, int l, int mid, int r) {
    //索引数组值赋给临时数组
    for (int i = l; i <= r; i++) {
      temp[i] = indexes[i];
    }
    int i = l;
    int j = mid + 1;
    //左边界出列，计数
    for (int k = l; k <= r; k++) {
      if (i > mid) {
        indexes[k] = temp[j];
        j++;
      } else if (j > r) {
        indexes[k] = temp[i];
        i++;
        //此时 j 用完了，[7,8,9 | 1,2,3]
        //之前的数就和后面的区间长度构成逆序
        counter[indexes[k]] += (r - mid);
      } else if (nums[temp[i]] <= nums[temp[j]]) {
        indexes[k] = temp[i];
        i++;
        // 此时 [4,5, 6   | 1,2,3 10 12 13]
        // mid                j
        counter[indexes[k]] += (j - mid - 1);
      } else {
        // nums[indexes[i]] > nums[indexes[j]] 构成逆序
        indexes[k] = temp[j];
        j++;
      }
    }
  }


  public static void main(String[] args) {
     int[] nums = new int[]{5, 2, 6, 1};

     CountSmaller countSmaller = new CountSmaller();
    System.out.println(countSmaller.countSmaller(nums));
  }
}
