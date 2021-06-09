import java.io.*;
import java.util.*;

class Sol {
    public static int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> set = new HashSet<>();
        for(String x : B) set.add(x);
        int[][] dp = new int[A.length() + 1][A.length() + 1];
        for(int[] x : dp) Arrays.fill(x, -1);
        return canSegment(A, set, 0, A.length(), dp);   // call to actual shit
    }

    static int canSegment(String s, HashSet<String> set, int i, int j, int[][] dp) {
        if (i > j) return 0;
        int length = s.substring(i, j).length();
        if (length == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];    // memoization
        for(int k = i; k <= j; k++) {   // for each possible substring from the given string
            if (set.contains(s.substring(i, k)) && canSegment(s, set, k, j, dp) == 1) { // if half substring is present in the dictionary and the other half can be made using the dictionary
                dp[i][j] = 1;
                return 1;   // return true
            }
        }
        return 0;
    }
}


// Driver Code Starts
public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<String>();
            for(int i = 0;i<n;i++) {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.wordBreak(line,arr));

        }
    }
}
// Driver Code Ends
