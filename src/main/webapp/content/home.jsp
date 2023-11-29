<%@page import="models.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>
	<!-- Pre-loader start -->

	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbar-main-menu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->

						<jsp:include page="page-header.jsp"></jsp:include>

						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">
										<!-- task, page, download counter  start -->

										<h1>CONTEUDO</h1>

										<form action="<%=request.getContextPath()%>/ContactServlet"
											method="get">
											<input type="submit" value="Mostrar contatos"
												class="btn btn-success">

										</form>


										<table class="table">
											<thead>
												<tr>
													<th scope="col">Nome</th>
													<th scope="col">EMAIL</th>
													<th scope="col">TELEFONE</th>
												</tr>
											</thead>
											<tbody>
												<%
												ArrayList<Contact> contatos = (ArrayList<Contact>) request.getAttribute("contatos");
												%>
												<%
												if (contatos != null && !contatos.isEmpty()) {
													for (Contact contato : contatos) {
												%>
												<tr>
													<td><%=contato.getName()%></td>
													<td><%=contato.getEmail()%></td>
													<td><%=contato.getTelefone()%></td>
													<td>
														<a href="<%=request.getContextPath()%>/ContactServlet?acao=excluir&id=<%= contato.getId() %>" onclick="return confirm('Deseja excluir este contato?')" class="btn btn-danger">Excluir</a>
														<a href="<%=request.getContextPath()%>/ContactServlet?acao=editar&id=<%= contato.getId() %>" class="btn btn-secondary">Editar</a>
													</td>
												</tr>
												<%
												}
												}
												%>

											</tbody>
										</table>









										<!--  project and team member end -->
									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="jsFile.jsp"></jsp:include>

</body>

</html>
