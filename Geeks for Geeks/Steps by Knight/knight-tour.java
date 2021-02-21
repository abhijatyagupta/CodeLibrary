import java.io.*;
import java.util.*;

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        int[][] dp = new int[N][N]; // will store minimum distance from knight to a cell
        for(int[] x : dp) {
            Arrays.fill(x, Integer.MAX_VALUE);  // initially, the distance is maximum
        }

        Queue<Cell> queue = new LinkedList<>(); // queue for BFS

        Cell knight = new Cell(knightPos[0], knightPos[1], 0);  // cell for knight's position
        queue.offer(knight);    // pushing knight's cell to queue
        dp[knightPos[0]][knightPos[1]] = 0; // the distance from knight to itself is 0

        int[] iMoves = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};  // possible combinations required for knight to move horizontally
        int[] jMoves = new int[] {-1, 1, -2, 2, 2, -2, 1, -1};  // possible combinations required for knight to move vertically

        while(!queue.isEmpty()) {   // the BFS loop
            Cell currentCell = queue.poll();    //dequeue the cell

            if(currentCell.i == targetPos[0] && currentCell.j == targetPos[1]) {    // if this is the target cell
                return currentCell.distance;    // return its distance from knight
            }

            for(int i = 0; i < 8; i++) {    // loop to add other possible cells to the queue where knight may move
                int x = currentCell.i + iMoves[i];
                int y = currentCell.j + jMoves[i];
                int distance = currentCell.distance + 1;

                if (areOutside(x, y, N)) continue; // don't add the cell to queue of coordinates are out of bounds of the board
                if (dp[x][y] <= distance) continue; // don't add the cell to queue if knight already reached this position in less distance

                queue.offer(new Cell(x, y, distance));  // add the new cell to queue
                dp[x][y] = distance;    // store the distance to the cell
            }
        }
        return Integer.MAX_VALUE;
    }

    boolean areOutside(int row, int col, int n) {
        return row < 0 || row >= n || col < 0 || col >= n;  // returns whether coordinates are out of bounds of the board or not
    }
}

class Cell {    // custom Cell class that will store its coordinates and distance from knight
    int i;
    int j;
    int distance;

    Cell(int i, int j, int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }

}


// Driver Code Starts
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i])-1;
                TargetPos[i] = Integer.parseInt(S2[i])-1;
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
        }
    }
}
//Driver Code Ends

