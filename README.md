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

 

Configuration
API URL: The URL for the cricket match data API is hardcoded in the CricketStats class. Replace the placeholder URL with the actual API endpoint:

java
Copy code
String url = "[https://curvoa-api-url.com/data](https://api.cuvora.com/car/partner/cricket-data)";  
Code Structure
CricketStats.java: Main class that fetches data from the API, processes it, and outputs the results.
pom.xml: Maven configuration file that includes dependencies and project settings.
 
Copy code
Highest score in one innings: 175
Number of matches with a total score above 300: 4

Troubleshooting
NoClassDefFoundError: Ensure that all dependencies are included in your build path. Verify that your pom.xml is correctly configured and run mvn clean package to rebuild the project.
Invalid API Response: Check the format of the API response and ensure it matches the expected structure. Modify the parsing logic if needed.


Author ~ Juned Ali
