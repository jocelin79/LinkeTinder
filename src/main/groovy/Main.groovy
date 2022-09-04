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
  for(c in candidatos) {
    println(c)
  }

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
  for(e in empresas) {
    println(e)
  }
}