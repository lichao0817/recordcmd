# Record Project
## Technology Stack

<li>Java 1.8</li>
<li>Spring Boot</li>
<li>Maven</li>
<li>Thymeleaf</li>

## Prerequisites to run the application

You must have the following to run the application:
<li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html">JRE 8</a></li>

(Make sure you have them installed on your computer before you run the application)

## Run the application

Start the application
<ol>
<li>Open your terminal or cmd</li>
<li>Choose any path you like to clone the project</li>
<li>Check out the project on github: <code>git clone https://github.com/lichao0817/record.git</code></li>
<li>Change your working directory to the root of the project: <code>cd record</code></li>
<li>To start up the application: <code>java -jar target/record-1.0.0.jar</code></li>
<li>You should be able to see the message like this: <b>"Started Application in 12.957 seconds (JVM running for 13.446)"</b></li>
<li>Now the app is up and running! You can test the api now!</li>
</ol>

Notice: make sure you have Java 1.8 and Maven installed correctly and port 8080 on your local machine is available.

## Test the application
Test POST record
<ol>
<li>Open up the web browser</li>
<li>Type <code>localhost:8080/records</code> in the address bar</li>
<li>In the input box add a record in any of the three format: <code>White | Snow | F | White | 01/01/1900</code>, <code>Cartman, Eric, M, Blue, 08/01/1997</code> or <code>Kent Clark M Blue 02/29/1938</code></li>
</ol>

Test GET records sorted by gender:
<ol>
<li>Open up the web browser</li>
<li>Type <code>localhost:8080/records/gender</code> in the address bar</li>
<li>You should be able see the prepopulated records sorted by gender in JSON</li>
</ol>

Test GET records sorted by date of birth:
<ol>
<li>Open up the web browser</li>
<li>Type <code>localhost:8080/records/birthdate</code> in the address bar</li>
</ol>

Test GET records sorted by last name in descending order:
<ol>
<li>Open up the web browser</li>
<li>Type <code>localhost:8080/records/name</code> in the address bar</li>
</ol>

## Test coverage

|Package|Class, %|Method, %|Line, %|
|-------|--------|---------|-------|
|dao    |100     |100      |100    |
|model  |100     |100      |100    |
|util   |100     |95.5     |90.1   |

More details are in <code>record/coverage</code>
