package controller

import com.google.gson.Gson
import model.CandidatoDAO
import model.Empresa
import model.EmpresaDAO
import model.IConnection
import model.PostgreConnectionProduct
import model.Vaga
import model.VagaDAO

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet (urlPatterns = "/empresas")
class EmpresaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Gson gson = new Gson()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        EmpresaDAO empresaDAO = new EmpresaDAO(postgreConnection)
        List empresas = empresaDAO.listar()

        PrintWriter pw = resp.getWriter()
        pw.print(gson.toJson(empresas))
        pw.flush()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        String nome = req.getParameter("nome")
        String cnpj = req.getParameter("cnpj")
        Integer email = req.getParameter("email")
        String pais_onde_reside = req.getParameter("pais_onde_reside")
        String cep = req.getParameter("cep")
        String descricao = req.getParameter("descricao")
        String senha = req.getParameter("senha")

        Empresa empresa = new Empresa()
        empresa.setNome(nome)
        empresa.setCnpj(cnpj)
        empresa.setEmail(email)
        empresa.setPais_onde_reside(pais_onde_reside)
        empresa.setCep(cep)
        empresa.setDescricao(descricao)
        empresa.setSenha(senha)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        EmpresaDAO empresaDAO = new EmpresaDAO(postgreConnection)
        empresaDAO.inserir(empresa)

        PrintWriter pw = resp.getWriter()
        pw.print("Empresa cadastrada com sucesso!")
        pw.flush()
    }
}
