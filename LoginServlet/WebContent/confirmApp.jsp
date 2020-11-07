<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma appuntamento</title>
</head>
<body>
<form method="post" action="login">
<h3>Appuntamento correttamente inserito</h3>

<p>
Data: ${appuntamento.data}
</p>
<p>
Ora: ${appuntamento.ora}
</p>
<p>
Luogo: ${appuntamento.luogo}
</p>

<input type="hidden" name="username" value="${account.id}">
<input type="hidden" name="password" value="${account.password}">

<input type = submit value="Torna indietro">

</form>
</body>
</html>