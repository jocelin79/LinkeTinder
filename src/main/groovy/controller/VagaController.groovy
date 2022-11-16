package controller

import com.google.gson.Gson
import model.EmpresaDAO
import model.IConnection
import model.PostgreConnectionProduct
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
    }
}
