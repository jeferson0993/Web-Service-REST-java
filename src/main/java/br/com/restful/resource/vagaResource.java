package br.com.restful.resource;

import br.com.restful.controller.VagaController;
import br.com.restful.model.Vaga;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/vagas")
public class vagaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vaga> listarTodos() {
		System.out.println("vagas encontradas no banco");
		return new VagaController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		System.out.println("/vagas/" + id);
		Vaga vaga = new VagaController().buscarPorId(id);
		if (vaga != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(vaga).build();
		} else {
			return Response.status(404).entity("vaga nao encontrada").build();
		}
	}

        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cargo/{cargo}")
	public ArrayList<Vaga> getByCargo(@PathParam("cargo") String cargo) {
		System.out.println("cargo -> " + cargo);
                return new VagaController().buscarPorCargo(cargo);
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cargo/empresa/{empresa}")
	public ArrayList<Vaga> getByEmpresa(@PathParam("empresa") String empresa) {
		System.out.println("empresa -> " + empresa);
                return new VagaController().buscarPorEmpresa(empresa);
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cargo/empresa/estado/{estado}")
	public ArrayList<Vaga> getByEstado(@PathParam("estado") String estado) {
		System.out.println("estado -> " + estado);
                return new VagaController().buscarPorEstado(estado);
	}        
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cargo/empresa/estado/cidade/{cidade}")
	public ArrayList<Vaga> getByCidade(@PathParam("cidade") String cidade) {
		System.out.println("cidade -> " + cidade);
                return new VagaController().buscarPorCidade(cidade);
	}
                      
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarvagaJson(Vaga vaga) {
		boolean isvagaGravado = new VagaController().gravarvaga(vaga);
		if (isvagaGravado == true) {
			return Response.ok().entity(vaga).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao gravar a vaga").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response altualizarvaga(Vaga vaga) {
		boolean isvagaAtualizado = new VagaController().atualizarvaga(vaga);
		if (isvagaAtualizado == true) {
			return Response.ok().entity(vaga).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao atualizar a vaga").build();
		}

	}

	@DELETE        
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/{id}")
	public Response deletarvaga(@PathParam("id") Long id) {
            Vaga vaga = new VagaController().buscarPorId(id);
            System.out.println("deletarVaga: " + vaga.toString());
		boolean isvagaDeletado = new VagaController().deletarvaga(vaga);
		if (isvagaDeletado == true) {
			System.out.println("vaga " + vaga.getNome() + " deletada");
			return Response.ok().entity(vaga).build();
		} else {
			System.out.println("Erro no servidor ao deletar a vaga: " + vaga.getNome());
			return Response.status(500).entity("Erro no servidor ao deletar a vaga: " + vaga.getNome()).build();
		}
	}

}
