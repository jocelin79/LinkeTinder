class ListTest {

    Main m1 = new Main()

    boolean testeAdicionarCandidato() {

        List candidatos = []

        Candidato c1 = new Candidato(
                nome: "Luan",
                email: "luan@mail",
                cpf: "10397108570",
                idade: 20,
                estado: "Bahia",
                cep: 40040200,
                descricao: "descricao...", competencias: ["Python", "Java", "Spring Framework", "Angular"])

        int resultadoEsperado = 1

        m1.addCandidato(candidatos, c1)

        return candidatos.size().equals(resultadoEsperado)
    }

    boolean testeAdicionarEmpresa() {

        List empresas = []

        Empresa e1 = new Empresa(
                nome: "Sopa Boa",
                email: "sopaboa@mail",
                cnpj: "91397108570",
                pais: "Brasil",
                estado: "Bahia",
                cep: 40040200,
                descricao: "descricao...", competencias: ["Python", "Java", "Spring Framework", "Angular"])

        int resultadoEsperado = 1

        m1.addEmpresa(empresas, e1)

        return empresas.size().equals(resultadoEsperado)
    }

}
