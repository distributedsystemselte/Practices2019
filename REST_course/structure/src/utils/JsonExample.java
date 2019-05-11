package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.HttpURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonExample {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String surl) throws IOException, JSONException {

    URL url = new URL(surl);
    HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

    InputStream is = httpcon.getInputStream();
    //InputStream is = new URL(url).openStream();

    try {
      System.out.println("ahhhhhhhhhh");
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void test(){
    try {
      JSONObject json = readJsonFromUrl("https://pokeapi.co/api/v2/berry/");
      System.out.println(json.toString());
      System.out.println(json.get("next"));
    }catch(Exception e){

      System.out.println(e);
    }
}






}
