<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.tirinnanzi.ivsb.entity.Account" %>
<%@ page import="it.tirinnanzi.ivsb.repository.AccountsRepository" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="sito.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Sito di prova</title>
</head>

<body>

<div class="top">
	<p>Benvenuto ${account.id}</p>
</div>

<center><h1>Sito di prova</h1></center>
<% //C:\Users\danie\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\LoginServlet\ %>

<div>
	<h2>Appuntamenti</h2>
	<table>
		<thead>
            <th>Data</th>
            <th>Ora</th>
            <th>Luogo</th>
         </thead>
            <tbody>
	            <c:forEach items="${appuntamenti}" var="appuntamento">
	            	<tr>
	            		<td>${appuntamento.data}</td>
	            		<td>${appuntamento.ora}</td>
	            		<td>${appuntamento.luogo}</td>
	            		<td><a href="appdel?id=${account.id}&data=${appuntamento.data}&ora=${appuntamento.ora}&luogo=${appuntamento.luogo}">Elimina</a></td>
	            		<td><a href="modApp.jsp?id=${account.id}&data=${appuntamento.data}&ora=${appuntamento.ora}&luogo=${appuntamento.luogo}">Modifica</a></td>
	            	</tr>
	            </c:forEach>
            </tbody>
    </table>
    <p>Per aggiungere nuovi appuntamenti clicca <a href="addApp.jsp">qui</a>!</p>
</div>      

<div>
<h2>Ricerca contatti</h2>
<h4>Scrivi completamente o parzialmente l'username del contatto interessato</h4>

<form method="post" action="ricercaid">

<p> Username: <input name ="idToFind">  <input type = submit value="Ricerca"></p>

</form>

<table>
		<thead>
            <th>Username</th>
         </thead>
            <tbody>
	            <c:forEach items="${findedId}" var="idTrovato">
	            	<tr>
	            		<td>${idTrovato}</td>
	            	</tr>
	            </c:forEach>
            </tbody>
</table>


</div>
</body>

</html>