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

import it.tirinnanzi.ivsb.entity.Account;
import it.tirinnanzi.ivsb.entity.Appuntamento;
import it.tirinnanzi.ivsb.repository.AccountsRepository;
import it.tirinnanzi.ivsb.repository.AppuntamentiRepository;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String psw = request.getParameter("password");
		
		ServletContext sc = getServletContext();
		String path = sc.getRealPath("/");
		AccountsRepository repo = new AccountsRepository(path);
		
		Account account = new Account(user,psw);
		
		if(repo.ricerca(account)) {
			
			AppuntamentiRepository repoApp = new AppuntamentiRepository(path);
			ArrayList<Appuntamento> appuntamenti = repoApp.ricerca(account.getId());
			
			sc.setAttribute("account",account);
			sc.setAttribute("appuntamenti", appuntamenti);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/sito.jsp");
			requestDispatcher.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("Errore");
		}
		
	}

}
