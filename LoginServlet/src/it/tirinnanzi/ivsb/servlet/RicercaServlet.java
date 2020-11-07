package it.tirinnanzi.ivsb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.tirinnanzi.ivsb.repository.AccountsRepository;

@WebServlet("/ricercaid")
public class RicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RicercaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idToFind");
		
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/");
		AccountsRepository repo = new AccountsRepository(path);
		
		ArrayList<String> contatti = repo.ricercaContatti(id);
		
		if(null == contatti) {
			PrintWriter out = response.getWriter();
			out.println("Errore");
		}else {
			
			sc.setAttribute("findedId", contatti);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/sito.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}