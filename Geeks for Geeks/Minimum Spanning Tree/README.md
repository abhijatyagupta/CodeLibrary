# [Minimum Spanning Tree](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)

<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the&nbsp;Minimum Spanning Tree.</span></p>
<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<img alt="" src="images/1.png" class="img-responsive">
<span style="font-size:18px"><strong>Output:</strong>
4
<strong>Explanation</strong>:</span>
<img alt="" src="images/2.png" style="height:207px; width:288px" class="img-responsive">
<span style="font-size:18px">The Spanning Tree resulting in a weight
of 4 is shown above.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<img alt="" src="images/3.png" class="img-responsive">
<span style="font-size:18px"><strong>Output:</strong>
5
<strong>Explanation</strong>:
Only one Spanning Tree is possible
which has a weight of 5.</span>
</pre>
<p><span style="font-size:18px"><strong>Your task:</strong><br>
Since this is a functional problem you don't have to worry about input, you just have to complete the function&nbsp; <strong>spanningTree()</strong> which takes number of vertices V<strong> </strong>and<strong>&nbsp;</strong>an adjacency matrix adj as input parameters&nbsp;and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the distance between edge i and j is w.</span>
<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(ElogV).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(V<sup>2</sup>).</span><br>
<p><span style="font-size:18px"><strong>Constraints:</strong><br>
2 </span> <span style="font-size:18px">≤</span> <span style="font-size:18px"> V</span> <span style="font-size:18px">≤</span> <span style="font-size:18px"> 1000<br>
V-1 </span><span style="font-size:18px">≤</span> <span style="font-size:18px"> E </span> <span style="font-size:18px">≤</span> <span style="font-size:18px"> (V*(V-1))/2<br>
1 </span> <span style="font-size:18px">≤</span> <span style="font-size:18px"> w </span> <span style="font-size:18px">≤</span> <span style="font-size:18px"> 1000<br>
Graph is connected and&nbsp;doesn't contain self loops &amp;&nbsp;multiple edges.</span></p>
 <p></p>
 </div>
