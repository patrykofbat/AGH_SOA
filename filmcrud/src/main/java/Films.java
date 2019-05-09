import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/films")
public class Films {

    @GET
    public Response getFilms() {
        return Response.status(Response.Status.OK).entity("Siemka").build();
    }
}
