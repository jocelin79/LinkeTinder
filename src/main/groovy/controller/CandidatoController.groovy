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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json")
        resp.setCharacterEncoding("utf-8")
        resp.setStatus(200)

        String nome = req.getParameter("nome")
        String sobrenome = req.getParameter("sobrenome")
        String data_nascimento = req.getParameter("data_nascimento")
        String email = req.getParameter("email")
        String cpf = req.getParameter("cpf")
        String pais_onde_reside = req.getParameter("pais_onde_reside")
        String cep = req.getParameter("cep")
        String descricao = req.getParameter("descricao")
        String senha = req.getParameter("senha")

        Candidato candidato = new Candidato()
        candidato.setNome(nome)
        candidato.setSobrenome(sobrenome)
        candidato.setData_nascimento(data_nascimento)
        candidato.setEmail(email)
        candidato.setCpf(cpf)
        candidato.setPais_onde_reside(pais_onde_reside)
        candidato.setCep(cep)
        candidato.setDescricao(descricao)
        candidato.setSenha(senha)

        PostgreConnectionProduct postgreConnectionProduct = new PostgreConnectionProduct()
        IConnection postgreConnection = postgreConnectionProduct.createConnection()
        CandidatoDAO candidatoDAO = new CandidatoDAO(postgreConnection)
        candidatoDAO.inserir(candidato)

        PrintWriter pw = resp.getWriter()
        pw.print("Candidato cadastrado com sucesso!")
        pw.flush()
    }
}
