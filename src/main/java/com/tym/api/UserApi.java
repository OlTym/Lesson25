package com.tym.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tym.dao.UserDao;
import com.tym.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class UserApi {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAll() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        UserDao dao = new UserDao();
        List<User> users = dao.getAll();
        String json = gson.toJson(users);
        return Response
                .status(Response.Status.OK)
                .entity(json)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addUser(@FormParam("name") String name, @FormParam("post") String post, @FormParam("age") int age) {
        UserDao dao = new UserDao();
        dao.addUser(new User(name, post, age));
        return Response
                .status(Response.Status.OK)
                .entity("Пользователь добавлен в БД")
                .build();
    }

}
