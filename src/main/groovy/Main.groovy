static void main(String[] args) {

  boolean on = true;

  while (on) {
    print("Se deseja listar os Candidatos, digite 1;\n" +
            "Se deseja listar as Empresas, digite 2;\n" +
            "Se deseja adicionar um novo Candidato, digite 3;\n" +
            "Se deseja adicionar uma nova Empresa, digite 4;\n" +
            "Se deseja listar os Candidatos do DB, digite 5;\n" +
            "Se deseja testar a adição de Empresa, digite 6;\n" +
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
        EmpresaDAO empresaDAO = new EmpresaDAO()
        List empresa = empresaDAO.listar()
        for(c in empresa) {
          println(c)
        }
        break
      case "3":

        break
      case "4":

        break
      case "5":
        
            break
      case "6":
        ListTest teste = new ListTest()
        boolean resultado
        resultado = teste.testeAdicionarEmpresa()
        println("Teste bem-sucedido: " + resultado)5
            break
      case "0":
        on = false
        break
    }
  }

}
