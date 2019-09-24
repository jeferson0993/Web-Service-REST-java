package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.restful.controller.CandidatoController;
import br.com.restful.model.Candidato;

@Path("/candidatos")
public class CandidatoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Candidato> listarTodos() {
		System.out.println("Candidatos encontrados no banco");
		return new CandidatoController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		Candidato candidato = new CandidatoController().buscarPorId(id);
		if (candidato != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(candidato).build();
		} else {
			return Response.status(404).entity("Candidato nao encontrado").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarCandidatoJson(Candidato candidato) {
		boolean isCandidatoGravado = new CandidatoController().gravarCandidato(candidato);
		if (isCandidatoGravado == true) {
			return Response.ok().entity(candidato).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao gravar o candidato").build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response altualizarCandidato(Candidato candidato) {
		boolean isCandidatoAtualizado = new CandidatoController().atualizarCandidato(candidato);
		if (isCandidatoAtualizado == true) {
			return Response.ok().entity(candidato).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao atualizar o candidato").build();
		}

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarCandidato(Candidato candidato) {

		boolean isCandidatoDeletado = new CandidatoController().deletarCandidato(candidato);
		if (isCandidatoDeletado == true) {
			System.out.println("Candidato " + candidato.getNome() + " deletado");
			return Response.ok().entity(candidato).build();
		} else {
			System.out.println("Erro no servidor  ao deletar candidato: " + candidato.getNome());
			return Response.status(500).entity("Erro no servidor ao deletar o candidato: " + candidato.getNome()).build();
		}

	}

}
