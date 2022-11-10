package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import bo.UsuarioBO;
import to.ContatoTO;
import to.EnderecoTO;
import to.UsuarioTO;

@Path("/usuario")
public class UsuarioResource {
	UsuarioBO user = new UsuarioBO();
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(UsuarioTO userTO, @PathParam("id") int id) {
		userTO.setId(id);
		user.alterar(userTO);
		
		return Response.ok().build();
		
	}
	
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		user.delete(id);
	}
	
	@GET
	@Path("/get/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> exibirUmUser(@PathParam("login") String login){
		return user.listarUmUserLogin(login);
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> exibirUmUser(@PathParam("id") int id){
		return user.listarUmUser(id);
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response LoginUser(UsuarioTO usuario) {
		return Response
				.status(200)
				.entity(user.login(usuario))
				.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> exibir() {
		return user.listarTodos();	
	}
	
	@GET
	@Path("/endereco/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoTO> exibirEnd(@PathParam("id") int id){
		return user.listarUmEnd(id);
	}
	
	@GET
	@Path("/contato/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContatoTO> exibirContato(@PathParam("id") int id){
		return user.listarUmCont(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroUsuario(UsuarioTO userTO, @Context UriInfo uriInfo ) {
		user.cadastrar(userTO);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(userTO.getId()));
		return Response.created(builder.build()).build();
	}
	
	
	
	
	
	

}
