public class Solution {
    public String multiple(int A) {
        if (A <= 1) return String.valueOf(A);
        Queue<Integer> queue = new LinkedList<>();  // queue to perform bfs on remainders
        String[] dp = new String[A];    // will hold, on the i-th position, the number with only 0s and 1s which when divided by A gives remainder i
        dp[1] = "1";    // for most cases, 1 % A will be 1
        queue.offer(1);
        while(!queue.isEmpty()) {
            int remainder = queue.poll();   // pop the remainder from queue
            if (remainder == 0) return dp[remainder];   // if the remainder is 0, return the number with only 0s and 1s from dp array
            for(int num : new int[] {0, 1}) {   // make new numbers by appending 0 or 1 to the current number
                int nextRemainder = ((10 * remainder) + num) % A;   // this is formula to get remainder when the new number gets divided by A
                if (dp[nextRemainder] == null) {    // if this remainder was not seen before
                    queue.offer(nextRemainder); // add the remainder to queue
                    dp[nextRemainder] = dp[remainder] + (num == 0 ? "0" : "1"); // add the new number (made by appending 0 or 1 to the current number) against the corresponding remainder index in dp array
                }
            }
        }
        return "";
    }
}
