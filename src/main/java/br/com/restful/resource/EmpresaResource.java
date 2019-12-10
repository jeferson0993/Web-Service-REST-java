package br.com.restful.resource;

import br.com.restful.controller.EmpresaController;
import br.com.restful.controller.VagaController;
import br.com.restful.model.Empresa;
import br.com.restful.model.Vaga;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/empresas")
public class EmpresaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Empresa> listarTodos() {
		System.out.println("EmpresaResource.listarTodos()");
		return new EmpresaController().listarTodos();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		Empresa empresa = new EmpresaController().buscarPorId(id);
		if (empresa != null) {
			return Response.ok().type(MediaType.APPLICATION_JSON).entity(empresa).build();
		} else {
			return Response.status(404).entity("empresa nao encontrada").build();
		}
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/razao-social/{empresa}")
	public ArrayList<Empresa> getByNome(@PathParam("empresa") String empresa) {
		System.out.println("empresa -> " + empresa);
                return new EmpresaController().razaoSocial(empresa);
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/razao-social/estado/{estado}")
	public ArrayList<Empresa> getByEstado(@PathParam("estado") String estado) {
		System.out.println("estado -> " + estado);
                return new EmpresaController().buscarPorEstado(estado);
	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/razao-social/estado/cidade/{cidade}")
	public ArrayList<Empresa> getByCidade(@PathParam("cidade") String cidade) {
		System.out.println("estado -> " + cidade);
                return new EmpresaController().buscarPorCidade(cidade);
	}        
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/razao-social/estado/cidade/bairro/{bairro}")
	public ArrayList<Empresa> getByBairro(@PathParam("bairro") String bairro) {
		System.out.println("bairro -> " + bairro);
                return new EmpresaController().buscarPorBairro(bairro);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarempresaJson(Empresa empresa) {
            System.out.println("EmpresaResource.salvarempresaJson()");
		boolean isempresaGravado = new EmpresaController().gravarEmpresa(empresa);
		if (isempresaGravado == true) {
			return Response.ok().entity(empresa).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao gravar a empresa").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response altualizarempresa(Empresa empresa) {
		boolean isempresaAtualizado = new EmpresaController().atualizarEmpresa(empresa);
                System.out.println("is empresa atualizada => " + isempresaAtualizado);
		if (isempresaAtualizado == true) {
			return Response.ok().entity(empresa).build();
		} else {
			return Response.status(500).entity("Erro no servidor ao atualizar a empresa").build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
        @Path("/{id}")
	public Response deletarempresa(@PathParam("id") Long id) {
            Empresa empresa = new EmpresaController().buscarPorId(id);
            ArrayList<Vaga> vagas = empresa.getVagas();
            for (Vaga vaga : vagas) {
                new VagaController().deletarvaga(vaga);
            }        
		boolean isempresaDeletado = new EmpresaController().deletarEmpresa(empresa);
		if (isempresaDeletado == true) {
			System.out.println("empresa " + empresa.getRazaoSocial() + " deletada");
			return Response.ok().entity(empresa).build();
		} else {
			System.out.println("Erro no servidor ao deletar a empresa: " + empresa.getRazaoSocial());
			return Response.status(500).entity("Erro no servidor  ao deletar empresa: " + empresa.getRazaoSocial()).build();
		}
	}

}
