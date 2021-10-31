/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tudien;

/**
 *
 * @author Dell 2419h
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class translate {
    public static String translate(String langFrom, String langTo, String text) throws IOException, Exception {
        // INSERT YOU URL HERE
        String urlStr =  "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&"+
                "sl=" + langFrom + 
                "&tl=" + langTo + 
                "&dt=t&q=" + URLEncoder.encode(text, "UTF-8"); 
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
       
        return parseResult(response.toString());
    }
     private static String parseResult(String inputJson) throws Exception
 {
  JSONArray jsonArray = new JSONArray(inputJson);
  JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
  JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);
  
  return jsonArray3.get(0).toString();
 }
}
