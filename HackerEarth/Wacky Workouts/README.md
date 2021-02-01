<div class="problem-description line-height-18 less-margin-2 darker content">
            <div id="fullscreen-problem-title" class="problem-title medium-margin weight-700 hidden"><h2>Wacky Workouts</h2></div>
            <div class="starwars-lab"><p>The government of virtualBit believes that the health of its citizens is the highest priority. It has devised an <strong>N</strong>-day health plan. During these <strong>N</strong> days, the citizens are encouraged to go to the gym for workouts. </p>
<p>A person may or may not go to the gym on any day. The people of virtualBit are a lazy lot, and they don't want to go to the gym for more than one consecutive day. Given the number of days <strong>N</strong>, print the number of ways the <strong>N</strong>-day plan can be completed. </p>
<p>Note that it is possible to not go to the gym on any day at all and still complete the plan.</p>
<strong>Input</strong>
<p>The first line contains <strong>T</strong>, the number of test cases.</p>
<p>Each test case contains a number <strong>N</strong> denoting the number of days.</p>
<strong>Output</strong>
<p>Each test case contains a single number denoting the number of ways by which the <strong>N</strong>-day plan may be completed.</p>
<p>Output your answer modulo 10<sup>9</sup>+7.</p>
<strong>Constraints</strong>
<p>1 &lt;= <strong>T</strong> &lt;= 60000</p>
<p>1 &lt;= <strong>N</strong> &lt;=  10<sup>18</sup></p></div>
            <div class="less-margin-2 input-output-container">
                <div class="input-output right-border">
                    <div class="form-label">
                        <div class="weight-600 less-margin-right light float-left small"><strong>Sample Input</strong></div>
                        <div class="input-output-opt float-right">
                            <a href="https://he-s3.s3.amazonaws.com/media/hackathon/programmers-parliament/problems/ec457adef8-sample-input-ec4436f.txt?Signature=3f3MkVqMwYS5uC2RbzM1MFenwD4%3D&amp;Expires=1612205776&amp;AWSAccessKeyId=AKIA6I2ISGOYH7WWS3G5" class="track-problem-sample-input tool-tip" target="_blank"><i class="fa fa-link"></i></a>
                            <a class="track-problem-sample-input-copy input-output-copy tool-tip"><i class="fa fa-files-o"></i></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="dark"><pre class="word-spacing-0">2
2
3</pre></div>
                </div>
                <div class="input-output">
                    <div class="form-label">
                        <div><strong>Sample Output</strong></div>
                        <div class="input-output-opt float-right">
                            <a href="https://he-s3.s3.amazonaws.com/media/hackathon/programmers-parliament/problems/e4cf1648f8-sample-output-e4ce67f.txt?Signature=VhAofgyNPUP6iUWubeP2wxgT3NI%3D&amp;Expires=1612205776&amp;AWSAccessKeyId=AKIA6I2ISGOYH7WWS3G5" class="track-problem-sample-output tool-tip" target="_blank"><i class="fa fa-link"></i></a>
                            <a class="track-problem-sample-output-copy input-output-copy tool-tip"><i class="fa fa-files-o"></i></a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="dark"><pre class="word-spacing-0">3
5</pre></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="standard-margin">
                <span class="weight-600 form-label"><strong>Explanation</strong></span>
                <div class="less-margin">
                    <p>In the first test case the plan can be completed by going only on the first day, only on the second day or on no day at all.</p>
<p>In the second test case, the plan can be completed by any of the following combinations.</p>
<p>{}, {1}, {2}, {3}, {1,3}</p>
                </div>
            </div>
            <div class="standard-margin light small problem-guidelines">
                    <div>
                        <span class="weight-700">Time Limit: </span>
                        <span>
                            2.0 sec(s)
                            <span>for each input file.</span>
                        </span>
                    </div> <!-- end limit-item -->
                    <div class="less-margin">
                        <span class="weight-700">Memory Limit: </span>
                        <span>256 MB </span>
                    </div> <!-- end limit-item -->
                    <div class="less-margin">
                        <span class="weight-700">Source Limit: </span>
                        <span>1024 KB </span>
                    </div> <!-- end limit-item -->
            </div> <!-- end limits -->
        </div>
