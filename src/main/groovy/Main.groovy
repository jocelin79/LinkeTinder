static void main(String[] args) {

  boolean on = true;

  while (on) {
    print(\n"Se deseja listar os Candidatos, digite 1;\n" +
            "Se deseja inserir um novo Candidato, digite 2;\n" +
            "Se deseja alterar um novo Candidato, digite 3;\n" +
            "Se deseja remover um novo Candidato, digite 4;\n" +
            "Se deseja listar as Empresas, digite 5;\n" +
            "Se deseja inserir uma nova Empresa, digite 6;\n" +
            "Se deseja alterar uma nova Empresa, digite 7;\n" +
            "Se deseja remover uma nova Empresa, digite 8;\n" +
            "Se deseja listar as Competências, digite 9;\n" +
            "Se deseja inserir uma nova Competência, digite 10;\n" +
            "Se deseja alterar uma nova Competência, digite 11;\n" +
            "Se deseja remover uma nova Competência, digite 12;\n" +
            "Se deseja listar as Vagas, digite 13;\n" +
            "Se deseja inserir uma nova Vaga, digite 14;\n" +
            "Se deseja alterar uma nova Vaga, digite 15;\n" +
            "Se deseja remover uma nova Vaga, digite 16;\n" +
            "Caso deseje Finalizar o atendimento, digite 0.\n" +
            "Digite aqui:")

    Scanner s = new Scanner(System.in)
    String response = s.nextLine()

    switch (response) {
      case "1":
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        List candidato = candidatoDAO.listar()
        for(c in candidato) {
          println(c)
        }
        break
      case "2":
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        Candidato candidato = new Candidato()
        print("Digite o nome:")
        Scanner s = new Scanner(System.in)
        candidato.setNome(s.nextLine())
        print("Digite o sobrenome:")
        Scanner s = new Scanner(System.in)
        candidato.setNome(s.nextLine())
        print("Digite a data de nascimento:")
        Scanner s = new Scanner(System.in)
        candidato.setSobrenome(s.nextLine())
        print("Digite o email:")
        Scanner s = new Scanner(System.in)
        candidato.setEmail(s.nextLine())
        print("Digite o cpf:")
        Scanner s = new Scanner(System.in)
        candidato.setCpf(s.nextLine())
        print("Digite o pais onde reside:")
        Scanner s = new Scanner(System.in)
        candidato.setPais_onde_reside(s.nextLine())
        print("Digite o cep:")
        Scanner s = new Scanner(System.in)
        candidato.setCep(s.nextLine())
        print("Digite a descrição:")
        Scanner s = new Scanner(System.in)
        candidato.setDescricao(s.nextLine())
        print("Digite a senha:")
        Scanner s = new Scanner(System.in)
        candidato.setSenha(s.nextLine())
        candidatoDAO.inserir(candidato)
        print("Candidato Inserido.")
        break
      case "3":

        break
      case "4":

        break
      case "5":
        EmpresaDAO empresaDAO = new EmpresaDAO()
        List empresa = empresaDAO.listar()
        for(c in empresa) {
          println(c)
        }
            break
      case "6":
        
            break
      case "0":
        on = false
        break
    }
  }

}
