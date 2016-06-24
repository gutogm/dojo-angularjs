package ToDo.rest;


import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import ToDo.rest.util.*;

import ToDo.entity.Item;
import ToDo.business.ItemBusiness;
import ToDo.dao.SessionManager;

import ToDo.rest.exceptions.CustomWebApplicationException;
import javax.servlet.http.HttpServletRequest;

@Path("/item")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ItemREST implements RESTService<Item> {
  
  private SessionManager session;
  
  private ItemBusiness business;
  
  @Context 
  private HttpServletRequest request;

  public ItemREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new ItemBusiness(session);
  }
  
  @POST
  public Response post(Item entity) {
    try {
	    session.begin();
	    business.save(entity);
	    session.commit();
	    business.refresh(entity);
	    return Response.ok(entity).build();
    }catch(Exception exception){
	    session.rollBack();
      throw new CustomWebApplicationException(exception);
    }
  }
  
  @GET  @Path("/{id}")
  public Response get(@PathParam("id") java.lang.String id) {
    try {
	    session.begin();
	    Item updatedEntity = business.findById(id);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }catch(Exception exception){
	    session.rollBack();
      throw new CustomWebApplicationException(exception);
    }  
  }
  
  @PUT @Path("/{id}")
  public Response putWithId(Item entity) {
    try {
	    session.begin();
	    Item updatedEntity = business.update(entity);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }catch(Exception exception){
	    session.rollBack();
      throw new CustomWebApplicationException(exception);
    }  
  }
  
  @DELETE  @Path("/{id}")
  public Response delete(@PathParam("id") java.lang.String id) {  
		try {
			session.begin();
			if (business.deleteById(id) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				return Response.status(404).build();
			}
		}catch (Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);
		}    
  }
  
  @GET
  public GenericEntity<List<Item>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Item>>(business.list(limit, offset)){};
  }
	
}
