package LeetCode;

public class LeetCode_121 {

    //一次遍历  时间复杂度  O(N^2) 一般寻找最低价，一遍更新最大利润。
    // minV = Math.min(minV, prices[i]); 通过不断跟当前最低值比较，得到当前最低的利润。
    // prices[i] - minV; 当前时间价格减掉当前最低的价格，就是当前的利润，不断跟最大利润进行比较，得到最高的利润。
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxP = 0;
        int minV = prices[0];
        for (int i = 0; i < prices.length; i++){
            minV = Math.min(minV, prices[i]);
            maxP = Math.max(maxP, (prices[i] - minV));
        }
        return maxP;
    }

    // 暴力法    时间复杂度  O(N^2)
//    public int maxProfit(int[] prices) {
//        int maxP = 0;
//        for (int i = 0; i < prices.length; i++){
//            for (int j = i + 1; j < prices.length; j++) {
//                int temp = prices[j] - prices[i];
//                if (temp > maxP) {
//                    maxP = temp;
//                }
//            }
//        }
//        return maxP;
//    }
}
