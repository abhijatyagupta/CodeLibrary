import java.io.*;
import java.util.*;

class Solution {
    long countTriplets(long arr[], int n,int sum) {
        long count = 0;
        Arrays.sort(arr);   // sort the array for easy traversal
        for(int i = 0; i < n-2; i++) {  // for each first element of a potential triplet
            int left = i+1;
            int right = n-1;
            while(left < right) {
                if (arr[i] + arr[left] + arr[right] >= sum) right--;    // if sum is greater than or equal to the target sum, decrement right pointer to lower sum value
                else {
                    count += right - left;  // if sum is less than target, then triplets can be made with all the elements between left and right
                    left++;
                }
            }
        }
        return count;
    }
}


// Driver Code Starts
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int k =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            long ans=ob.countTriplets(a,n,k);
            System.out.println(ans);
        }
    }
}
// Driver Code Ends