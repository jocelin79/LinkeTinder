static void main(String[] args) {

  Candidato c1 = new Candidato(
          nome: "Luan",
          email: "luan@mail",
          cpf: "10397108570",
          idade: 20,
          estado: "Bahia",
          cep: 40040200,
          descricao: "descricao...", competencias: ["Python", "Java", "Spring Framework", "Angular"])
  Candidato c2 = new Candidato(
          nome: "Rita",
          email: "rita@mail",
          cpf: "20397108570",
          idade: 21,
          estado: "Alagoas",
          cep: 41040200,
          descricao: "descricao...", competencias: ["Angular"])
  Candidato c3 = new Candidato(
          nome: "Ken",
          email: "ken@mail",
          cpf: "30397108570",
          idade: 23,
          estado: "Sergipe",
          cep: 43040200,
          descricao: "descricao...", competencias: ["Java"])
  Candidato c4 = new Candidato(
          nome: "Liza",
          email: "liza@mail",
          cpf: "40397108570",
          idade: 24,
          estado: "Minas Gerais",
          cep: 44040200,
          descricao: "descricao...", competencias: ["Spring Framework"])
  Candidato c5 = new Candidato(
          nome: "Jason",
          email: "jason@mail",
          cpf: "50397108570",
          idade: 25,
          estado: "Pernanbuco",
          cep: 45040200,
          descricao: "descricao...", competencias: ["Python"])
  List candidatos = [c1, c2, c3, c4, c5]


  Empresa e1 = new Empresa(
          nome: "Sopa Boa",
          email: "sopaboa@mail",
          cnpj: "91397108570",
          pais: "Brasil",
          estado: "Bahia",
          cep: 40040200,
          descricao: "descricao...", competencias: ["Python", "Java", "Spring Framework", "Angular"])
  Empresa e2 = new Empresa(
          nome: "Amazon",
          email: "amazon@mail",
          cnpj: "92397108570",
          pais: "Brasil",
          estado: "Sergipe",
          cep: 41040200,
          descricao: "descricao...", competencias: ["Angular"])
  Empresa e3 = new Empresa(
          nome: "Banco do Brasil",
          email: "bb@mail",
          cnpj: "93397108570",
          pais: "Brasil",
          estado: "Sergipe",
          cep: 43040200,
          descricao: "descricao...", competencias: ["Java"])
  Empresa e4 = new Empresa(
          nome: "Zero Glosa",
          email: "zg@mail",
          cnpj: "94397108570",
          pais: "Brasil",
          estado: "Minas Gerais",
          cep: 44040200,
          descricao: "descricao...", competencias: ["Spring Framework"])
  Empresa e5 = new Empresa(
          nome: "Jason Motosserras",
          email: "motosseras@mail",
          cnpj: "95397108570",
          pais: "Estados Unidos",
          estado: "Texas",
          cep: 95040200,
          descricao: "descricao...", competencias: ["Groovy"])
  List empresas = [e1, e2, e3, e4, e5]

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
        for(c in candidatos) {
          println(c)
        }
        break
      case "2":
        for(e in empresas) {
        println(e)
      }
        break
      case "3":
        addCandidato(candidatos, c3)
        break
      case "4":
        addEmpresa(empresas, e3)
        break
      case "5":
        CandidatoDAO candidato = new CandidatoDAO();
        candidato.listar()
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

static void addCandidato(List list, Candidato c) {
  list.add(c)
}

static void addEmpresa(List list, Empresa e) {
  list.add(e)
}