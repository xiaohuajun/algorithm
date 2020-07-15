package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/7/15 16:08
 * @description 股票连续交易的最大利润
 */
public class MaxProfit {


  /**
   * 谷峰法：寻找连续的波峰和波谷差值累加
   *
   * @param prices 股票交易的价格
   * @return 最大利润
   */
  public static int maxProfit(int[] prices) {
    int len = prices.length;
    int i = 0;
    //波谷
    int valley;
    //波峰
    int peak;
    int maxProfit = 0;
    while (i < len - 1) {
      while (i < len - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < len - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxProfit += peak - valley;
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] prices = new int[]{7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
  }

}
