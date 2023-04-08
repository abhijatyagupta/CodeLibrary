import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // list that will hold all the possible permutations
        for(int i = 0; i < n; i++) {    // traverse for each cell of the first row
            boolean[][] canPlaceQueen = new boolean[][] {
                new boolean[n], // will tell whether a column is occupied by a queen. (Such an array is not required for rows since the board will be traversed row by row and it will be obvious that no queen already exist in the current row that is being traversed)
                new boolean[2*n],   // will tell whether top-left diagonal is occupied
                new boolean[2*n]    // will tell whether top-right diagonal is occupied
            };
            ArrayList<Integer> permutation = new ArrayList<>(); // will hold a particular permutation
            nQueenHelper(n, canPlaceQueen, list, permutation, 0, i); // call to actual shit
        }
        return list;
    }

    static void nQueenHelper(int boardLength, boolean[][] canPlaceQueen, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> permutation, int row, int col) {
        if (canPlaceQueen[0][col] || canPlaceQueen[1][(boardLength - 1) + col-row] || canPlaceQueen[2][col+row]) return;   // return if another queen can attack this cell
        permutation.add(col+1); // add current cell to the permutation (+1 because solution required one-based indexing)
        canPlaceQueen[0][col] = canPlaceQueen[1][(boardLength - 1) + col-row] = canPlaceQueen[2][col+row] = true; // mark the column and diagonals as occupied
        
        for(int i = 0; i < boardLength && ((row+1) < boardLength); i++) { // find all possible safe permutations for the next queen in the next row
            nQueenHelper(boardLength, canPlaceQueen, list, permutation, row+1, i);
        }
        
        if (permutation.size() == boardLength) {   // if this is the final row/queen of the permutation
            list.add(new ArrayList<>(permutation)); // add the permutation to the list
        }
        
        permutation.remove(permutation.size() - 1); // backtrack to find other possible permutations
        canPlaceQueen[0][col] = canPlaceQueen[1][(boardLength - 1) + col-row] = canPlaceQueen[2][col+row] = false;
    }
}

// Driver Code Starts
class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// Driver Code Ends
