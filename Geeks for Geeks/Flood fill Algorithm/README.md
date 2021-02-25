# [Flood fill Algorithm](https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1)

<div class="problem-statement">
<p></p><p><span style="font-size:18px">Given an&nbsp;image of size n*m, location of a pixel in the screen i,e(sr, cc) 
and color newColor, your task is to replace color of the given pixel and all adjacent(excluding&nbsp;diagonally adjacent) same colored 
pixels with the given color newColor.</span>
</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<span style="font-size:18px"><strong>Input:</strong>
<pre>
image = {{1,1,1},
         {1,1,0},
         {1,0,1}},
sr = 1, sc = 1, newColor = 2.
</pre>
<strong>Output:</strong>
<pre>
{{2,2,2},
 {2,2,0},
 {2,0,1}}
</pre>

<strong>Explanation: </strong></span><span style="font-size:18px">From the center of the image 
(with position (sr, sc) = (1, 1)), all 
pixels connected by a path of the same color
as the starting pixel are colored with the new 
color.Note the bottom corner is not colored 2, 
because it is not 4-directionally connected to 
the starting pixel.</span>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or print anyhting. Your task is to complete the function&nbsp;<strong>floodFill()&nbsp;</strong>which takes image, sr, sc and 
newColor as input paramater and returns the image after flood filling.</span>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Compelxity:&nbsp;</strong>O(n*m)<br>
<strong>Expected Space Complexity:&nbsp;</strong>O(n*m)</span>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= m &lt;= 100<br>
0 &lt;= pixel values &lt;= 10</span></p>
 <p></p>
 </div>
