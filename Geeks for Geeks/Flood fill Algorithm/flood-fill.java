import java.util.*;
import java.io.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fillColor(image, sr, sc, newColor, image[sr][sc]);  // call to actual shit
        return image;   // return the modified image
    }

    void fillColor(int[][] image, int i, int j, int newColor, int colorToReplace) {
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length) return; // return if coordinates are out of bounds of the image

        if(image[i][j] == newColor || image[i][j] != colorToReplace) return;    // return if the current pixel either already has the new color or if it is not the color that needs to be replaced
        image[i][j] = newColor; // change the color of pixel

        fillColor(image, i, j-1, newColor, colorToReplace); // recursive calls to color adjacent pixels
        fillColor(image, i, j+1, newColor, colorToReplace);
        fillColor(image, i-1, j, newColor, colorToReplace);
        fillColor(image, i+1, j, newColor, colorToReplace);
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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}
// Driver Code Ends