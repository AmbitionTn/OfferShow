package 其他;

/**
 * 121 买卖股票的最佳时机
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @create 2020/9/16
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxResult = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]){
                maxResult = Math.max(maxResult, prices[i] - minPrice);
                continue;
            }else {
                minPrice = prices[i];
            }
        }
        return maxResult;
    }
}
