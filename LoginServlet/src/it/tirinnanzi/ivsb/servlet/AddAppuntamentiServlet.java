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


@WebServlet("/addmeet")
public class AddAppuntamentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAppuntamentiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String data = request.getParameter("data");
		String ora = request.getParameter("ora");
		String luogo = request.getParameter("luogo");
		
		if(!data.equals("") && !ora.equals("") && !luogo.equals("")) {
			ServletContext sc = getServletContext();
			String path = sc.getRealPath("/");
			
			AppuntamentiRepository repo = new AppuntamentiRepository(path);
			Appuntamento app = new Appuntamento(data,ora,luogo);
			repo.addAppuntamento(app, user);
			
			sc.setAttribute("appuntamento",app);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/confirmApp.jsp");
			requestDispatcher.forward(request,response);
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("Errore");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
