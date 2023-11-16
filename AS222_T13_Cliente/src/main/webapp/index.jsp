<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" sizes="100x100"
	href="img\Claro.svg.png">
<meta charset="UTF-8" />
<link rel="icon" type="image/x-icon" href="/assets/logo-vt.svg" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Claro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous" />
<style>
.custom-bg {
	background-image: url("img/Imagen1.jpg");
	background-size: cover;
	background-position: center;
}
</style>
</head>
<body class="custom-bg d-flex justify-content-center align-items-center vh-100">
	<div class="bg-white p-5 rounded-5 text-secondary shadow" style="width: 25rem" >
		<div class="d-flex justify-content-center">
			<img src="img\Claro.svg.png" alt="login-icon" style="height: 7rem" />
		</div>
		<div class="text-black text-center fs-1 fw-bold">Ingresar </div>
		<form method="post" action="InicioSession">
			<div class="input-group mt-4">
				<div class="input-group-text bg-danger">
				<img src="img/username-icon.svg" alt="username-icon"
					style="height: 1rem" />
				</div>
				<input class="form-control bg-light"  type="text" name="usuario" />
			</div>
			<div class="input-group mt-1">
				<div class="input-group-text bg-danger">
				<img src="img/password-icon.svg" alt="password-icon"
					style="height: 1rem" />
				</div>
				<input  class="form-control bg-light" type="password" name="password" />
			</div>
			
			
			<div class="btn bg-danger text-white w-100 mt-4 fw-semibold shadow-sm">
				<input type="submit" value="Ingresar" />
			</div>
		</form>

	<c:if test="${not empty error}">
		<div style="padding: 15px; color:red;">
			${error}
		</div>
	</c:if>
	
</body>
</html>
