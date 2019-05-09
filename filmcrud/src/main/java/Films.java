import dao.MovieDAO;
import models.Movie;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/films")
public class Films {

    @GET
    @Produces("application/json")
    public Response getFilms() {
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> movieList = movieDAO.getAll();
        return Response.status(Response.Status.OK).entity(movieList).build();
    }
}
