package servlets;

import java.io.IOException;

import dao.DaoFactory;
import dao.implement.AuthDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Auth;

@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static AuthDAO authDAO = DaoFactory.createAuthDAO();

	public AuthenticateServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if(acao != null && !acao.isEmpty()) {
			
			if(acao.equalsIgnoreCase("login")) {
				login(request, response);
			}else if(acao.equalsIgnoreCase("register")) {
				register(request, response);
			}
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath());
			rd.forward(request, response);
		}

	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (name != null && email != null && password != null) {

			if (!authDAO.procurarPeloEmail(email)) {
				Auth auth = new Auth();
				String hashPassword = auth.hashPassword(password);
				auth.setName(name);
				auth.setEmail(email);
				auth.setPassword(hashPassword);
				
				if(authDAO.inserir(auth)) {
					request.getSession().setAttribute("usuario", auth);
					
					RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
					rd.forward(request, response);					
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					request.setAttribute("msg", "Erro ao inserir os dados");
					rd.forward(request, response);
				}


			} else {
				request.setAttribute("msg", "O email informado já existe!");
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			request.setAttribute("msg", "Preencha todos os campos!");
			rd.forward(request, response);
		}

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email != null && password != null) {

			Auth auth = new Auth();

			auth = authDAO.verifyLogin(email, password);

			if (auth != null) {
				request.getSession().setAttribute("usuario", auth);
				RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
				rd.forward(request, response);

			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Email e/ou senha incorreto(s)!");
				rd.forward(request, response);
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "Preencha todos os campos!");
			rd.forward(request, response);
		}

	}
}
