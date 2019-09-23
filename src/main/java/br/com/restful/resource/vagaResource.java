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
		System.out.println("vagas encontrados no banco");
		return new VagaController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/vagas/{id}")
	public Response getById(@PathParam("id") Long id) {
		Vaga vaga = new VagaController().buscarPorId(id);
		if (vaga != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(vaga).build();
		} else {
			return Response.status(404).entity("vaga nao encontrado").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarvagaJson(Vaga vaga) {
		boolean isvagaGravado = new VagaController().gravarvaga(vaga);
		if (isvagaGravado == true) {
			return Response.ok().entity(vaga).build();
		} else {
			return Response.status(500).entity("Erro no servidor  ao gravar vaga").build();
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
			return Response.status(500).entity("Erro no servidor  ao atualizar vaga").build();
		}

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarvaga(Vaga vaga) {

		boolean isvagaDeletado = new VagaController().deletarvaga(vaga);
		if (isvagaDeletado == true) {
			System.out.println("vaga " + vaga.getNome() + " deletado");
			return Response.ok().entity(vaga).build();
		} else {
			System.out.println("Erro no servidor  ao deletar vaga: " + vaga.getNome());
			return Response.status(500).entity("Erro no servidor  ao deletar vaga: " + vaga.getNome()).build();
		}

	}

}
