package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import bo.VeiculoBO;
import to.EnderecoTO;
import to.UsuarioTO;
import to.VeiculoTO;

@Path("/veiculo")
public class VeiculoResource {
	VeiculoBO veiculo = new VeiculoBO();
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		veiculo.delete(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoTO> exibir() {
		return veiculo.listarTodos();	
	}
	
	@GET
	@Path("/listar/{placa}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoTO> exibirEnd(@PathParam("placa") String placa){
		return veiculo.listarPelaPlaca(placa);
	}
	
	@POST
	@Path("/cadastro-veiculo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroUsuario(VeiculoTO vto, @Context UriInfo uriInfo ) {
		veiculo.cadastrar(vto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(vto.getId()));
		return Response.created(builder.build()).build();
	}

}
