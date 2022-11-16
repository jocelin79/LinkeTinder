package controller

import com.google.gson.Gson
import model.CompetenciaDAO
import model.EmpresaDAO
import model.IConnection
import model.PostgreConnectionProduct

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet (urlPatterns = "/competencias")
class CompetenciaController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Gson gson = new Gson()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CompetenciaDAO competenciaDAO = new CompetenciaDAO(postgreConnection)
        List competencias = competenciaDAO.listar()

        PrintWriter pw = resp.getWriter()
        pw.print(gson.toJson(competencias))
        pw.flush()
    }
}
