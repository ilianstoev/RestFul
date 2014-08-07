package rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class EmployeeResource {
	
	
	static String name[] = {"Bob", "Sue", "John"};
	static int[] id = {1, 2, 3};
	static final String str = "1";
	
	@GET()
	@Produces(MediaType.TEXT_HTML)
	public String listEmployees(){
		List<String> list = new ArrayList<>();
		String response = " ";
		for (int i=0; i<id.length; i++ )
		{
			response = "Name: "+name[i] +" "+"Id: "+ (Integer.toString(id[i])+"\n");
			list.add(response);
		}
		return list.toString();
	}
	
	@GET()
	@Path("{id}")
	@Produces(MediaType.TEXT_HTML)
	public String listEmployees( @PathParam("id") String id) {
		return name[Integer.parseInt(id)];
	}
	
	@POST()
	@Path("/send")
	@Produces(MediaType.TEXT_HTML)
	public Response send(Employee emp){
		
		String output = emp.toString();
		return Response.status(200).entity(output).build();
	}
	

}
