class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            int current = prices[i];
            if (current == min) continue;
            if (current < min) min = current;
            else if (profit < current - min) profit = current - min;
        }
        return profit;
    }
}