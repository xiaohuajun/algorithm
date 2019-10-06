package mathmodel;

/**
 * @author Danny.
 * @version 1.0
 * @date 2019/9/22 11:06
 * @description 用一个数组描述
 * 它的第 i 个元素是一支给定股票第 i 天的价格它的第 i 个元素是一支给定股票第 i 天的价格
 */
public class StockMaxProfit {

    /**
     * 最多只能进行一笔交易，设计一个计算方法来获取最大利润
     *
     * @param stockPrice 股票每一天的价格
     * @return
     */
    public static int maxProfit(int[] stockPrice) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : stockPrice) {
            if (i < minPrice) {
                minPrice = i;
            } else if (i - minPrice > maxProfit) {
                maxProfit = i - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 可进行多笔交易--关注连续的波峰和波谷
     *
     * @param prices 价格波动
     * @return 多笔交易之和
     */
    public static int maxProfitForMoreExchange(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitForMoreExchange(a));
    }

}
