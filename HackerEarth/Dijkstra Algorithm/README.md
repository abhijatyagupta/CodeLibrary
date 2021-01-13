<div id="DIV_1">
	<div id="DIV_2">
		Dijkstra's Algorithm
	</div>
	<div id="DIV_3">
    <a href="https://www.hackerearth.com/problem/algorithm/dijkstra-1-52a4305d"><h2>Dijkstra Algorithm</h2></a>
		<p id="P_5">
			You will be given an adjacency matrix of an undirected graph and some q queries.
		</p>
		<p id="P_6">
			Each query contains two integers(0-indexed) denoting the source and destination vertices.
		</p>
		<p id="P_7">
			For every query you need to print the shortest path between the given two vertices.
		</p>
		<p id="P_8">
			<strong id="STRONG_9">Input:</strong>
		</p>
		<p id="P_10">
			First line contains integer <strong id="STRONG_11">n</strong> denoting the number of vertices in the graph.
		</p>
		<p id="P_12">
			Next <strong id="STRONG_13">n</strong> lines contains <strong id="STRONG_14">n</strong> integers denoting <strong id="STRONG_15">n</strong>x<strong id="STRONG_16">n</strong> adjacency matrix <strong id="STRONG_17">a</strong>,the value a[ i ] [ j ] denotes the distance between ith and jth vertex.
		</p>
		<p id="P_18">
			Next line contains integer <strong id="STRONG_19">q</strong> denoting number of queries.
		</p>
		<p id="P_20">
			Next <strong id="STRONG_21">q</strong> lines contains two integers denoting source and destination vertices
		</p>
		<p id="P_22">
			<strong id="STRONG_23">Output:</strong>
		</p>
		<p id="P_24">
			Output the <strong id="STRONG_25">q</strong> lines denoting the shortest path between two vertices given in each respective query.
		</p>
		<p id="P_26">
			<strong id="STRONG_27">Constraints:</strong>
		</p>
		<p id="P_28">
			1 &lt;= <strong id="STRONG_29">n</strong> &lt;= 9
		</p>
		<p id="P_30">
			1 &lt;= <strong id="STRONG_31">q</strong> &lt;= <strong id="STRONG_32">n</strong>
		</p>
		<p id="P_33">
			1&lt;= <strong id="STRONG_34">a[i][j]</strong> &lt;= 100000.
		</p>
	</div>
	<div id="DIV_35">
		<div id="DIV_36">
			<div id="DIV_37">
				<div id="DIV_38">
					SAMPLE INPUT
				</div>
				<div id="DIV_44">
				</div>
			</div>
			<div id="DIV_45">
				<pre id="PRE_46">5
0 5 10 2 0
5 0 3 7 2
10 3 0 0 0
2 7 0 0 3
0 2 0 3 0
3
0 4
2 3
1 3
				</pre>
			</div>
		</div>
		<div id="DIV_47">
				<div id="DIV_48">
					<div id="DIV_49">
						SAMPLE OUTPUT
					</div>
					<div id="DIV_55">
					</div>
				</div>
				<div id="DIV_56">
					<pre id="PRE_57">5
8
5
					</pre>
				</div>
			</div>
		<div id="DIV_58">
				</div>
	</div>
	<div id="DIV_59">
				<div id="DIV_60">
					 <span id="SPAN_61">Time Limit:</span> <span id="SPAN_62">5.0 sec(s) <span id="SPAN_63">for each input file.</span></span>
				</div>
				<!-- end limit-item -->
				<div id="DIV_64">
					 <span id="SPAN_65">Memory Limit:</span> <span id="SPAN_66">256 MB</span>
				</div>
				<!-- end limit-item -->
				<div id="DIV_67">
					 <span id="SPAN_68">Source Limit:</span> <span id="SPAN_69">1024 KB</span>
				</div>
				<!-- end limit-item -->
			</div>
	<!-- end limits -->
</div>
