# [Allocate minimum number of pages](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1)

<div class="problem-statement">
<p></p><p><span style="font-size:18px">You are given <strong>N</strong> number of books. Every i<sup>th</sup> book has<strong> A<sub>i</sub> </strong>number of pages.
You have to allocate books to <strong>M</strong> number of students. There can be many ways or permutations to do so. In each permutation, one of the <strong>M</strong> students will be allocated&nbsp;the maximum number of pages. Out of all these permutations, the task is to find that particular&nbsp;permutation&nbsp;in which the maximum number of pages allocated to a student is minimum of those in all the other permutations and print this minimum value.&nbsp;</span></p>

<p><span style="font-size:18px">Each&nbsp;book will be allocated to exactly one student. Each student has to be allocated at least one book.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Return <strong>-1</strong> if a valid assignment is not possible, and <strong>allotment should be in contiguous order (see the explanation for better understanding).</strong></span></p>

<p>
<strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">N = 4
A[] = {12,34,67,90}
M = 2
<strong>Output:
</strong>113<strong>
Explanation: </strong>
Allocation can be done in following ways:</span>
<span style="font-size:18px">{12} and {34, 67, 90}&nbsp;Maximum Pages = 191</span>
<span style="font-size:18px">{12, 34} and {67, 90}&nbsp;Maximum Pages = 157</span>
<span style="font-size:18px">{12, 34, 67} and {90}&nbsp;&nbsp;Maximum Pages =113
Therefore, the minimum of these cases is 
113, which is selected as the output.</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">N = 3
A[] = {15,17,20}
M = 2
<strong>Output:
</strong>32<strong>
Explanation:
</strong>Allocation is done as 
{15,17} and {20}</span>
</pre>

<p>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>findPages()</strong> which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.</span></p>
<p>
<span style="font-size:18px"><strong>Expected Time Complexity</strong>: O(NlogN)<br>
<strong>Expected Auxilliary Space</strong>: O(1)</span></p>
<p>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>5</sup><br>
1 &lt;= A [ i ]&nbsp;&lt;= 10<sup>6</sup><br>
1 &lt;= M&nbsp;&lt;= 10<sup>5</sup></span></p>
 <p></p>
            </div>
