package restcourse.resources;

import restcourse.models.Person;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


@Path("/testservice")
public class TestService {
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Person getTestService() {
    System.out.println("sending person maaaan");
    Person person = new Person("Snow", "John", "johnsnow", "snow@knownothing.com");
    return person;
  }

  @PUT
  @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Response puPerson(Person p) {

    Response res;
    res = Response.ok().build();
    System.out.println("gota person maaaan");
    System.out.println(p.getName());

    return res;

  }



}
