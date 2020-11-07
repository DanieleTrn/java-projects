<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.tirinnanzi.ivsb.entity.Account" %>
<%@ page import="it.tirinnanzi.ivsb.repository.AccountsRepository" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione effettuata!</title>
</head>

<body>

<h2>Registrazione completata con successo!</h2>

<p>
Dati account:
</p>
<p>
Username: ${account.id} <br>
Password: ${account.password} <!-- scrivo la password solo per dare un pò di contenuto alla pagina... -->
</p>
<a href= "index.html"><input type="button" value="Home"></a>
</body>

</html>