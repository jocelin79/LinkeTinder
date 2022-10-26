import groovy.test.GroovyTestCase
import org.junit.jupiter.api.Test

class EmpresaDAOTest extends GroovyTestCase{

	EmpresaDAO empresaDAO = new EmpresaDAO(new Connection())
  
  @Test
	void testInserir() {
	  List listaInicialDeEmpresas = empresaDAO.listar()
	  Empresa empresa = new Empresa('Espetos', '11111111111111', 'espetos@zmail.com',
			  'Brasil', '11010100', 'Temos os melhores espetinhos.',
			  'espetos123')
	  empresaDAO.inserir(empresa)
	  ArrayList<Empresa> listaFinalDeEmpresa = empresaDAO.listar()
	  Integer tamanhaDaListaInicial = listaInicialDeEmpresas.size()
	  Integer tamanhoDaListaFinal = listaFinalDeEmpresa.size()
	  assertEquals(tamanhaDaListaInicial + 1, tamanhoDaListaFinal)
	  Integer indiceUltimoElemento = tamanhoDaListaFinal - 1
	  Integer idUltimoElemento = listaFinalDeEmpresa[indiceUltimoElemento].id
	  empresaDAO.remover(idUltimoElemento)
  	}
  }