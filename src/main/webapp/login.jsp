<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	<link href="<%= request.getContextPath() %>/assets/css/my-css/authenticate.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center" style="min-height: 100vh; background-color: #f8f9fa;">

    <div class="container text-center">
        <h2 class="mb-4">Login</h2>

        <form method="post" action="AuthenticateServlet?acao=login">
            <input class="form-control mb-3 limited-width" type="email" placeholder="Email" name="email" required>
            <input class="form-control mb-3 limited-width" type="password" placeholder="Senha" name="password" required>
            <button type="submit" class="btn btn-success btn-width">Entrar</button>
        </form>
        
        <div><%= request.getAttribute("msg") %></div>

        <div class="mt-3">Ainda não possui uma conta? <a href="<%= request.getContextPath() %>/register.jsp">Cadastre-se</a></div>
    </div>

    <!-- Scripts do Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-d3N9S+g6XXgHn9M0iXF0WszdFE++L3/iJtA2I8pWqMolXh/y2w/5RU5JqJIKqjQ"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy6pBhIWS9U9BfKgMzQAFEhFbbE5JSc2h"
        crossorigin="anonymous"></script>

</body>
</html>
