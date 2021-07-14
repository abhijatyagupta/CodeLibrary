class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0) return 0;
        if (prices.length <= 2*k) { // if the number of days are less than or equal to 2k then k can be assumed infinite
            int profit = 0;
            for(int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
            }
            return profit;
        }

        int[][] dp = new int[k+1][prices.length];   // memoization for bottom-up approach. This will store the maximum possible profit if i transactions were allowed till j-th day

        for(int i = 1; i <= k; i++) {   // start calculating from when 1 transaction is allowed till when k transactions are allowed
            int max = dp[i-1][0] - prices[0];   // maximum profit if i-1 transactions were allowed till yesterday + 1 transaction between today and yesterday (hence, today's stock price - prices[0] (price of yesterday's share) but today's stock price was omitted because it will be factored in when traversing through each day)
            for(int j = 1; j < prices.length; j++) {    // for each day
                max = Math.max(max, dp[i-1][j-1] - prices[j-1]);    // compare max profit and profit when, corresponding to current day, i-1 transactions were allowed till yesterday + 1 transaction between today and yesterday (hence, today's stock price - prices[j-1] (price of yesterday's share) but today's stock price was omitted because it is factored in in the next step)
                dp[i][j] = Math.max(dp[i][j-1], max + prices[j]);   // maximum possible profit till today (the required answer) will be max(profit when i transactions were allowed till yesterday, max + today's stock price)
            }
        }
        return dp[k][prices.length-1];  // the required answer
    }
}