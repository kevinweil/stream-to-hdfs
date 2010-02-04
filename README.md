== A simple utility to stream stdin to a file in HDFS ==

In a unix shell, you can stream the contents of a file to stdout with "cat my_file" and you can stream the contents
of stdin to a file with a redirect: "some_command > my_file".  

With Hadoop you can say "hadoop dfs -cat my_file" to stream the contents of a file in HDFS to stdout, but there's
no built-in utility to redirect the contents of stdin to a file in HDFS.  This library provides that.  To get started, 
simply:

1. Download, and run ant
2. Upload build/hstream-1.0.jar and bin/hstream to the machine you use Hadoop from.
3. Modify the paths to the hadoop script and to the hstream jar in the hstream script you just uploaded.
4. Put the hstream script in your $PATH.
5. Run!  For example, try running

<pre><code>
    echo "This is streaming into HDFS from the command line" | hstream test.txt
</code></pre>

Now running "hadoop dfs -cat test.txt" should print out "This is streaming into HDFS from the command line".


