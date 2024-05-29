package tech.buildrun.controller;


import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.buildrun.entity.UserEntity;
import tech.buildrun.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
  
  private final UserService userService;

  public UserController(UserService userService){
    this.userService = userService;
  }

  @POST
  @Transactional
  public Response createUser(UserEntity userEntity){
    
    return Response.ok(userService.createUser(userEntity)).build();
  }

  @GET
  public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("size") @DefaultValue("10") Integer size){
    List<UserEntity> users = userService.findAll(page, size);

    return Response.ok(users).build();
  }

  @GET
  @Path("/{id}")
  public Response findById(@PathParam("id") UUID userId){
    
    return Response.ok(userService.findById(userId)).build();
  }

  @PUT
  @Path("/{id}")
  @Transactional
  public Response updateeUser(@PathParam("id") UUID userId, UserEntity userEntity){
    
    return Response.ok(userService.updateUser(userId,userEntity)).build();
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  public Response deleteById(@PathParam("id") UUID userId){
    userService.deleteById(userId);
    return Response.noContent().build();
  }
}
