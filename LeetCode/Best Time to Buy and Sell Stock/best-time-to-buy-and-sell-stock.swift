class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        if (prices.count == 1) { return 0 }
        var profit : Int = 0
        var min : Int = prices[0]
        for i in 1..<prices.count {
            let current : Int = prices[i]
            if (current == min) { continue }
            if (current < min) { min = current }
            else if (profit < current - min) { profit = current - min }
        }
        return profit
    }
}
