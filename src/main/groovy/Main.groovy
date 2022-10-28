import model.Candidato
import model.CandidatoDAO
import model.IConnection
import model.PostgreConnectionProduct

static void main(String[] args) {

  boolean on = true;

  while (on) {
    print("\nSe deseja listar os Candidatos, digite 1;\n" +
            "Se deseja inserir um novo model.Candidato, digite 2;\n" +
            "Se deseja alterar um novo model.Candidato, digite 3;\n" +
            "Se deseja remover um novo model.Candidato, digite 4;\n" +
            "Caso deseje Finalizar o atendimento, digite 0.\n" +
            "Digite aqui:")

    Scanner s = new Scanner(System.in)
    String response = s.nextLine()

    switch (response) {
      case "1":
        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
        List candidato = candidatoDAO.listar()
        for(c in candidato) {
          println(c)
        }
        break
      case "2":
        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
        Candidato candidato = new Candidato()
        print("Digite o nome:")
        s = new Scanner(System.in)
        candidato.setNome(s.nextLine())
        print("Digite o sobrenome:")
        s = new Scanner(System.in)
        candidato.setSobrenome(s.nextLine())
        print("Digite a data de nascimento:")
        s = new Scanner(System.in)
        candidato.setData_nascimento(s.nextLine())
        print("Digite o email:")
        s = new Scanner(System.in)
        candidato.setEmail(s.nextLine())
        print("Digite o cpf:")
        s = new Scanner(System.in)
        candidato.setCpf(s.nextLine())
        print("Digite o pais onde reside:")
        s = new Scanner(System.in)
        candidato.setPais_onde_reside(s.nextLine())
        print("Digite o cep:")
        s = new Scanner(System.in)
        candidato.setCep(s.nextLine())
        print("Digite a descrição:")
        s = new Scanner(System.in)
        candidato.setDescricao(s.nextLine())
        print("Digite a senha:")
        s = new Scanner(System.in)
        candidato.setSenha(s.nextLine())
        candidatoDAO.inserir(candidato)
        print("model.Candidato Inserido.")
        break
      case "3":
        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
            Candidato candidato = new Candidato()
        print("Digite o nome:")
        s = new Scanner(System.in)
        candidato.setNome(s.nextLine())
        print("Digite o sobrenome:")
        s = new Scanner(System.in)
        candidato.setSobrenome(s.nextLine())
        print("Digite a data de nascimento:")
        s = new Scanner(System.in)
        candidato.setData_nascimento(s.nextLine())
        print("Digite o email:")
        s = new Scanner(System.in)
        candidato.setEmail(s.nextLine())
        print("Digite o cpf:")
        s = new Scanner(System.in)
        candidato.setCpf(s.nextLine())
        print("Digite o pais onde reside:")
        s = new Scanner(System.in)
        candidato.setPais_onde_reside(s.nextLine())
        print("Digite o cep:")
        s = new Scanner(System.in)
        candidato.setCep(s.nextLine())
        print("Digite a descrição:")
        s = new Scanner(System.in)
        candidato.setDescricao(s.nextLine())
        print("Digite a senha:")
        s = new Scanner(System.in)
        candidato.setSenha(s.nextLine())
        print("Digite o id:")
        s = new Scanner(System.in)
        candidato.setId(Integer.parseInt(s.nextLine()))
        candidatoDAO.alterar(candidato)
        print("model.Candidato Alterado.")
        break
      case "4":
        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
        print("Digite o id:")
        s = new Scanner(System.in)
        candidatoDAO.remover(Integer.parseInt(s.nextLine()))
        print("model.Candidato Removido.")
        break
      case "0":
        on = false
        break
    }
  }

}
