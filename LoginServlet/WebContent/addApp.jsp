<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo appuntamento</title>
</head>
<body>
<h2>Nuovo appuntamento</h2>

<p><h4>Compila i campi sottostanti</h4></p>

<form method="get" action="addmeet">
<p>
Data: <input name="data">
</p>
<p>
Ora:<input name="ora">
</p>
<p>
Luogo:<input name="luogo">
</p>
<input type="hidden" name="username" value="${account.id}">
<input type = submit value="Conferma">
</form>
</body>
</html>