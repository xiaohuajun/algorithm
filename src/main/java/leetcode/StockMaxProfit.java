package leetcode;

/**
 * @author Danny.
 * @version 1.0
 * @date 2020/8/29 10:55
 * @description 股票买卖的最大利润 不可以同时进件多笔交易
 */
public class StockMaxProfit {

  private static int RES;

  //暴力法-深度优先-dfs:
  // 1、找问题的最近重复性：
  // 当前持有股票：（1）：卖出；（2）：不操作
  // 当前不持有股票：（1）：买入；（2）不操作

  /**
   * time complexity -O(2^n) space complexity-O(n)
   *
   * @param prices 每一天的股票的价格
   * @return maxProfit
   */
  private static int maxProfitBruteForce(int[] prices) {
    //边界条件
    int len = prices.length;
    if (len < 2) {
      return 0;
    }
    //重复性处理
    RES = 0;
    dfs(prices, len, 0, 0, RES);
    return RES;
  }

  /**
   * @param prices 股价数组
   * @param len    数组长度
   * @param index  当前第几天，从0开始
   * @param status 当前状态：0：不持有；1：持有
   * @param profit 当前的收益
   */
  private static void dfs(int[] prices, int len, int index, int status, int profit) {
    //terminator
    if (index == len) {
      RES = Math.max(RES, profit);
      return;
    }
    //current logic
    //drill down
    dfs(prices, len, index + 1, status, profit);
    //当前不持有股票-则需要买入-->0->1;买入需要花钱：上一次收益-当前股价
    if (status == 0) {
      dfs(prices, len, index + 1, 1, profit - prices[index]);
    }
    //当前持有股票-则需要卖出-->1->0;有收入；上一次收益+当前收益
    if (status == 1) {
      dfs(prices, len, index + 1, 0, profit + prices[index]);
    }
  }

  //贪心：今天-昨天 r：r > 0;r < 0;r=0
  //贪心策略：只加整数

  /**
   * time complexity-O(n) ;space complexity-O(1)
   *
   * @param prices 股价
   * @return maxProfit
   */
  private static int maxProfitGreedy(int[] prices) {
    int r = 0;
    int l = prices.length;
    for (int i = 0; i < l - 1; i++) {
      r += Math.max(0, prices[i + 1] - prices[i]);
    }
    return r;
  }

  //DP:状态定义：持有现金：0；持有股票：1---状态转移：cash->stock->cash->stock

  /**
   * time complexity-O(n) ;space complexity-O(n)
   *
   * @param prices 股票价格数组
   * @return maxProfit
   */
  private static int maxProfitDp(int[] prices) {
    int l = prices.length;
    if (l < 2) {
      return 0;
    }
    //dp[i][j]:i表示第i天的最大收益;j:表示当前持有现金还是股票（1：持有股票，0:持有现金）
    //状态转移：cash->stock->cash->stock->cash
    int[][] dp = new int[l][2];
    //base case
    //当前持有现金-没有交易-没有收益
    dp[0][0] = 0;
    //持有股票-当前收益为负数（需要花钱买入股票）
    dp[0][1] = -prices[0];
    for (int i = 1; i < l; i++) {
      //当前持有现金
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      //当前持有股票
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[l - 1][0];
  }

  //DP:滚动变量或者滚动数组进行状态压缩

  /**
   * 使用滚动变量 time complexity-O(n) space complexity-O(1)
   *
   * @param prices 股票价格数组
   * @return maxProfit
   */
  public static int maxProfitCompressStatus(int[] prices) {
    int l = prices.length;
    if (l < 2) {
      return 0;
    }
    //滚动变量
    int cash = 0;
    int stock = -prices[0];

    int preCash = cash;
    int preStock = stock;

    for (int i = 1; i < l; i++) {
      cash = Math.max(preCash, preStock + prices[i]);
      stock = Math.max(preStock, preCash - prices[i]);

      preCash = cash;
      preStock = stock;
    }
    return cash;
  }

  public static void main(String[] args) {
    int[] a = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfitCompressStatus(a));
  }

}
