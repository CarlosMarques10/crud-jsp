<%@page import="models.Contact"%>
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
										<div class="row">
											<!-- task, page, download counter  start -->


											<h1>Editar Contato</h1>
											<%
											Contact contato = (Contact) request.getAttribute("contato");
											if (contato != null) {
											%>
											<form method="post"
												action="<%=request.getContextPath()%>/ContactServlet?acao=editarAction">
												<input type="hidden" name="id" value="<%= contato.getId()%>">
												<input class="form-control mb-3 limited-width" type="text"
													placeholder="Nome" name="name"
													value="<%=contato.getName()%>"> <input
													class="form-control mb-3 limited-width" type="text"
													placeholder="Email" name="email"
													value="<%=contato.getEmail()%>"> <input
													class="form-control mb-3 limited-width" type="text"
													placeholder="Telefone" name="telefone"
													value="<%=contato.getTelefone()%>">
												<button type="submit" class="btn btn-success btn-width">Atualizar</button>
											</form>
											<%
											} 
											%>


											<!--  project and team member end -->
										</div>
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
