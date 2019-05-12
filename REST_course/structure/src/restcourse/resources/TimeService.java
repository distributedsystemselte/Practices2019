package restcourse.resources;
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
@Path("/timeservice")
public class TimeService {
  @GET
  @Produces({ MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
  public String getTime() {
    System.out.println("getting the time!");
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    return sdf.format(cal.getTime());
  }
  @PUT
  @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  @Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON })
  public DaysSpent daysSpent(TimeSent timestamp) throws IOException,ParseException {
    System.out.println("Time sent has been provoked: " + timestamp.getUtcDatetime());
    Timestamp stamp = new Timestamp(timestamp.getUtcDatetime());
    Date userDate = new Date(stamp.getTime());
    JSONObject time = JsonExample.readJsonFromUrl("http://worldtimeapi.org/api/ip");
    String currentTime = time.getString("utc_datetime");
    System.out.println(currentTime);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(format.parse(currentTime));
    Date currentDate = format.parse(currentTime);
    System.out.println("current time: "+currentDate);
    long diff = currentDate.getTime() - userDate.getTime();
    DaysSpent days = new DaysSpent(diff / (1000 * 60 * 60 * 24));
    return days;
  }
  @POST
  @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Response saveDays(TimeSent timestamp) throws IOException,ParseException {
    Response res;
    res = Response.ok().build();
    String fileName = "timestamps.txt";
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    System.out.println(timestamp.getUtcDatetime());
    writer.write(String.valueOf(timestamp.getUtcDatetime()));
    writer.close();
    return res;
  }
}
