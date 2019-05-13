import models.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/osoby")
public class Osoby {

    @GET
    public Response getUsers() {
        return Response.status(Response.Status.TEMPORARY_REDIRECT).location(URI.create("users")).build();
    }
}
