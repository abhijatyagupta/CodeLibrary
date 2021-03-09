import java.io.*;
import java.util.*;

class GFG {
    public static int findSubarray(int[] arr ,int n) {
        HashMap<Integer, Integer> prefix = new HashMap<>(); // will store prefix sum of given array and their count
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if (prefix.containsKey(sum)) {  // if this sum already exists
                count += prefix.get(sum);       // add to count, the frequency of this sum (since the sums are same, difference between these will be zero, i.e. a subarray with sum 0 is found)
                prefix.replace(sum, prefix.get(sum) + 1);   // increment the count of this sum
            }
            else {  // if this sum never appeared before
                prefix.put(sum, 1); // add it to the map
            }
        }
        if (prefix.containsKey(0)) count += prefix.get(0);  // also include the count of sum 0 to account for the element 0 itself in the array
        return count;
    }


    // Driver Code Starts
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0) {
            int n;
            n=sc.nextInt();

            int arr[]=new int[n];

            for(int i=0;i<n;i++) {
                arr[i]=sc.nextInt();
            }

            System.out.println(findSubarray(arr,n));
        }

    }
    // Driver Code Ends
}
