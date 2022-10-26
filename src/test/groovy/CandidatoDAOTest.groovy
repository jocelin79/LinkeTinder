import groovy.test.GroovyTestCase
import org.junit.jupiter.api.Test


class CandidatoDAOTest extends GroovyTestCase{

	CandidatoDAO candidatoDAO = new CandidatoDAO(new Connection())
  
  @Test
	void testInserir() {
	  List listaInicialDeCandidatos = candidatoDAO.listar()
	  Candidato candidato = new Candidato('Teste', 'Teste', '1996-09-26',
			  'mario@nintendo.com', '11122233345', 'Brasil', '99090900',
			  'jogador de LOL', 'mario123')
	  candidatoDAO.inserir(candidato)
	  ArrayList<Candidato> listaFinalDeCandidatos = candidatoDAO.listar()
	  Integer tamanhaDaListaInicial = listaInicialDeCandidatos.size()
	  Integer tamanhoDaListaFinal = listaFinalDeCandidatos.size()
	  assertEquals(tamanhaDaListaInicial + 1, tamanhoDaListaFinal)
	  Integer indiceUltimoElemento = tamanhoDaListaFinal - 1
	  Integer idUltimoElemento = listaFinalDeCandidatos[indiceUltimoElemento].id
	  candidatoDAO.remover(idUltimoElemento)
  	}
  }


