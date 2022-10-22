interface ICandidatoDAO {
    List<Candidato> listar()
    void inserir(Candidato candidato)
    void alterar(Candidato candidato)
    void remover(Integer id)
}