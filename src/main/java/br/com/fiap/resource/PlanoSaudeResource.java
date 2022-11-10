package br.com.fiap.resource;

import java.util.ArrayList;


import java.util.List;

import javax.ws.rs.Consumes;
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

import bo.PlanoSaudeBO;

import to.PlanoSaudeTO;
import to.UnidadeHospitalarTO;


@Path("/planos")
public class PlanoSaudeResource {
	
	PlanoSaudeBO plano = new PlanoSaudeBO();
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<PlanoSaudeTO> plano(){
//		return plano.exibirPlano();
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<PlanoSaudeTO> planos(){
		return plano.exibirPlanos();
	}
	
//	@GET
//	@Path("/plano/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<PlanoSaudeTO> exibirEnd(@PathParam("id") int id){
//		return plano.exibirUmPlano(id);
//	}
//	
//	@GET
//	@Path("/contato/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<UnidadeHospitalarTO> exibirContato(@PathParam("id") int id){
//		return plano.exibirUmUnidade(id);
//	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response cadastroPlano(PlanoSaudeTO planoTO, @Context UriInfo uriInfo ) {
//		plano.cadastrar(planoTO);
//		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
//		builder.path(Long.toString(planoTO.getId()));
//		return Response.created(builder.build()).build();
//	}

}
