package LeetCode;

public class LeetCode_122 {

    /**
     * 贪心策略1
     *
     * 可以折线图，可以发现只要有收益，就可以进行交易。否则不交易。
     *
     * 比如：7 2 3 6 7 6 7
     * 可以直观发现 2 3 6 7 和 6 7 这两个上升阶段。
     * 在 2 3 6 7这个阶段，可以得到收益为5
     * 画出折线图可以发现， 7 - 2 = （3 - 2）+ （6 - 3）+ （7 - 6）
     * 其实可以这么理解
     * 在第二天买入，第三天卖出 收益为1；那么刚卖完后，觉得还会涨，接着买入，再在第四天卖出，收益为3；
     * 刚卖完后，觉得还会涨，接着买入，再在第五天卖出，收益为1；
     *
     * 所以我们可以得到： 只要后一天比前一天有收益，那么就进行交易，否则不交易。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) {
                profit += temp;
            }
        }
        return profit;
    }

    /**
     * 贪心策略2
     *
     * 维护买卖股票的两个指针,在股票涨的前一天买,在股票跌的前一天卖
     */
//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        if (prices.length < 2) {
//            return profit;
//        }
//        int in, out = -1;
//        for (int i = 0; i < prices.length -1; i++){
//            //第二天的股价比第一天高,买入
//            if (prices[i] < prices[i + 1]) {
//                in = i;
//                for (int j = i + 1; j < prices.length; j++) {
//                    //持仓一直到第二天的股价比第一天低(贪心),然后卖出
//                    if (j != prices.length - 1) {
//                        if(prices[j] > prices[j + 1]) {
//                            out = j;
//                            i = j;
//                            break;
//                        }
//                    } else { //股价一路飙升,最后一天股价最高
//                        out = j;
//                        i = j;
//                    }
//                }
//                profit += prices[out] - prices[in];
//            }
//        }
//        return profit;
//    }
}
