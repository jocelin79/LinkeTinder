package model

interface IEmpresaDAO {
    List<Empresa> listar()
    void inserir(Empresa empresa)
    void alterar(Empresa empresa)
    void remover(Integer id)
}