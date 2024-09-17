Cricket Stats Processor
Overview
This Java project retrieves cricket match data from an API, processes the data to compute specific statistics, and prints the results. The statistics include:

The highest score in one innings across all matches.
The number of matches where the combined total score of both teams is above 300.
Dependencies
This project requires the following dependencies:

org.json for JSON parsing.
org.apache.httpcomponents for making HTTP requests.
Add these dependencies to your pom.xml if you're using Maven:

xml
Copy code
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
</dependency>
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.13</version>
</dependency>
Getting Started
Clone the Repository
Clone this repository to your local machine:

sh
Copy code
git clone https://github.com/your-username/cricket-stats-processor.git
Build and Run
Navigate to the project directory:

sh
Copy code
cd cricket-stats-processor
Build the project using Maven:

sh
Copy code
mvn clean package
Run the application:

sh
Copy code
java -cp target/cricket-stats-processor-1.0-SNAPSHOT.jar com.example.CricketStats
Replace com.example.CricketStats with the actual fully qualified class name if different.

Configuration
API URL: The URL for the cricket match data API is hardcoded in the CricketStats class. Replace the placeholder URL with the actual API endpoint:

java
Copy code
String url = "https://curvoa-api-url.com/data";  // Replace with the actual URL
Code Structure
CricketStats.java: Main class that fetches data from the API, processes it, and outputs the results.
pom.xml: Maven configuration file that includes dependencies and project settings.
Example Output
sql
Copy code
Highest score in one innings: 175
Number of matches with a total score above 300: 4
Troubleshooting
NoClassDefFoundError: Ensure that all dependencies are included in your build path. Verify that your pom.xml is correctly configured and run mvn clean package to rebuild the project.
Invalid API Response: Check the format of the API response and ensure it matches the expected structure. Modify the parsing logic if needed.


Author ~ Juned Ali
