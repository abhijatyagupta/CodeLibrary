# [Evaluate Expression To True](https://www.interviewbit.com/problems/evaluate-expression-to-true/)
### Medium
Asked in: [Amazon](https://www.interviewbit.com/search/?q=Amazon)

<div class="p-html-content__container"><p>
Given an expression, <strong>A</strong>, with operands and operators <strong>(OR , AND , XOR)</strong>, in how many ways can you evaluate the expression to true, by grouping in different ways?</p>
<p>Operands are only <strong>true</strong> and <strong>false</strong>.</p>
<p>Return the number of ways to evaluate the expression modulo <strong>10<sup>3</sup> + 3</strong>.</p>
<p><strong>Input Format:</strong></p>
<div class="highlighter-rouge"><pre class="highlight"><code>The first and the only argument of input will contain a string, A.

The string A, may contain these characters:
    '|' will represent or operator 
    '&amp;' will represent and operator
    '^' will represent xor operator
    'T' will represent true operand
    'F' will false
</code></pre>
</div>

<p><strong>Output:</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Return an integer, representing the number of ways to evaluate the string.
</code></pre>
</div>

<p><strong>Constraints:</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>1 &lt;= length(A) &lt;= 150
</code></pre>
</div>

<p><strong>Example:</strong></p>

<div class="highlighter-rouge"><pre class="highlight"><code>Input 1:
    A = "T|F"

Output 1:
    1

Explanation 1:
    The only way to evaluate the expression is:
        =&gt; (T|F) = T 

Input 2:
    A = "T^T^F"
    
Output 2:
    0
    
Explanation 2:
    There is no way to evaluate A to a true statement.
</code></pre>
</div>
</div>
