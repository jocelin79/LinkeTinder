package controller

import com.google.gson.Gson
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

@WebServlet (urlPatterns = "/vagas")
class VagaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Gson gson = new Gson()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        VagaDAO vagaDAO = new VagaDAO(postgreConnection)
        List vagas = vagaDAO.listar()

        PrintWriter pw = resp.getWriter()
        pw.print(gson.toJson(vagas))
        pw.flush()
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        String descricao = req.getParameter("descricao")
        String local_da_vaga = req.getParameter("local_da_vaga")
        Integer idEmpresa = req.getParameter("idEmpresa").toInteger()

        Vaga vaga = new Vaga()
        vaga.setDescricao(descricao)
        vaga.setLocal_da_vaga(local_da_vaga)
        vaga.setIdEmpresa(idEmpresa)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        VagaDAO vagaDAO = new VagaDAO(postgreConnection)
        vagaDAO.inserir(vaga)

        PrintWriter pw = resp.getWriter()
        pw.print("Vaga cadastrado com sucesso!")
        pw.flush()
    }
}
