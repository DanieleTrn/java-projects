<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica appuntamento</title>
</head>
<body>


<h2>Nuovo appuntamento</h2>

<p><h4>Compila i campi sottostanti</h4></p>

<form method="get" action="appmod">

<p>
Data: <input name="newdata">
</p>
<p>
Ora:<input name="newora">
</p>
<p>
Luogo:<input name="newluogo">
</p>

<input type="hidden" name="id" value="${param.id}">
<input type="hidden" name="data" value="${param.data}">
<input type="hidden" name="ora" value="${param.ora}">
<input type="hidden" name="luogo" value="${param.luogo}">

<input type = submit value="Conferma">
</form>
</body>
</html>