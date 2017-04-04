# Record Command Line Project
## Technology Stack

<li>Java 1.8</li>
<li>Maven</li>
<li>JCommander</li>

## Prerequisites to run the application

You must have the following to run the application:
<li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html">JRE 8</a></li>

(Make sure you have them installed on your computer before you run the application)

## Get the application

Download the application
<ol>
<li>Open your terminal or cmd</li>
<li>Choose any path you like to clone the project</li>
<li>Check out the project on github: <code>git clone https://github.com/lichao0817/recordcmd.git</code></li>
<li>Change your working directory to the root of the project: <code>cd recordcmd</code></li>
<li>Leave the terminal open</li>
</ol>

## Test the application

Usage: <pre><code>java -jar target/recordcmd-1.0.1.jar
 -i,--input               the path of the record file to sort
 -o,--order               the preferred order to sort the file: g - gender, n - last name, b - date of birth
 </code></pre>

Test sorting records by gender:
<ul>
<li>Example Usage: <code>java -jar target/recordcmd-1.0.1.jar -i comma-delimited.txt -o g</code></li>
</ul>

Test sorting records by last name:
<ul>
<li>Example Usage: <code>java -jar target/recordcmd-1.0.1.jar -i space-delimited.txt -o n</code></li>
</ul>

Test sorting records by date of birth:
<ul>
<li>Example Usage: <code>java -jar target/recordcmd-1.0.1.jar -i pipe-delimited.txt -o b</code></li>
</ul>

## Test coverage

|Package|Class, %|Method, %|Line, %|
|-------|--------|---------|-------|
|model  |100     |93       |92     |
|util   |100     |100      |90     |

More details are in <code>record/coverage</code>
