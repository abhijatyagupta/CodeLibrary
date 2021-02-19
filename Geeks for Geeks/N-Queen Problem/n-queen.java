import java.io.*;
import java.util.*;
import java.lang.*;

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // list that will hold all the possible permutations
        for(int i = 0; i < n; i++) {    // traverse for each cell of the first row
            boolean[][] board = new boolean[n][n];  // the chess board
            boolean[] isColumnOccupied = new boolean[n];    // will tell whether a column is occupied by a queen. (Such an array is not required for rows since the board will be traversed row by row and it will be obvious that no queen already exist on the current row that is being traversed)
            ArrayList<Integer> permutation = new ArrayList<>(); // will hold a particular permutation
            nQueenHelper(board, isColumnOccupied, list, permutation, 0, i); // call to actual shit
        }
        return list;
    }

    static void nQueenHelper(boolean[][] board, boolean[]isColumnOccupied, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> permutation, int row, int col) {
        if (isColumnOccupied[col] || isDiagonalOccupied(board, row, col)) return;   // return if another queen can attack this cell
        permutation.add(col+1); // add current cell to the permutation (+1 because solution required one-based indexing)
        board[row][col] = true; // mark position on board as occupied
        isColumnOccupied[col] = true; // mark the column as occupied

        for(int i = 0; i < board.length && ((row+1) < board.length); i++) { // find all possible safe permutations for the next queen in the next row
            nQueenHelper(board, isColumnOccupied, list, permutation, row+1, i);
        }

        if (permutation.size() == board.length) {   // if this is the final row/queen of the permutation
            list.add(new ArrayList<>(permutation)); // add the permutation to the list
        }

        permutation.remove(permutation.size() - 1); // backtrack to find other possible permutations
        board[row][col] = false;
        isColumnOccupied[col] = false;
    }

    static boolean isDiagonalOccupied(boolean[][] board, int row, int col) {
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) { // check queen's existence in the diagonal towards top-left
            if (board[i][j]) return true;
        }
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) { // check queen's existence in the diagonal towards top-right
            if (board[i][j]) return true;
        }
        return false;   // since the board is traversed from top to bottom, looking for queens in the bottom diagonals is not required
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
