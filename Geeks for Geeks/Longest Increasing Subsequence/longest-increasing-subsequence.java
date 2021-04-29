import java.io.*;
import java.util.*;


class Solution {
    static int longestSubsequence(int size, int arr[]) {
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0; i < size; i++) { // for every element in the array
            boolean flag = true;
            for(int j = 0; j < dp.size(); j++) {    // find a number which is just greater than the current element (smallest number greater than the current element)
                if (dp.get(j) >= arr[i]) {  // if such a number exists
                    dp.set(j, arr[i]);  // replace it with the current element
                    flag = false;
                    break;
                }
            }
            if (flag) dp.add(arr[i]);   // else, append it to the array
        }
        return dp.size();   // the count of items in the array will be the answer
    }
}


// Driver Code Starts
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    }
}
//Driver Code Ends
