package br.uni7.testes.trabalho.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.uni7.testes.trabalho.dao.NotaDAO;
import br.uni7.testes.trabalho.entidade.Nota;


@Path("/notas")
public class NotasService {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private NotaDAO notaDAO;
	
	@PostConstruct
	private void init() {
		notaDAO = new NotaDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Nota> listarNotas() {
		List<Nota> lista = null;
		try {
			lista = notaDAO.listarNotas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNota(Nota nota) {
		String msg = "";

		System.out.println(nota.getTitulo());

		try {
			notaDAO.addNota(nota);

			msg = "Nota add com sucesso!";
		} catch (Exception e) {
			msg = "Erro ao add a nota!";
			e.printStackTrace();
		}

		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Nota buscarPorId(@PathParam("id") int idNota) {
		Nota nota = null;
		try {
			nota = notaDAO.buscarNotaPorId(idNota);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nota;
	}
}