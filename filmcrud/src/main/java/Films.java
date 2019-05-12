import dao.MovieDAO;
import models.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/films")
public class Films {

    private MovieDAO movieDAO;

    public Films() {
        this.movieDAO = new MovieDAO();
    }

    @GET
    @Produces("application/json")
    public Response getMovies() {
        List<Movie> movieList = this.movieDAO.getAll();
        return Response.status(Response.Status.OK).entity(movieList).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postMovie(Movie movie) {
        System.out.println(movie);
        this.movieDAO.save(movie);
        return Response.status(Response.Status.OK).entity(movie).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response putMovie(Movie movie) {
        System.out.println(movie);
        this.movieDAO.update(movie);
        return Response.status(Response.Status.OK).entity(movie).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") long id) {
        Optional<Movie> movie = this.movieDAO.get(id);
        movie.ifPresent(mov -> this.movieDAO.delete(mov));
        return Response.status(Response.Status.OK).build();
    }


}
