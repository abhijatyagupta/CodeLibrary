class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int[] arr1 = new int[prices.length];    // will store the max profit that can be made if transactions were allowed till i-th day
        int[] arr2 = new int[prices.length];    // will store the max profit that can be made if transactions were allowed from i-th day

        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {    // for each day
            if (prices[i] < min) {  // if a new minimum stock price is found
                min = prices[i];    // update minimum
                arr1[i] = maxProfit;    // maximum profit till today will be same
            }
            else {  // if the stock price today is higher than minimum so far, i.e. profit can be made
                int profit = prices[i] - min;   // calculate profit
                arr1[i] = Math.max(profit, maxProfit);  // compare today's profit with max profit so far and store it
                if (maxProfit < profit) maxProfit = profit; // update max profit as well
            }
        }
        int max = prices[prices.length - 1];
        maxProfit = 0;
        for(int i = prices.length - 2; i >= 0; i--) {   // for each day
            if (prices[i] > max) {  // if a new maximum stock price is found
                max = prices[i];    // update maximum
                arr2[i] = maxProfit;    // maximum profit that can be made from this day will be same
            }
            else {  // if today's stock price is lower than maximum so far, i. e. if stock was bought on this day and sold on the maximum price day, profit can be made
                int profit = max - prices[i]; // calculate profit
                arr2[i] = Math.max(profit, maxProfit);  // compare today's profit with max profit so far and store it
                if (maxProfit < profit) maxProfit = profit; // update max profit as well
            }
        }
        max = 0;
        for(int i = 0; i < prices.length; i++) {    // for each day
            if (arr1[i] + arr2[i] > max) max = arr1[i] + arr2[i];   // calculate the maximum profit that can be made if transactions were allowed till the i-th day and if transactions were allowed starting from the i-th day
        }
        return max;
    }
}