package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/8/2 13:27
 * @description 363. 矩形区域不超过 K 的最大数值和 ;
 * <p>给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 说明：</p>
 * <p> 矩阵内的矩形区域面积必须大于 0。 如果行数远大于列数，你将如何解答呢？
 * example:
 * 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出: 2
 * 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 *
 */
public class MaxSumSubmatrix {


  /**
   * 算法：
   * 前缀和：
   * <p>
   *   1.固定左边界和右边界:l , r
   *   2.初始化:l,r 同一列
   *   3. r从左往右走
   *   4.用一个一维数组存储rowSum[]：r 没走一次走一次累计每一行的和
   *   5.在rowSum中寻找不大于k最大值
   * </p>
   *
   * @param matrix 二维数组
   * @param k
   * @return
   */
  public static int maxSumSubmatrix(int[][] matrix,int k){
      int rows = matrix.length,cols = matrix[0].length,max = Integer.MIN_VALUE;
      //固定左右边界
      for(int l = 0;l < cols;l++){
          //存每一行的和
          int[] rowsSum = new int[rows];
          for(int r = l;r < cols;r++){
            //每一行存储到rowsSum
            for(int i = 0;i < rows;i++){
                rowsSum[i] += matrix[i][r];
            }
            max = Math.max(max,dpMax(rowsSum,k));
          }
      }
    return max;
  }

  /**
   * 找到不大于k的连续子序列的和
   * @param rowsSum
   * @param k
   * @return
   */
  private static int dpMax(int[] rowsSum, int k) {
    int rollSum  = rowsSum[0];
    int rollMax = rollSum;
    for(int num : rowsSum){
      if(rollSum > 0){
        rollSum += num;
      }else {
        rollSum = num;
      }
      if(rollSum > rollMax){
        rollMax = rollSum;
      }
    }
    if(rollMax <= k){
      return rollMax;
    }
   int max = Integer.MIN_VALUE;
   for(int l = 0;l < rowsSum.length;l++){
     int sum = 0;
     for(int r = l;r < rowsSum.length;r++){
       sum += rowsSum[r];
       if(sum > max && sum <= k){
         max = sum;
       }
       if(max == k){
         return k;
       }
     }
   }
   return max;
  }


  public static void main(String[] args) {
    int[][] matrix = {{1,0,1},{0,-2,3}};
    System.out.println(maxSumSubmatrix(matrix,2));
  }
}
