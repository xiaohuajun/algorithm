package leetcode;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/8/2 13:39
 * @description 53. 最大子序和
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
 * <p>示例：输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。</p>
 */
public class MaxSubArray {


  /**
   * dp解法，时间复杂度：O(N);空间复杂度：O(1)
   *
   * <p>遍历整个数组：所有连续子序列的元素的和sum，结果为：ans
   * if(sum > 0):说明sum对ans有增加的效果；
   * if(sum <= 0):说明sum对ans没有增加的效果，应当舍弃，nums[i]赋值给sum；
   * 每次都需要取ans = Math.max(ans,sum);
   * </p>
   *
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    int ans = nums[0];
    int sum = 0;
    for(int num : nums){
      if(sum > 0){
        sum += num;
      }else{
        sum = num;
      }
      ans = Math.max(ans,sum);
    }
    return ans;
  }


  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(nums));

  }

}
