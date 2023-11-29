package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import dao.implement.ContactDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Auth;
import models.Contact;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContactDAO contactDAO = DaoFactory.createContactDAO();

	public ContactServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String acao = request.getParameter("acao");
		
		if(acao != null && !acao.isEmpty()) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(acao.equalsIgnoreCase("editar")) {
				
				Contact contato = contactDAO.procurarPeloId(id);
				if(contato != null) {
					request.setAttribute("contato", contato);
					RequestDispatcher rd = request.getRequestDispatcher("content/editar.jsp");
					rd.forward(request, response);
					return;
				}
				
			}else if(acao.equalsIgnoreCase("excluir")) {
				contactDAO.deletarPeloId(id);
				RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
				rd.forward(request, response);
				return;
			}
			
			
		}else {
			mostrarContatos(request, response);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && !acao.isEmpty()) {

			switch (acao) {

			case "addContact":
				addContact(request, response);
				return;
			case "editarAction":
				editarAction(request, response);
				return;
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("content/addContact.jsp");
		rd.forward(request, response);

	}

	protected void addContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");

		if (name != null && !name.isEmpty()) {

			Auth auth = (Auth) request.getSession().getAttribute("usuario");

			int authId = auth.getId();

			Contact contact = new Contact(name, email, telefone);
			contact.setAuthId(authId);

			boolean insert = contactDAO.inserir(contact);

			if (insert) {
				RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("content/addContact.jsp");
				request.setAttribute("msg", "Erro ao inserir os dados");
				rd.forward(request, response);
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("content/AddContact.jsp");
			request.setAttribute("msg", "O campo nome é obrigatório!");
			rd.forward(request, response);
		}

	}

	protected void mostrarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Auth auth = (Auth) request.getSession().getAttribute("usuario");

		int authId = auth.getId();

		ArrayList<Contact> contatos = contactDAO.mostrarContato(authId);
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
		rd.forward(request, response);
	}
	
	protected void editarAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String id = request.getParameter("id");
		
		int idreq = Integer.parseInt(id);
		
		Contact contato = new Contact(idreq,name,email,telefone);
		
		boolean resp = contactDAO.atualizar(contato);
		
		if(resp) {
			RequestDispatcher rd = request.getRequestDispatcher("content/home.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("content/editar.jsp");
			request.setAttribute("msg", "Erro ao atualizar os dados!");
			rd.forward(request, response);
		}
		
		
	}

}
