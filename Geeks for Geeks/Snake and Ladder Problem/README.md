# [Snake and Ladder Problem](https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1)

<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a 5x6&nbsp;snakes and ladders board, find the minimum number of dice throws required to reach the destination or last cell (30th cell) from the source (1st cell). You are given <strong>N </strong>ie - the&nbsp;total number of snakes and ladders&nbsp;and an array <strong>arr</strong>&nbsp;of <strong>2*N</strong> size where <strong>2*i</strong> and <strong>(2*i+1)</strong>th values denotes the starting and ending point respecitvely of ith&nbsp;snake or ladder. The&nbsp;board looks like the following.<br>
<br>
<img alt="" src="https://contribute.geeksforgeeks.org/wp-content/uploads/snake-and-ladders.jpg" width="400" class="img-responsive"></span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<strong>Input:</strong>
<pre>
N = 8
arr = {3, 22, 5, 8, 11, 26, 20, 29, 
&nbsp;      17, 4, 19, 7, 27, 1, 21, 9}
</pre>
<strong>Output:</strong>
<pre>
3
</pre>
<strong>Explaination:</strong>
The given board is the board shown
in the figure. For the above board 
output will be 3. For 1st throw get a 2. For 
2nd throw get a 6. For 3rd throw get a 2.

<p>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You do not need to read input or print anything. Your task is to complete the function <strong>minThrow()</strong> which takes <strong>N</strong> and <strong>arr</strong> as input parameters and returns the minimum number of throws required to reach the end of the game.</span></p>

<p>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<br>
1 ≤ arr[i] ≤ 30&nbsp;&nbsp;</span></p>
 <p></p>
</div>
