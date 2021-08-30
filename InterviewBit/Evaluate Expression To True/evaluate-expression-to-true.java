public class Solution {
    public int cnttrue(String A) {
        Integer[][][] dp = new Integer[A.length()][A.length()][2];  // will store number of ways to get true from i-th to j-th expression in dp[i][j][0] and number of ways to get false from i-th to j-th expression in dp[i][j][1]
        for(Integer[][] x : dp) Arrays.fill(x, null);
        String[] s = new String[] {A};  // to pass given string as reference (to save space in recursion stack)
        return trueWays(s, 0, A.length()-1, dp)[0] % 1003;  // call to actual shit and returning only 0-th element of the dp array since the question asks only about number of ways expression evaluates to true
    }

    static Integer[] trueWays(String[] s, int i, int j, Integer[][][] dp) {
        if (i == j) {   // base case, case (i > j) is not required because this function will never be called with i > j anywhere in the code
            return dp[i][j] = new Integer[] {
                    s[0].charAt(i) == 'T' ? 1 : 0,
                    s[0].charAt(i) == 'F' ? 1 : 0
            };
        }
        if(dp[i][j] != null) return dp[i][j];   //memoization
        int tways = 0;  // will store total number of ways expression between index i to j evaluates to true
        int fways = 0;  // will store total number of ways expression between index i to j evaluates to false
        for(int k = i; k < j-1; k += 2) {   // k is incremented by 2 because the expression will be of odd length and every alternate character will be an operator (&, |, ^)
            Integer[] first = trueWays(s, i, k, dp);    // number of ways left half of the expression evaluates to true and false
            Integer[] second = trueWays(s, k+2, j, dp); // number of ways right half of the expression evaluates to true and false
            char operator = s[0].charAt(k+1);
            if (operator == '|') {  // if the operator is OR
                tways += (first[0] * second[0]) + (first[0] * second[1]) + (first[1] * second[0]);  // expression will be true if either of the sides is true
                fways += first[1] * second[1];  // expression will be false if both sides are false
            }
            else if (operator == '&') { // if the operator is AND
                tways += first[0] * second[0];  // expression will be true only if both sides are true
                fways += (first[0] * second[1]) + (first[1] * second[0]) + (first[1] * second[1]);  // expression will be false if either of the sides is false
            }
            else {  // if operator is XOR
                tways += (first[0] * second[1]) + (first[1] * second[0]);   // expression will be true if both sides have opposite boolean expression
                fways += (first[0] * second[0]) + (first[1] * second[1]);   // expression will be false if both sides have same boolean expression
            }
        }
        return dp[i][j] = new Integer[] {tways % 1003, fways % 1003};   // return the ways expression evaluates to true and false
    }
}
