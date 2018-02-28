package br.uni7.testes.trabalho.unitario.nota;

import org.junit.jupiter.api.Test;

import br.uni7.testes.trabalho.dao.NotaDAO;
import br.uni7.testes.trabalho.entidade.Nota;
import junit.framework.TestCase;

public class NotaTeste extends TestCase{

	private NotaDAO notaDAO = new NotaDAO();
	
	@Test
	public void testAddNota() throws Exception {
		Nota nota = new Nota();
		nota.setId(1);
		nota.setTitulo("Teste 1 - Titulo");
		nota.setDescricao("Teste 1 - Descrição");
		
		notaDAO.addNota(nota);
		
		assertNotNull(nota);
	}
	
	@Test
	public void testBuscarNotaPorId() throws Exception {
		Nota nota = new Nota();
		nota.setId(2);
		nota.setTitulo("Teste 2 - Titulo");
		nota.setDescricao("Teste 2 - Descrição");
		
		notaDAO.addNota(nota);
		notaDAO.buscarNotaPorId(nota.getId());
		
		assertEquals(2, nota.getId());;
	}
	
	@Test
	public void testTituloNota() throws Exception {
		Nota nota = new Nota();
		nota.setId(2);
		nota.setTitulo("Teste 2 - Titulo");
		nota.setDescricao("Teste 2 - Descrição");
		
		notaDAO.addNota(nota);
		notaDAO.buscarNotaPorId(nota.getId());
		
		assertEquals("Teste 2 - Titulo", nota.getTitulo());;
	}
	
	@Test
	public void testDescricaoNota() throws Exception {
		Nota nota = new Nota();
		nota.setId(2);
		nota.setTitulo("Teste 2 - Titulo");
		nota.setDescricao("Teste 2 - Descrição");
		
		notaDAO.addNota(nota);
		notaDAO.buscarNotaPorId(nota.getId());
		
		assertEquals("Teste 2 - Descrição", nota.getDescricao());;
	}
	
	@Test
	public void testRemoverNota() throws Exception {
		Nota nota = new Nota();
		nota.setId(3);
		nota.setTitulo("Teste 3 - Titulo");
		nota.setDescricao("Teste 3 - Descrição");
		
		notaDAO.addNota(nota);
		notaDAO.removerNota(nota.getId());
		
		assertNull(nota.getId());
	}

}
