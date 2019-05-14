import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MovieDAO;
import models.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/films")
public class Films {

    private MovieDAO movieDAO;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Films() {
        this.movieDAO = new MovieDAO();
    }

    @GET
    @Produces("application/json")
    public Response getMovies() {
        List<Movie> movieList = this.movieDAO.getAll();
        return Response.status(Response.Status.OK).entity(movieList).build();
    }

    @GET
    @Produces("text/uri-list")
    public String getMoviesUriList() throws Exception {
        List<Movie> movieList = this.movieDAO.getAll();
        List<String> moviesUrl = movieList.stream().map(Movie::getUrl).collect(Collectors.toList());
        return objectMapper.writeValueAsString(moviesUrl);
    }

    @GET
    @Path("/image")
    @Produces({"image/png", "image/jpg", "image/gif"})
    public Response downloadFile() {
        File file = new File(this.getClass().getClassLoader().getResource("Studio_projektowe.png").getFile());
        Response.ResponseBuilder responseBuilder = Response.ok((Object) file);
        responseBuilder.header("Content-Disposition", "attachment; filename=\"MyPngImageFile.png\"");
        return responseBuilder.build();
    }

    @GET
    @Path("/{title}")
    @Produces("application/json")
    public Response getMovieByTitle(@PathParam("title") String title) {
        List<Movie> movieList = this.movieDAO.findAllByTitle(title);
        return Response.status(Response.Status.OK).entity(movieList).build();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postMovie(Movie movie) {
        System.out.println(movie);
        this.movieDAO.save(movie);
        return Response.status(Response.Status.CREATED).entity(movie).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response putMovie(Movie movie) {
        System.out.println(movie);
        this.movieDAO.update(movie);
        return Response.status(Response.Status.OK).entity(movie).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response updateMovieTitle(@PathParam("id") long id,  String url) {
        Optional<Movie> movie = this.movieDAO.get(id);
        movie.ifPresent(mov -> {
            mov.setUrl(url);
            this.movieDAO.update(mov);
        });
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
