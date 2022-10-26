interface ICompetenciaDAO {
    List<Competencia> listar()
    void inserir(Competencia competencia)
    void alterar(Competencia competencia)
    void remover(Integer id)
}