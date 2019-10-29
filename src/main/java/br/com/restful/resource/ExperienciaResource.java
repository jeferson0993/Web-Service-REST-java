package br.com.restful.resource;

import br.com.restful.controller.ExperienciaController;
import br.com.restful.model.Experiencia;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/experiencias")
public class ExperienciaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Experiencia> listarTodos() {
		System.out.println("experiencias encontradas no banco");
		return new ExperienciaController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		System.out.println("/experiencias/" + id);
		Experiencia experiencia = new ExperienciaController().buscarPorId(id);
		if (experiencia != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(experiencia).build();
		} else {
			return Response.status(404).entity("experiencia nao encontrada").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarexperienciaJson(Experiencia experiencia) {
		boolean isexperienciaGravado = new ExperienciaController().gravarexperiencia(experiencia);
		if (isexperienciaGravado == true) {
			return Response.ok().entity(experiencia).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao gravar a experiencia").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response altualizarexperiencia(Experiencia experiencia) {
		boolean isexperienciaAtualizado = new ExperienciaController().atualizarexperiencia(experiencia);
		if (isexperienciaAtualizado == true) {
			return Response.ok().entity(experiencia).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao atualizar a experiencia").build();
		}

	}

	@DELETE        
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/{id}")
	public Response deletarexperiencia(@PathParam("id") Long id) {
            Experiencia experiencia = new ExperienciaController().buscarPorId(id);
            System.out.println("deletarExperiencia: " + experiencia.toString());
		boolean isexperienciaDeletado = new ExperienciaController().deletarexperiencia(experiencia);
		if (isexperienciaDeletado == true) {
			System.out.println("experiencia " + experiencia.getCargo() + " deletada");
			return Response.ok().entity(experiencia).build();
		} else {
			System.out.println("Erro no servidor ao deletar a experiencia: " + experiencia.getCargo());
			return Response.status(500).entity("Erro no servidor ao deletar a experiencia: " + experiencia.getCargo()).build();
		}
	}

}
