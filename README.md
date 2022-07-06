# ElevateAssessment
Service to build a Security Incident API
Problem - https://gist.github.com/vishalbollu/1bb2994f376783389eb8dfade900447b

## Instructions on how to run
- Make sure maven is installed
- mvn install / mvn clean install
- java -jar target/incidents-0.0.1-SNAPSHOT.jar

## Paragraph with overall approach and other approaches you considered
There are 7 different APIs that are returning incident related data.

### Basic approach
- First step is to get data from those APIs and accumulate them in a same list
- Have a different map for IP address : Employee id mapping
- Group the list by employee id
- Format the data in the required format using models

### Step by step approach
- Create a Springboot project
- Define Controllers/service/models/helpers packages
- There is just 1 endpoint of the API GET /incidents (base url - /api/elevate)
- Call the service layer and get data from different APIs (elevate APIs including the identities API) and merge them in a single list. Please see the format (Each API has a different model associated to it)
- Once we have the cumulative data in a common model (Incidents.java in our case), group by employee id.
- Make different models for low, medium, high and critical incidents and group them further by iterating over the above list.
- Another model corresponding to the 'user' that will have data of low, medium, high and critical incidents.
- We use TreeMap instead of Map to return the final data because it stores data sorted by the key.

### Approaches considered
- Could be done in Python using a Flask service. Data manipulation could have been done better in Python since it offers support that Java doesn't

## Paragraph on how you would enhance this code if you needed it to run in production
- Define username, password, and urls in the application.properties file or get it from ENV variables instead of hardcoding it in the code
- Structure could be better
- Code cleanliness could be improved since the methods currently are quite lengthy
- Could provide comments for different methods
- Should provide null checks for data cleanliness. This code works because data is clean and no data anamoly exists. However, that wont be the case in production.
