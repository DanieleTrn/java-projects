package it.tirinnanzi.ivsb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.tirinnanzi.ivsb.entity.Appuntamento;
import it.tirinnanzi.ivsb.repository.AppuntamentiRepository;

@WebServlet("/appdel")
public class EliminaAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminaAppServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String data = request.getParameter("data");
		String ora = request.getParameter("ora");
		String luogo = request.getParameter("luogo");
		
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/");
		
		Appuntamento app = new Appuntamento(id,data,ora,luogo);
		AppuntamentiRepository repo = new AppuntamentiRepository(path);
		
		if(repo.deleteApp(app)) {
			
			sc.setAttribute("data", data);
			sc.setAttribute("ora", ora);
			sc.setAttribute("luogo", luogo);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/confirmDelApp.jsp");
			requestDispatcher.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("Errore");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
