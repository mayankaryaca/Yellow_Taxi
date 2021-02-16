package com.example.yellowtaxi;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileModifier {
    private static final String FILE_NAME = "destination_details";
    private File file = null;
    private FileReader fileReader = null;
    private FileWriter fileWriter = null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    private String response = null;
    private Context context = null;

    //constructor to get context and retrive file
    public FileModifier(Context context) {
        this.context = context;
        file = new File(context.getFilesDir(), FILE_NAME);
    }

    //function to intialize if json doesn;t exist or read existing json file
    public String initializeReadJSON() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                fileWriter = new FileWriter(file.getAbsoluteFile());
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("{\n" +
                        "  \"destination1\": {\n" +
                        "    \"name\": \"Statue Of Liberty\",\n" +
                        "    \"address\": \"New York, NY 10004, United States\",\n" +
                        "    \"phone\": \"+1 212-363-3200\",\n" +
                        "    \"website\": \"https://www.nps.gov/stli/index.htm\",\n" +
                        "    \"pic_main\": \"destination1\",\n" +
                        "    \"extra_pics_1\": \"destination1_1\",\n" +
                        "    \"extra_pics_2\": \"destination1_2\",\n" +
                        "    \"extra_pics_3\": \"destination1_3\",\n" +
                        "    \"extra_pics_4\": \"destination1_4\",\n" +
                        "    \"description\": \"The Statue of Liberty Enlightening the World was a gift of friendship from the people of France to the United States and is recognized as a universal symbol of freedom and democracy. The Statue of Liberty was dedicated on October 28, 1886.  It was designated as a National Monument in 1924.  Employees of the National Park Service have been caring for the colossal copper statue since 1933.\",\n" +
                        "    \"price\": \"12\",\n" +
                        "    \"ratingUser1\": \"0\",\n" +
                        "    \"ratingUser2\": \"0\"\n" +
                        "  },\n" +
                        "  \"destination2\": {\n" +
                        "    \"name\": \"Central Park\",\n" +
                        "    \"address\": \"Manhattan, New York City, United States\",\n" +
                        "    \"phone\": \"+1 212-310-6600\",\n" +
                        "    \"website\": \"https://www.centralparknyc.org/\",\n" +
                        "    \"pic_main\": \"destination2\",\n" +
                        "    \"extra_pics_1\": \"destination2_1\",\n" +
                        "    \"extra_pics_2\": \"destination2_2\",\n" +
                        "    \"extra_pics_3\": \"destination2_3\",\n" +
                        "    \"extra_pics_4\": \"destination2_4\",\n" +
                        "    \"description\": \"Central Park, largest and most important public park in Manhattan, New York City. It occupies an area of 840 acres (340 hectares) and extends between 59th and 110th streets (about 2.5 miles [4 km]) and between Fifth and Eighth avenues (about 0.5 miles [0.8 km]). It was one of the first American parks to be developed using landscape architecture techniques.\",\n" +
                        "    \"price\": \"0\",\n" +
                        "    \"ratingUser1\": \"0\",\n" +
                        "    \"ratingUser2\": \"0\"\n" +
                        "  },\n" +
                        "  \"destination3\": {\n" +
                        "    \"name\": \"Rockefeller Center\",\n" +
                        "    \"address\": \"45, Rockefeller Plaza, New York, NY 10111, United States\",\n" +
                        "    \"phone\": \"+1 212-588-8601\",\n" +
                        "    \"website\": \"https://www.rockefellercenter.com/\",\n" +
                        "    \"pic_main\": \"destination3\",\n" +
                        "    \"extra_pics_1\": \"destination3_1\",\n" +
                        "    \"extra_pics_2\": \"destination3_2\",\n" +
                        "    \"extra_pics_3\": \"destination3_3\",\n" +
                        "    \"extra_pics_4\": \"destination3_4\",\n" +
                        "    \"description\": \"Located in the heart of Midtown, Rockefeller Center is an Art Deco complex composed of 19 grand buildings. It's home to a network of businesses, television studios, shopping and dining choices as well as stunning artwork and architecture.\",\n" +
                        "    \"price\": \"25\",\n" +
                        "    \"ratingUser1\": \"0\",\n" +
                        "    \"ratingUser2\": \"0\"\n" +
                        "  },\n" +
                        "  \"destination4\": {\n" +
                        "    \"name\": \"The Metropolitian Museum of Art\",\n" +
                        "    \"address\": \"1000, 5th Ave, New York, NY 10028, United States\",\n" +
                        "    \"phone\": \"+1 212-535-7710\",\n" +
                        "    \"website\": \"https://www.metmuseum.org/\",\n" +
                        "    \"pic_main\": \"destination4\",\n" +
                        "    \"extra_pics_1\": \"destination4_1\",\n" +
                        "    \"extra_pics_2\": \"destination4_2\",\n" +
                        "    \"extra_pics_3\": \"destination4_3\",\n" +
                        "    \"extra_pics_4\": \"destination4_4\",\n" +
                        "    \"description\": \"The Metropolitan Museum of Art collects, studies, conserves, and presents significant works of art across all times and cultures in order to connect people to creativity, knowledge, and ideas.\",\n" +
                        "    \"price\": \"12\",\n" +
                        "    \"ratingUser1\": \"0\",\n" +
                        "    \"ratingUser2\": \"0\"\n" +
                        "  },\n" +
                        "  \"destination5\": {\n" +
                        "    \"name\": \"Times Square\",\n" +
                        "    \"address\": \"Manhattan, NY 10036, United States\",\n" +
                        "    \"phone\": \"0\",\n" +
                        "    \"website\": \"https://www.timessquarenyc.org/\",\n" +
                        "    \"pic_main\": \"destination5\",\n" +
                        "    \"extra_pics_1\": \"destination5_1\",\n" +
                        "    \"extra_pics_2\": \"destination5_2\",\n" +
                        "    \"extra_pics_3\": \"destination5_3\",\n" +
                        "    \"extra_pics_4\": \"destination5_4\",\n" +
                        "    \"description\": \"Times Square is a major commercial intersection, tourist destination, entertainment center, and neighborhood in the Midtown Manhattan section of New York City, at the junction of Broadway and Seventh Avenue. Brightly lit by numerous billboards and advertisements, it stretches from West 42nd to West 47th Streets, and is sometimes referred to as the Crossroads of the World, the Center of the Universe, the heart of the Great White Way and the heart of the world\",\n" +
                        "    \"price\": \"0\",\n" +
                        "    \"ratingUser1\": \"0\",\n" +
                        "    \"ratingUser2\": \"0\"\n" +
                        "  }\n" +
                        "}");
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("TAG", "File exists");
        }

        //travesing data into string format and storing it into string response
        try {
            StringBuffer output = new StringBuffer();
            fileReader = new FileReader(file.getAbsolutePath());
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                output.append(line + "\n");
            }
            response = output.toString();
            bufferedReader.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return response;
    }


    //saving user selected rating value into jsonobject
    public void appendRatingJSON(String destinationKey, float ratingValue, String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            Boolean isUserExisting = jsonObject.has(destinationKey);
            YtSharedPreferences ytSharedPreferences = new YtSharedPreferences(context);
            String userId = ytSharedPreferences.getUserId();
            if (!isUserExisting) {
                Log.d("TAG", "value exists");
            } else {
                JSONObject userObject = jsonObject.getJSONObject(destinationKey);
                userObject.put(("rating"+userId), ratingValue);

            }
            fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(jsonObject.toString());
            bw.close();
        } catch (JSONException | IOException j) {
            j.printStackTrace();
        }
    }
}