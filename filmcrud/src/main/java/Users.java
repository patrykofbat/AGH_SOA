import dao.MovieDAO;
import dao.UserDAO;
import models.Movie;
import models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/users")
public class Users {
    private UserDAO userDao;

    public Users() {
        this.userDao = new UserDAO();
    }

    @GET
    @Produces("application/json")
    public Response getUsers() {
        List<User> usersList = this.userDao.getAll();
        return Response.status(Response.Status.OK).entity(usersList).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUser(User user) {
        System.out.println(user);
        this.userDao.save(user);
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response putUser(User user) {
        System.out.println(user);
        this.userDao.update(user);
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long id) {
        Optional<User> user = this.userDao.get(id);
        user.ifPresent(mov -> this.userDao.delete(mov));
        return Response.status(Response.Status.OK).build();
    }
}
