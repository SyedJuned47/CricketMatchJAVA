package cricketmatches;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class CricketMatch {
    public static void main(String[] args) {
        try {
             
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://api.cuvora.com/car/partner/cricket-data");
            request.setHeader("apiKey", "test-creds@2320");

             
            HttpResponse response = httpClient.execute(request);
            String jsonString = EntityUtils.toString(response.getEntity());

             
            System.out.println("Raw JSON Response: " + jsonString);

           
            JSONObject jsonResponse = new JSONObject(jsonString);
            JSONArray matches = jsonResponse.getJSONArray("data");
            int highestScore = 0;
            String highestScoringTeam = "";
            int matchesWith300Plus = 0;

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                String t1ScoreStr = match.getString("t1s");
                int score1 = extractScore(t1ScoreStr);
                System.out.println("Team 1 Score: " + score1);
                
                 
                String t2ScoreStr = match.getString("t2s");
                int score2 = extractScore(t2ScoreStr);
                System.out.println("Team 2 Score: " + score2);

                 
                if (score1 > highestScore) {
                    highestScore = score1;
                    highestScoringTeam = match.getString("t1");
                }
                if (score2 > highestScore) {
                    highestScore = score2;
                    highestScoringTeam = match.getString("t2");
                }

                 
                if (score1 + score2 > 300) {
                    matchesWith300Plus++;
                }
            }

            
            System.out.println("Highest Score: " + highestScore + " and Team Name is: " + highestScoringTeam);
            System.out.println("Number Of Matches with total 300 Plus Score: " + matchesWith300Plus);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int extractScore(String scoreStr) {
        
        String[] parts = scoreStr.split("/");  
        if (parts.length > 0) {
            try {
                return Integer.parseInt(parts[0].trim());
            } catch (NumberFormatException e) {
                System.out.println("Error parsing score: " + scoreStr);
            }
        }
        return 0;
    }

}
