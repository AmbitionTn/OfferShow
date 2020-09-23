package 剑指Offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * @author taoning
 * @URL:https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @create 2020/9/16
 */
public class _剑指Offer63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxResult = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                maxResult = Math.max(maxResult, prices[i] - minPrice);
                continue;
            } else {
                minPrice = prices[i];
            }
        }
        return maxResult;
    }
}
