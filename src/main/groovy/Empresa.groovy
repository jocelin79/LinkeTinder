@groovy.transform.ToString
class Empresa extends Pessoa{
   public String nome, email, cnpj, pais, estado
    Integer cep
    String descricao
    List<String> competencias

    static void hello() {
        println("Hello!")
    }
}
