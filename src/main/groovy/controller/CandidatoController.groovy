package controller

import model.Candidato
import model.CandidatoDAO
import model.IConnection
import model.PostgreConnectionProduct

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import com.google.gson.Gson

@WebServlet (urlPatterns = "/candidatos")
class CandidatoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Gson gson = new Gson()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
        List candidatos = candidatoDAO.listar()

        PrintWriter pw = resp.getWriter()
        pw.print(gson.toJson(candidatos))
        pw.flush()
    }
}
