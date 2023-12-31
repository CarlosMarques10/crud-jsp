<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<nav class="pcoded-navbar">
	<div class="sidebar_toggle">
		<a href="#"><i class="icon-close icons"></i></a>
	</div>

	<div class="pcoded-inner-navbar main-menu">
		<div class="">
			<div class="main-menu-header">
				<img class="img-80 img-radius" src="<%= request.getContextPath() %>/assets/images/avatar-4.jpg"
					alt="User-Profile-Image">
				<div class="user-details">
					<span id="more-details"><%= session.getAttribute("usuario") %><i class="fa fa-caret-down"></i></span>
				</div>
			</div>

			<div class="main-menu-content">
				<ul>
					<li class="more-details"><a href="user-profile.html"><i
							class="ti-user"></i>View Profile</a> <a href="#!"><i
							class="ti-settings"></i>Settings</a> <a
						href="LoginServlet?acao=Logout"><i
							class="ti-layout-sidebar-left"></i>Logout</a></li>
				</ul>
			</div>
		</div>
		<div class="p-15 p-b-0">
			<form class="form-material">
				<div class="form-group form-primary">
					<input type="text" name="footer-email" class="form-control"
						required=""> <span class="form-bar"></span> <label
						class="float-label"><i class="fa fa-search m-r-10"></i>Search
						Friend</label>
				</div>
			</form>
		</div>
		<div class="pcoded-navigation-label"
			data-i18n="nav.category.navigation">Layout</div>
		<ul class="pcoded-item pcoded-left-item">
			<li class="active"><a href="index.html"
				class="waves-effect waves-dark"> <span class="pcoded-micon"><i
						class="ti-home"></i><b>D</b></span> <span class="pcoded-mtext"
					data-i18n="nav.dash.main">Dashboard</span> <span
					class="pcoded-mcaret"></span>
			</a></li>
			<li class="pcoded-hasmenu"><a href="javascript:void(0)"
				class="waves-effect waves-dark"> <span class="pcoded-micon"><i
						class="ti-layout-grid2-alt"></i></span> <span class="pcoded-mtext"
					data-i18n="nav.basic-components.main">Components</span> <span
					class="pcoded-mcaret"></span>
			</a>
				<ul class="pcoded-submenu">
					<li class=" "><a href="<%= request.getContextPath() %>/content/addContact.jsp"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.alert">Criar Contato</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="<%= request.getContextPath() %>/UsuarioServlet?acao=editar&id=<%= request.getSession().getAttribute("usuario") %>"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.breadcrumbs">Editar Contato</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="button.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.alert">Button</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="tabs.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.breadcrumbs">Tabs</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="color.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.alert">Color</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="label-badge.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.breadcrumbs">Label Badge</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="tooltip.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.alert">Tooltip</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="typography.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.breadcrumbs">Typography</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="notification.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.alert">Notification</span> <span
							class="pcoded-mcaret"></span>
					</a></li>
					<li class=" "><a href="icon-themify.html"
						class="waves-effect waves-dark"> <span class="pcoded-micon"><i
								class="ti-angle-right"></i></span> <span class="pcoded-mtext"
							data-i18n="nav.basic-components.breadcrumbs">Themify</span> <span
							class="pcoded-mcaret"></span>
					</a></li>

				</ul></li>
		</ul>
		

		
	</div>
</nav>