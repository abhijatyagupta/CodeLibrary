import java.io.*;
import java.util.*;

class Solution{
    static int minThrow(int N, int arr[]){ // starting from i = 0, arr[i] is source, arr[i+1] is destination, if source < destination, then it's a ladder, else it's a snake
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length - 1; i = i + 2) map.put(arr[i], arr[i+1]); // making a hashMap from given array of snakes and ladders for fast access later

        return minThrows(1, map, 0); // call to actual shit
    }

    static int minThrows(int position, HashMap<Integer, Integer> snakesAndLadders, int timesThrown) {
        if (position >= 30) return timesThrown; // if this is the last block of board return the number of times dice was thrown

        int min = 31;   // will store minimum dice throws
        int lastSafe = -1;  // will store the last safe position on board before a ladder is climbed

        for(int i = 1; i <= 6; i++) { // for each possible throw of a dice from current block
            int currentPosition = position + i; // update current position according to the dice
            int temp = 0;   // will store minimum throws for the current iteration
            if(snakesAndLadders.containsKey(currentPosition) && snakesAndLadders.get(currentPosition) > currentPosition) { // if the current block has a ladder
                lastSafe = currentPosition; // mark this block as the last safe position
                temp = minThrows(snakesAndLadders.get(currentPosition), snakesAndLadders, timesThrown + 1); // climb the ladder and get minimum throws
                if (temp < min) min = temp; // if the calculated minimum is less than current minimum, update minimum
            }
            else if (!snakesAndLadders.containsKey(currentPosition)) {  // if the current block neither has a ladder nor a snake
                lastSafe = currentPosition; // mark this block as last safe position
            }
        }

        int temp = minThrows(lastSafe, snakesAndLadders, timesThrown + 1); // calculate throws from the last safe position, i.e. without climbing the ladder
        if (temp < min) min = temp; // if these calculated throws are less than current minimum throws, update minimum

        return min; // return minimum throws
    }
}


// Driver Code Starts
class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// Driver Code Ends
