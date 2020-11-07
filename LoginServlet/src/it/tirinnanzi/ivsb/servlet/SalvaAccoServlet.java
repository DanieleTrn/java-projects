package it.tirinnanzi.ivsb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.tirinnanzi.ivsb.entity.Account;
import it.tirinnanzi.ivsb.repository.AccountsRepository;


@SuppressWarnings("serial")
@WebServlet("/salva")
public class SalvaAccoServlet extends HttpServlet {

       
    public SalvaAccoServlet() {
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
		
		if(account.getId() != "" || account.getPassword() != "") {
			repo.salvaAccount(account);
		}else {
			//ERRORE
		}
		
		sc.setAttribute("account", account);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registrazione.jsp");
		requestDispatcher.forward(request,response);
	}

}
