import groovy.test.GroovyTestCase
import org.junit.jupiter.api.Test


class CandidatoDAOTest extends GroovyTestCase{

	CandidatoDAO candidatoDAO

	@Test
	void testListar() {
		candidatoDAO = new CandidatoDAO()

		String saida = parser.executar('5,5,F,F,F,F,C')
		assertEquals('8', saida)
	}
  
  @Test
	void testInserir() {
		candidatoDAO = new CandidatoDAO()

		String saida = parser.executar('5,5,F,F,F,F,C')
		assertEquals('8', saida)
	}
  
  @Test
	void testAlterar() {
		candidatoDAO = new CandidatoDAO()

		String saida = parser.executar('5,5,F,F,F,F,C')
		assertEquals('8', saida)
	}
  
  @Test
	void testRemover() {
		candidatoDAO = new CandidatoDAO()

		String saida = parser.executar('5,5,F,F,F,F,C')
		assertEquals('8', saida)
	}
}
