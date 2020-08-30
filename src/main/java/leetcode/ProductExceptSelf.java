package leetcode;

import java.util.Arrays;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/8/30 15:12
 * @description 求-除自身以外数组的乘积 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题
 */
public class ProductExceptSelf {

  //n[i]的乘积：i处左边的乘积*右边的乘积
  //L[i]乘积：L[0]:因为没有左边为：L[0]=1；L[i - 1]*n[i - 1];
  //R[i]乘积：R[l-1]:没有右边：R[l-1]=1;R[i + 1]*n[i + 1]

  /**
   * time complexity-O(N) space complexity-O(N)
   *
   * @param nums 数组
   * @return product array
   */
  public static int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] left = new int[len];
    int[] right = new int[len];

    int[] ans = new int[len];
    //base case
    left[0] = 1;
    right[len - 1] = 1;

    //left product
    for (int i = 1; i < len; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }
    //right product
    for (int i = len - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }
    for (int i = 0; i < len; i++) {
      ans[i] = left[i] * right[i];
    }
    return ans;
  }

  //空间优化：O(1):题目要求-输出数组不算做额外空间

  /**
   * @param nums 数组
   * @return
   */
  private static int[] productExcepSelfSpace(int[] nums) {
    int len = nums.length;
    //当做左边的乘积
    int[] ans = new int[len];

    ans[0] = 1;

    for (int i = 1; i < len; i++) {
      ans[i] = ans[i - 1] * nums[i - 1];
    }

    //计算右边所有元素的乘积
    //刚开始右边还没有元素：1
    int r = 1;
    //右边开始
    for (int i = len - 1; i >= 0; i--) {
      ans[i] = ans[i] * r;
      //右边所有元素乘积
      r *= nums[i];
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(Arrays.toString(productExcepSelfSpace(nums)));
  }

}
