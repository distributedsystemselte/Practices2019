package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.HttpURLConnection;
import models.Person;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import utils.JsonExample;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.awt.List;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.TimeSent;
import models.DaysSpent;
import java.io.FileWriter;
import java.io.BufferedWriter;
import org.json.JSONException;
import org.json.JSONObject;

public class Sample {

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
    // InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  public static void compareCurrentTimes() {
    try {
      JSONObject time = readJsonFromUrl("http://worldtimeapi.org/api/ip");
      String currentTime = time.getString("utc_datetime");
      System.out.println("Getting a time from worldtime: " + currentTime);
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println(format.parse(currentTime));
      Date currentDate = format.parse(currentTime);
      Date currentDateNow = new Date();
      System.out.println("Current time from java: " + currentDateNow);
      System.out.println("Comparison: " + currentDate.compareTo(currentDateNow));
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
