<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="medical.m2i.model.*" %>
<%@ page import="medical.m2i.dao.PatientDao" %>
<%@ page import="medical.m2i.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des patients</title>
</head>
<body>

<%@ include file="fragments/header.jsp" %>
<main class="container">
<h3>Ici on affiche la liste des patients</h3>

<table class="table table-striped">
<thead>
	<th>ID</th>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Date Naissance</th>
	<th>Adresse</th>
	<th>Pays</th>
	<th>Ville</th>
</thead>
<tbody>
	<%
		PatientDao patientDao = new PatientDao();
		for(Patient p :  patientDao.getPatients()) {
			%>
			
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNom() %></td>
				<td><%= p.getPrenom() %></td>
				<td><%= p.getNaissance() %></td>
				<td><%= p.getAdresse() %></td>
				<td><%= p.getPays() %></td>
				<td><%= p.getVille() %></td>
			</tr>
			<%
		}
	%>
</tbody>
</table>

<a href="patientregister.jsp" class="btn btn-primary">Ajouter un patient</a>

</main>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>