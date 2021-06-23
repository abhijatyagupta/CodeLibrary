class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        if (prices.count == 1) { return 0 }
        var profit : Int = 0
        for i in 1..<prices.count {
            if (prices[i] > prices[i-1]) { profit += prices[i] - prices[i-1] }
        }
        return profit
    }
}
