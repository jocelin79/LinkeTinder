interface IVagaDAO {
    List<Vaga> listar()
    void inserir(Vaga vaga)
    void alterar(Vaga vaga)
    void remover(Integer id)
}