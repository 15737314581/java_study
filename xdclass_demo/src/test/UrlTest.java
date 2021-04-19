package test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.xdclass.net/pub/api/v1/study_line/list?size=8");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        int responseCode = urlConnection.getResponseCode();
        if (200 <= responseCode && responseCode <= 299) {
            try (InputStream is = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is));
            ) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                String json_str = response.toString();
//                System.out.println(response.toString());
                Gson gson = new Gson();
                Map<String,Object> map = gson.fromJson(json_str, Map.class);
                Double code = Double.parseDouble(String.valueOf(map.get("code")));

                System.out.println(code.intValue());


            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
